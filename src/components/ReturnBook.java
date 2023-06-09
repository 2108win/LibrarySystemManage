/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package components;

import dao.DBConnection;
import dao.IssueBookDao;
import model.IssueBook;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author dangc
 */
public class ReturnBook extends javax.swing.JInternalFrame {

    /**
     * Creates new form IssueBook
     */
    int book_id, student_id, quantity;
    String book_name, book_author, student_name, branch, year, issue_date, due_date;
    DefaultTableModel model;

    public ReturnBook() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        loadComboIssueID();
        setIssueBookDetails();
    }

    public void loadComboIssueID() {
        txt_ComboIssueID.removeAllItems();
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st
                    .executeQuery(
                            "select issue_id from issue_book_details where (status='Pending' or status='Overdue')");
            while (rs.next()) {
                txt_ComboIssueID.addItem(rs.getString("issue_id"));
            }
            if (txt_ComboIssueID.getItemCount() > 0) {
                fetchBookIssueDetails();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection Error");
        }
    }

    // to fetch data book_details from database
    public void fetchBookIssueDetails() {
        int bookID = Integer.parseInt(txt_BookID.getText());
        int studentID = Integer.parseInt(txt_StudentID.getText());
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con
                    .prepareStatement(
                            "select * from issue_book_details where book_id=? and student_id=? and (status=? or status=?)");
            pst.setInt(1, bookID);
            pst.setInt(2, studentID);
            pst.setString(3, "Pending");
            pst.setString(4, "Overdue");
            ResultSet rs1 = pst.executeQuery();
            if (rs1.next()) {
                txt_ComboIssueID.setSelectedItem(rs1.getString("issue_id"));
                txt_BookName.setText(rs1.getString("book_name"));
                txt_StudentName.setText(rs1.getString("student_name"));
                txt_IssueDate.setText(rs1.getString("issue_date"));
                txt_DueDate.setText(rs1.getString("due_date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // // update book_details table after return book
    // public void updateBookQuantity() {
    // int bookID = Integer.parseInt(txt_BookID.getText());
    // int studentID = Integer.parseInt(txt_StudentID.getText());
    // try {
    // Connection con = DBConnection.getConnection();
    // // get quantity of book
    // PreparedStatement pst = con.prepareStatement("update book_details set
    // quantity=quantity+1 where book_id=?");
    // pst.setInt(1, bookID);
    // PreparedStatement pst1 = con.prepareStatement("update issue_book_details set
    // quantity = quantity + 1 where book_id=? and student_id=? and
    // status='Pending'");
    // pst1.setInt(1, bookID);
    // pst1.setInt(2, studentID);
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // }

    public void loadBookIssueDetails() {
        txt_BookName.setText("");
        txt_StudentName.setText("");
        txt_IssueDate.setText("");
        txt_DueDate.setText("");
        txt_BookID.setText("");
        txt_StudentID.setText("");
        if (txt_ComboIssueID.getItemCount() > 0) {
            if (txt_ComboIssueID.getSelectedItem().toString().equals("")) {
                JOptionPane.showMessageDialog(null, "Please select issue id");
            } else {
                int issueID = Integer.parseInt(txt_ComboIssueID.getSelectedItem().toString());
                try {
                    Connection con = DBConnection.getConnection();
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(
                            "select * from issue_book_details where issue_id=" + issueID
                                    + " and (status='Pending' or status='Overdue')");
                    while (rs.next()) {
                        txt_BookName.setText(rs.getString("book_name"));
                        txt_StudentName.setText(rs.getString("student_name"));
                        txt_IssueDate.setText(rs.getString("issue_date"));
                        txt_DueDate.setText(rs.getString("due_date"));
                        txt_BookID.setText(rs.getString("book_id"));
                        txt_StudentID.setText(rs.getString("student_id"));
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Connection Error");
                }
            }
        }
    }

    public boolean returnBook() {
        boolean isReturned = false;
        int issueID = Integer.parseInt(txt_ComboIssueID.getSelectedItem().toString());
        int book_id = Integer.parseInt(txt_BookID.getText());
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(
                    "update issue_book_details set status=? where issue_id=?");
            pst.setString(1, "Returned");
            pst.setInt(2, issueID);
            pst.executeUpdate();
            // get quantity now
            PreparedStatement pst1 = con.prepareStatement("select quantity from book_details where book_id=?");
            pst1.setInt(1, book_id);
            ResultSet rs = pst1.executeQuery();
            if (rs.next()) {
                quantity = rs.getInt("quantity");
                PreparedStatement pst2 = con.prepareStatement("update book_details set quantity=? where book_id=?");
                pst2.setInt(1, quantity + 1);
                pst2.setInt(2, book_id);
                pst2.executeUpdate();
            }
            isReturned = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isReturned;
    }

    public boolean isIssued() {
        boolean isIssued = false;
        int bookID = Integer.parseInt(txt_BookID.getText());
        int studentID = Integer.parseInt(txt_StudentID.getText());
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con
                    .prepareStatement(
                            "select * from issue_book_details where book_id=? and student_id=? and (status=? or status=?)");
            pst.setInt(1, bookID);
            pst.setInt(2, studentID);
            pst.setString(3, "Pending");
            pst.setString(4, "Overdue");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                isIssued = true;
                txt_ComboIssueID.setSelectedItem(rs.getString("issue_id"));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return isIssued;
    }

    public void setIssueBookDetails() {
        IssueBookDao issueBookDao = new IssueBookDao();
        model = (DefaultTableModel) issueBookDetailsTable.getModel();
        model.setRowCount(0);
        for (IssueBook issueBook : issueBookDao.getPendingIssueBooks()) {
            model.addRow(new Object[] {
                    issueBook.getIssue_id(), issueBook.getBook_id(), issueBook.getBook_name(),
                    issueBook.getStudent_id(), issueBook.getStudent_name(), issueBook.getIssue_date(),
                    issueBook.getDue_date(), issueBook.getStatus()
            });
        }
    }

    // filter
    public void filter(String query) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        issueBookDetailsTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        panelBorder3 = new components.PanelBorder();
        txt_Search = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        panelBorder1 = new components.PanelBorder();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txt_BookName = new javax.swing.JTextField();
        txt_IssueDate = new javax.swing.JTextField();
        txt_DueDate = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txt_StudentName = new javax.swing.JTextField();
        issueDateLabel = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txt_ComboIssueID = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        panelBorder2 = new components.PanelBorder();
        jLabel39 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        returnButton = new com.k33ptoo.components.KButton();
        jLabel37 = new javax.swing.JLabel();
        checkErrorLabel = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txt_StudentID = new javax.swing.JTextField();
        txt_BookID = new javax.swing.JTextField();
        studentNameLabel = new javax.swing.JLabel();
        txt_FeePending = new javax.swing.JLabel();
        panelBorder5 = new components.PanelBorder();
        jScrollPane4 = new javax.swing.JScrollPane();
        issueBookDetailsTable = new rojeru_san.complementos.RSTableMetro();
        jLabel28 = new javax.swing.JLabel();

        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        kGradientPanel2.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        kGradientPanel2.setkBorderRadius(0);
        kGradientPanel2.setkEndColor(new java.awt.Color(204, 204, 204));
        kGradientPanel2.setkStartColor(new java.awt.Color(245, 246, 241));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder3.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_Search.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_Search.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_Search.setMargin(new java.awt.Insets(2, 10, 2, 10));
        txt_Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SearchKeyReleased(evt);
            }
        });
        panelBorder3.add(txt_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 230, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        panelBorder3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        kGradientPanel2.add(panelBorder3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 320, 70));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setBackground(new java.awt.Color(36, 36, 36));
        jLabel25.setFont(new java.awt.Font("DVN-Poppins", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("Issue Book details");
        panelBorder1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        jLabel27.setBackground(new java.awt.Color(36, 36, 36));
        jLabel27.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(36, 36, 36));
        jLabel27.setText("Book Name");
        panelBorder1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        txt_BookName.setEditable(false);
        txt_BookName.setBackground(new java.awt.Color(255, 255, 255));
        txt_BookName.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_BookName.setForeground(new java.awt.Color(36, 36, 36));
        txt_BookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_BookName.setMargin(new java.awt.Insets(2, 10, 2, 10));
        panelBorder1.add(txt_BookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 390, -1));

        txt_IssueDate.setEditable(false);
        txt_IssueDate.setBackground(new java.awt.Color(255, 255, 255));
        txt_IssueDate.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_IssueDate.setForeground(new java.awt.Color(36, 36, 36));
        txt_IssueDate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_IssueDate.setMargin(new java.awt.Insets(2, 10, 2, 10));
        panelBorder1.add(txt_IssueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 390, -1));

        txt_DueDate.setEditable(false);
        txt_DueDate.setBackground(new java.awt.Color(255, 255, 255));
        txt_DueDate.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_DueDate.setForeground(new java.awt.Color(36, 36, 36));
        txt_DueDate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_DueDate.setMargin(new java.awt.Insets(2, 10, 2, 10));
        panelBorder1.add(txt_DueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 390, -1));

        jLabel33.setBackground(new java.awt.Color(36, 36, 36));
        jLabel33.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(36, 36, 36));
        jLabel33.setText("Student Name");
        panelBorder1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        txt_StudentName.setEditable(false);
        txt_StudentName.setBackground(new java.awt.Color(255, 255, 255));
        txt_StudentName.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_StudentName.setForeground(new java.awt.Color(36, 36, 36));
        txt_StudentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_StudentName.setMargin(new java.awt.Insets(2, 10, 2, 10));
        panelBorder1.add(txt_StudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 390, -1));

        issueDateLabel.setBackground(new java.awt.Color(36, 36, 36));
        issueDateLabel.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        issueDateLabel.setForeground(new java.awt.Color(36, 36, 36));
        issueDateLabel.setText("Issue Date");
        panelBorder1.add(issueDateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel38.setBackground(new java.awt.Color(36, 36, 36));
        jLabel38.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(36, 36, 36));
        jLabel38.setText("Due Date");
        panelBorder1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        txt_ComboIssueID.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_ComboIssueID.setForeground(new java.awt.Color(36, 36, 36));
        txt_ComboIssueID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_ComboIssueID.setOpaque(true);
        txt_ComboIssueID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ComboIssueIDActionPerformed(evt);
            }
        });
        panelBorder1.add(txt_ComboIssueID, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 390, -1));

        jLabel30.setBackground(new java.awt.Color(36, 36, 36));
        jLabel30.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(36, 36, 36));
        jLabel30.setText("Issue ID");
        panelBorder1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        kGradientPanel2.add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 570, 380));

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setBackground(new java.awt.Color(36, 36, 36));
        jLabel39.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(36, 36, 36));
        jLabel39.setText("Fee");
        panelBorder2.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jLabel26.setBackground(new java.awt.Color(36, 36, 36));
        jLabel26.setFont(new java.awt.Font("DVN-Poppins", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(36, 36, 36));
        jLabel26.setText("Return Book");
        panelBorder2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jLabel13.setFont(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Return");
        panelBorder2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, -1, -1));

        returnButton.setAlignmentX(0.5F);
        returnButton.setFont(new java.awt.Font("DVN-Poppins", 1, 18)); // NOI18N
        returnButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        returnButton.setIconTextGap(2);
        returnButton.setkBackGroundColor(new java.awt.Color(247, 171, 10));
        returnButton.setkBorderRadius(20);
        returnButton.setkEndColor(new java.awt.Color(255, 255, 255));
        returnButton.setkForeGround(new java.awt.Color(36, 36, 36));
        returnButton.setkHoverEndColor(new java.awt.Color(247, 171, 10));
        returnButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        returnButton.setkHoverStartColor(new java.awt.Color(247, 171, 10));
        returnButton.setkSelectedColor(new java.awt.Color(247, 171, 10));
        returnButton.setkStartColor(new java.awt.Color(247, 171, 10));
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });
        panelBorder2.add(returnButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 140, 40));

        jLabel37.setBackground(new java.awt.Color(36, 36, 36));
        jLabel37.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(36, 36, 36));
        jLabel37.setText("Student ID");
        panelBorder2.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        checkErrorLabel.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        checkErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
        checkErrorLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        checkErrorLabel.setText(" ");
        panelBorder2.add(checkErrorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 270, -1));

        jLabel24.setBackground(new java.awt.Color(36, 36, 36));
        jLabel24.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(36, 36, 36));
        jLabel24.setText("Book ID");
        panelBorder2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        txt_StudentID.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_StudentID.setForeground(new java.awt.Color(36, 36, 36));
        txt_StudentID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_StudentID.setMargin(new java.awt.Insets(2, 10, 2, 10));
        txt_StudentID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_StudentIDFocusLost(evt);
            }
        });
        panelBorder2.add(txt_StudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 170, -1));

        txt_BookID.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_BookID.setForeground(new java.awt.Color(36, 36, 36));
        txt_BookID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_BookID.setMargin(new java.awt.Insets(2, 10, 2, 10));
        txt_BookID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_BookIDFocusLost(evt);
            }
        });
        panelBorder2.add(txt_BookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 170, -1));

        studentNameLabel.setFont(new java.awt.Font("DVN-Poppins", 2, 16)); // NOI18N
        studentNameLabel.setForeground(new java.awt.Color(0, 204, 0));
        studentNameLabel.setText("0.0đ");
        studentNameLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        panelBorder2.add(studentNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 100, 30));

        txt_FeePending.setFont(new java.awt.Font("DVN-Poppins", 3, 16)); // NOI18N
        txt_FeePending.setText("0.0đ");
        txt_FeePending.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        panelBorder2.add(txt_FeePending, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 170, 30));

        kGradientPanel2.add(panelBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 320, 290));

        panelBorder5.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setBorder(null);
        jScrollPane4.setForeground(new java.awt.Color(255, 255, 255));

        issueBookDetailsTable.setForeground(new java.awt.Color(255, 255, 255));
        issueBookDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Book ID", "Book Name", "Student ID", "Student Name", "Issue Date", "Due Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        issueBookDetailsTable.setToolTipText("");
        issueBookDetailsTable.setAlignmentX(0.0F);
        issueBookDetailsTable.setAlignmentY(0.0F);
        issueBookDetailsTable.setColorBackgoundHead(new java.awt.Color(255, 255, 255));
        issueBookDetailsTable.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        issueBookDetailsTable.setColorBordeHead(new java.awt.Color(255, 255, 255));
        issueBookDetailsTable.setColorFilasBackgound1(new java.awt.Color(245, 246, 241));
        issueBookDetailsTable.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        issueBookDetailsTable.setColorFilasForeground1(new java.awt.Color(36, 36, 36));
        issueBookDetailsTable.setColorFilasForeground2(new java.awt.Color(36, 36, 36));
        issueBookDetailsTable.setColorForegroundHead(new java.awt.Color(36, 36, 36));
        issueBookDetailsTable.setColorSelBackgound(new java.awt.Color(255, 204, 204));
        issueBookDetailsTable.setColorSelForeground(new java.awt.Color(36, 36, 36));
        issueBookDetailsTable.setDragEnabled(true);
        issueBookDetailsTable.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        issueBookDetailsTable.setFuenteFilas(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        issueBookDetailsTable.setFuenteFilasSelect(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        issueBookDetailsTable.setFuenteHead(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        issueBookDetailsTable.setGridColor(new java.awt.Color(255, 255, 255));
        issueBookDetailsTable.setRowHeight(34);
        issueBookDetailsTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        issueBookDetailsTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        issueBookDetailsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        issueBookDetailsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                issueBookDetailsTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(issueBookDetailsTable);
        if (issueBookDetailsTable.getColumnModel().getColumnCount() > 0) {
            issueBookDetailsTable.getColumnModel().getColumn(0).setMaxWidth(50);
            issueBookDetailsTable.getColumnModel().getColumn(1).setMinWidth(80);
            issueBookDetailsTable.getColumnModel().getColumn(1).setMaxWidth(80);
            issueBookDetailsTable.getColumnModel().getColumn(3).setMinWidth(80);
            issueBookDetailsTable.getColumnModel().getColumn(3).setMaxWidth(80);
            issueBookDetailsTable.getColumnModel().getColumn(5).setMinWidth(110);
            issueBookDetailsTable.getColumnModel().getColumn(5).setMaxWidth(110);
            issueBookDetailsTable.getColumnModel().getColumn(6).setMinWidth(110);
            issueBookDetailsTable.getColumnModel().getColumn(6).setMaxWidth(110);
            issueBookDetailsTable.getColumnModel().getColumn(7).setMaxWidth(100);
        }

        panelBorder5.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 870, 220));

        jLabel28.setBackground(new java.awt.Color(36, 36, 36));
        jLabel28.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setText("Issue List");
        panelBorder5.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        kGradientPanel2.add(panelBorder5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 910, 290));

        getContentPane().add(kGradientPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_SearchKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txt_SearchKeyReleased
        String search = txt_Search.getText();
        filter(search);
    }// GEN-LAST:event_txt_SearchKeyReleased

    private void issueBookDetailsTableMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_IssueBookDetailsTableMouseClicked
        int row = issueBookDetailsTable.getSelectedRow();
        txt_ComboIssueID.setSelectedItem(issueBookDetailsTable.getValueAt(row, 0).toString());
        txt_BookID.setText(issueBookDetailsTable.getValueAt(row, 1).toString());
        txt_StudentID.setText(issueBookDetailsTable.getValueAt(row, 3).toString());
        txt_BookName.setText(issueBookDetailsTable.getValueAt(row, 2).toString());
        txt_StudentName.setText(issueBookDetailsTable.getValueAt(row, 4).toString());
        txt_IssueDate.setText(issueBookDetailsTable.getValueAt(row, 5).toString());
        txt_DueDate.setText(issueBookDetailsTable.getValueAt(row, 6).toString());
    }// GEN-LAST:event_IssueBookDetailsTableMouseClicked

    private void txt_ComboIssueIDActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txt_ComboIssueIDActionPerformed
        loadBookIssueDetails();
    }// GEN-LAST:event_txt_ComboIssueIDActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_returnButtonActionPerformed
        if (returnBook() == true) {
            loadComboIssueID();
            setIssueBookDetails();
            JOptionPane.showMessageDialog(null, "Book returned");
        } else {
            JOptionPane.showMessageDialog(null, "Book Return Failed");
        }
    }// GEN-LAST:event_returnButtonActionPerformed

    private void txt_StudentIDFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txt_StudentIDFocusLost
        // TODO add your handling code here:
        if (isIssued() == false) {
            checkErrorLabel.setText("ID not found");
        } else {
            checkErrorLabel.setText(" ");
        }
    }// GEN-LAST:event_txt_StudentIDFocusLost

    private void txt_BookIDFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txt_BookIDFocusLost
        // TODO add your handling code here:
        if (isIssued() == false) {
            checkErrorLabel.setText("ID not found");
        } else {
            checkErrorLabel.setText(" ");
        }
    }// GEN-LAST:event_txt_BookIDFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel checkErrorLabel;
    private rojeru_san.complementos.RSTableMetro issueBookDetailsTable;
    private javax.swing.JLabel issueDateLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JScrollPane jScrollPane4;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private components.PanelBorder panelBorder1;
    private components.PanelBorder panelBorder2;
    private components.PanelBorder panelBorder3;
    private components.PanelBorder panelBorder5;
    private com.k33ptoo.components.KButton returnButton;
    private javax.swing.JLabel studentNameLabel;
    private javax.swing.JTextField txt_BookID;
    private javax.swing.JTextField txt_BookName;
    private javax.swing.JComboBox<String> txt_ComboIssueID;
    private javax.swing.JTextField txt_DueDate;
    private javax.swing.JLabel txt_FeePending;
    private javax.swing.JTextField txt_IssueDate;
    private javax.swing.JTextField txt_Search;
    private javax.swing.JTextField txt_StudentID;
    private javax.swing.JTextField txt_StudentName;
    // End of variables declaration//GEN-END:variables

}
