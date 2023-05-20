/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package save;

import view.HomePage;
import dao.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 *
 * @author dangc
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    int book_id, student_id, quantity;
    String book_name, book_author, student_name, branch, year, issue_date, due_date;

    public IssueBook() {
        initComponents();
        loadComboBookID();
        loadComboStudentID();
        loadIssueDateNow();
    }

    public void loadIssueDateNow() {
        Date d = new Date();
        txt_IssueDate.setDate(d);
    }

    public boolean checkDueDate() {
        boolean isDueDate = false;
        Date issueDate = txt_IssueDate.getDate();
        Date dueDate = txt_DueDate.getDate();
        checkErrorLabel.setText("*Due date error");
        if (dueDate.compareTo(issueDate) >= 0) {
            isDueDate = true;
            checkErrorLabel.setText(" ");
        }
        return isDueDate;
    }

    public void loadComboBookID() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select book_id from book_details");
            while (rs.next()) {
                txt_ComboBookID.addItem(rs.getString("book_id"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection Error");
        }
    }

    public void loadComboStudentID() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select student_id from student_details");
            while (rs.next()) {
                txt_ComboStudentID.addItem(rs.getString("student_id"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection Error");
        }
    }

    // to fetch data book_details from database
    public void fetchBookDetails() {
        int bookID = Integer.parseInt(txt_BookID.getText());
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from book_details where book_id=?");
            pst.setInt(1, bookID);
            ResultSet rs1 = pst.executeQuery();
            if (rs1.next()) {
                txt_ComboBookID.setSelectedItem(rs1.getString("book_id"));
                txt_BookName.setText(rs1.getString("book_name"));
                txt_BookAuthor.setText(rs1.getString("author"));
                txt_Quantity.setText(rs1.getString("quantity"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection Error");
        }
    }

    public void fetchStudentDetails() {
        int studentID = Integer.parseInt(txt_StudentID.getText());
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from student_details where student_id=?");
            pst.setInt(1, studentID);
            ResultSet rs1 = pst.executeQuery();
            if (rs1.next()) {
                txt_ComboStudentID.setSelectedItem(rs1.getString("student_id"));
                txt_StudentName.setText(rs1.getString("student_name"));
                txt_Branch.setText(rs1.getString("branch"));
                txt_Year.setText(rs1.getString("year"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection Error");
        }
    }

    public void loadBookDetails() {
        int bookID = Integer.parseInt(txt_ComboBookID.getSelectedItem().toString());
        txt_BookID.setText(String.valueOf(bookID));
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from book_details where book_id=" + bookID + "");
            while (rs.next()) {
                txt_BookName.setText(rs.getString("book_name"));
                txt_BookAuthor.setText(rs.getString("author"));
                txt_Quantity.setText(rs.getString("quantity"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection Error");
        }
    }

    public void loadStudentDetails() {
        int studentID = Integer.parseInt(txt_ComboStudentID.getSelectedItem().toString());
        txt_StudentID.setText(String.valueOf(studentID));
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student_details where student_id=" + studentID + "");
            while (rs.next()) {
                txt_StudentName.setText(rs.getString("student_name"));
                txt_Branch.setText(rs.getString("branch"));
                txt_Year.setText(rs.getString("year"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection Error");
        }
    }

    public boolean issueBook() {
        boolean isIssued = false;
        int bookID = Integer.parseInt(txt_BookID.getText());
        int studentID = Integer.parseInt(txt_StudentID.getText());
        String bookName = txt_BookName.getText();
        String studentName = txt_StudentName.getText();
        Date uIssueDate = txt_DueDate.getDate();
        Date uDueDate = txt_DueDate.getDate();
        Long l1 = uIssueDate.getTime();
        Long l2 = uDueDate.getTime();
        java.sql.Date issueDate = new java.sql.Date(l1);
        java.sql.Date dueDate = new java.sql.Date(l2);
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(
                    "insert into issue_book_details(book_id,book_name,student_id,student_name,issue_date,due_date,status) values(?,?,?,?,?,?,?)");
            pst.setInt(1, bookID);
            pst.setString(2, bookName);
            pst.setInt(3, studentID);
            pst.setString(4, studentName);
            pst.setDate(5, issueDate);
            pst.setDate(6, dueDate);
            pst.setString(7, "Pending");
            int i = pst.executeUpdate();
            if (i > 0) {
                isIssued = true;
            } else {
                isIssued = false;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return isIssued;
    }

    public void updateBookQuantity() {
        int bookID = Integer.parseInt(txt_BookID.getText());
        int quantity = Integer.parseInt(txt_Quantity.getText());
        int newQuantity = quantity - 1;
        if (newQuantity >= 0) {
            try {
                Connection con = DBConnection.getConnection();
                PreparedStatement pst = con.prepareStatement("update book_details set quantity=? where book_id=?");
                pst.setInt(1, newQuantity);
                pst.setInt(2, bookID);
                pst.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Book is not available");
        }
    }

    public boolean isAlreadyIssue() {
        boolean isAlreadyIssued = false;
        int bookID = Integer.parseInt(txt_BookID.getText());
        int studentID = Integer.parseInt(txt_StudentID.getText());
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con
                    .prepareStatement(
                            "select * from issue_book_details where book_id=? and student_id=? and status=?");
            pst.setInt(1, bookID);
            pst.setInt(2, studentID);
            pst.setString(3, "Pending");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                isAlreadyIssued = true;
            } else {
                isAlreadyIssued = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAlreadyIssued;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
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
        panelBorder1 = new components.PanelBorder();
        txt_ComboBookID = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txt_BookName = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txt_BookAuthor = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txt_Quantity = new javax.swing.JTextField();
        panelPieChart1 = new com.k33ptoo.components.KGradientPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txt_BookID = new javax.swing.JTextField();
        issueDateLabel = new javax.swing.JLabel();
        txt_StudentID = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        addButton = new com.k33ptoo.components.KButton();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txt_DueDate = new com.toedter.calendar.JDateChooser();
        txt_IssueDate = new com.toedter.calendar.JDateChooser();
        checkErrorLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        backButton = new com.k33ptoo.components.KButton();
        kGradientPanel10 = new com.k33ptoo.components.KGradientPanel();
        txt_ComboStudentID = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txt_StudentName = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txt_Branch = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txt_Year = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel2.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        kGradientPanel2.setkBorderRadius(0);
        kGradientPanel2.setkEndColor(new java.awt.Color(204, 204, 204));
        kGradientPanel2.setkStartColor(new java.awt.Color(245, 246, 241));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_ComboBookID.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_ComboBookID.setForeground(new java.awt.Color(36, 36, 36));
        txt_ComboBookID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_ComboBookID.setOpaque(true);
        txt_ComboBookID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ComboBookIDActionPerformed(evt);
            }
        });
        panelBorder1.add(txt_ComboBookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 310, -1));

        jLabel25.setBackground(new java.awt.Color(36, 36, 36));
        jLabel25.setFont(new java.awt.Font("DVN-Poppins", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("Book details");
        panelBorder1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        jLabel30.setBackground(new java.awt.Color(36, 36, 36));
        jLabel30.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(36, 36, 36));
        jLabel30.setText("Book ID");
        panelBorder1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel27.setBackground(new java.awt.Color(36, 36, 36));
        jLabel27.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(36, 36, 36));
        jLabel27.setText("Name");
        panelBorder1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        txt_BookName.setEditable(false);
        txt_BookName.setBackground(new java.awt.Color(255, 255, 255));
        txt_BookName.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_BookName.setForeground(new java.awt.Color(36, 36, 36));
        txt_BookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_BookName.setMargin(new java.awt.Insets(2, 10, 2, 10));
        panelBorder1.add(txt_BookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 310, -1));

        jLabel28.setBackground(new java.awt.Color(36, 36, 36));
        jLabel28.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(36, 36, 36));
        jLabel28.setText("Author");
        panelBorder1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        txt_BookAuthor.setEditable(false);
        txt_BookAuthor.setBackground(new java.awt.Color(255, 255, 255));
        txt_BookAuthor.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_BookAuthor.setForeground(new java.awt.Color(36, 36, 36));
        txt_BookAuthor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_BookAuthor.setMargin(new java.awt.Insets(2, 10, 2, 10));
        panelBorder1.add(txt_BookAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 310, -1));

        jLabel29.setBackground(new java.awt.Color(36, 36, 36));
        jLabel29.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(36, 36, 36));
        jLabel29.setText("Quantity");
        panelBorder1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        txt_Quantity.setEditable(false);
        txt_Quantity.setBackground(new java.awt.Color(255, 255, 255));
        txt_Quantity.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_Quantity.setForeground(new java.awt.Color(36, 36, 36));
        txt_Quantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_Quantity.setMargin(new java.awt.Insets(2, 10, 2, 10));
        panelBorder1.add(txt_Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 310, -1));

        kGradientPanel2.add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 460, 300));

        panelPieChart1.setkBorderRadius(20);
        panelPieChart1.setkEndColor(new java.awt.Color(255, 255, 255));
        panelPieChart1.setkStartColor(new java.awt.Color(255, 255, 255));
        panelPieChart1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setBackground(new java.awt.Color(36, 36, 36));
        jLabel24.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(36, 36, 36));
        jLabel24.setText("Book ID");
        panelPieChart1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel26.setBackground(new java.awt.Color(36, 36, 36));
        jLabel26.setFont(new java.awt.Font("DVN-Poppins", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(36, 36, 36));
        jLabel26.setText("Issue Book");
        panelPieChart1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        txt_BookID.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_BookID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_BookID.setMargin(new java.awt.Insets(2, 10, 2, 10));
        txt_BookID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_BookIDFocusLost(evt);
            }
        });
        panelPieChart1.add(txt_BookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 370, -1));

        issueDateLabel.setBackground(new java.awt.Color(36, 36, 36));
        issueDateLabel.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        issueDateLabel.setForeground(new java.awt.Color(36, 36, 36));
        issueDateLabel.setText("Issue Date");
        panelPieChart1.add(issueDateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        txt_StudentID.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_StudentID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_StudentID.setMargin(new java.awt.Insets(2, 10, 2, 10));
        txt_StudentID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_StudentIDFocusLost(evt);
            }
        });
        panelPieChart1.add(txt_StudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 370, -1));

        jLabel13.setFont(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(245, 246, 241));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setLabelFor(addButton);
        jLabel13.setText("Add");
        panelPieChart1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 570, -1, -1));

        addButton.setAlignmentX(0.5F);
        addButton.setFont(new java.awt.Font("DVN-Poppins", 1, 18)); // NOI18N
        addButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addButton.setIconTextGap(2);
        addButton.setkBackGroundColor(new java.awt.Color(247, 171, 10));
        addButton.setkBorderRadius(20);
        addButton.setkEndColor(new java.awt.Color(255, 255, 255));
        addButton.setkForeGround(new java.awt.Color(36, 36, 36));
        addButton.setkHoverEndColor(new java.awt.Color(247, 171, 10));
        addButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        addButton.setkHoverStartColor(new java.awt.Color(247, 171, 10));
        addButton.setkSelectedColor(new java.awt.Color(247, 171, 10));
        addButton.setkStartColor(new java.awt.Color(247, 171, 10));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        panelPieChart1.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 560, 130, 40));

        jLabel37.setBackground(new java.awt.Color(36, 36, 36));
        jLabel37.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(36, 36, 36));
        jLabel37.setText("Student ID");
        panelPieChart1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel38.setBackground(new java.awt.Color(36, 36, 36));
        jLabel38.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(36, 36, 36));
        jLabel38.setText("Due Date");
        panelPieChart1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        txt_DueDate.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        panelPieChart1.add(txt_DueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 370, 40));

        txt_IssueDate.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        panelPieChart1.add(txt_IssueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 370, 40));

        checkErrorLabel.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        checkErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
        checkErrorLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        checkErrorLabel.setText(" ");
        panelPieChart1.add(checkErrorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 280, -1));

        kGradientPanel2.add(panelPieChart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 430, 620));

        jLabel4.setFont(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back.png"))); // NOI18N
        jLabel4.setText("   Back to Home");
        kGradientPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        backButton.setAlignmentX(0.5F);
        backButton.setFont(new java.awt.Font("DVN-Poppins", 1, 18)); // NOI18N
        backButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        backButton.setIconTextGap(2);
        backButton.setkBackGroundColor(new java.awt.Color(247, 171, 10));
        backButton.setkBorderRadius(20);
        backButton.setkEndColor(new java.awt.Color(247, 171, 10));
        backButton.setkForeGround(new java.awt.Color(36, 36, 36));
        backButton.setkHoverColor(new java.awt.Color(204, 204, 204));
        backButton.setkHoverEndColor(new java.awt.Color(247, 171, 10));
        backButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        backButton.setkHoverStartColor(new java.awt.Color(204, 204, 204));
        backButton.setkSelectedColor(new java.awt.Color(247, 171, 10));
        backButton.setkStartColor(new java.awt.Color(247, 171, 10));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        kGradientPanel2.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 190, -1));

        kGradientPanel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        kGradientPanel10.setForeground(new java.awt.Color(255, 255, 255));
        kGradientPanel10.setkBorderRadius(20);
        kGradientPanel10.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel10.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_ComboStudentID.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_ComboStudentID.setForeground(new java.awt.Color(36, 36, 36));
        txt_ComboStudentID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_ComboStudentID.setOpaque(true);
        txt_ComboStudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ComboStudentIDActionPerformed(evt);
            }
        });
        kGradientPanel10.add(txt_ComboStudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 310, -1));

        jLabel31.setBackground(new java.awt.Color(36, 36, 36));
        jLabel31.setFont(new java.awt.Font("DVN-Poppins", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(102, 102, 102));
        jLabel31.setText("Student detaills");
        kGradientPanel10.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        jLabel32.setBackground(new java.awt.Color(36, 36, 36));
        jLabel32.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(36, 36, 36));
        jLabel32.setText("Student ID");
        kGradientPanel10.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel33.setBackground(new java.awt.Color(36, 36, 36));
        jLabel33.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(36, 36, 36));
        jLabel33.setText("Name");
        kGradientPanel10.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        txt_StudentName.setEditable(false);
        txt_StudentName.setBackground(new java.awt.Color(255, 255, 255));
        txt_StudentName.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_StudentName.setForeground(new java.awt.Color(36, 36, 36));
        txt_StudentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_StudentName.setMargin(new java.awt.Insets(2, 10, 2, 10));
        kGradientPanel10.add(txt_StudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 310, -1));

        jLabel34.setBackground(new java.awt.Color(36, 36, 36));
        jLabel34.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(36, 36, 36));
        jLabel34.setText("Branch");
        kGradientPanel10.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        txt_Branch.setEditable(false);
        txt_Branch.setBackground(new java.awt.Color(255, 255, 255));
        txt_Branch.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_Branch.setForeground(new java.awt.Color(36, 36, 36));
        txt_Branch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_Branch.setMargin(new java.awt.Insets(2, 10, 2, 10));
        kGradientPanel10.add(txt_Branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 310, -1));

        jLabel35.setBackground(new java.awt.Color(36, 36, 36));
        jLabel35.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(36, 36, 36));
        jLabel35.setText("Year");
        kGradientPanel10.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        txt_Year.setEditable(false);
        txt_Year.setBackground(new java.awt.Color(255, 255, 255));
        txt_Year.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_Year.setForeground(new java.awt.Color(36, 36, 36));
        txt_Year.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_Year.setMargin(new java.awt.Insets(2, 10, 2, 10));
        kGradientPanel10.add(txt_Year, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 310, -1));

        kGradientPanel2.add(kGradientPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 460, 300));

        getContentPane().add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 730));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addButtonActionPerformed
        while (checkDueDate()) {
            if (isAlreadyIssue() == false) {
                checkDueDate();
                if (issueBook() == true) {
                    JOptionPane.showMessageDialog(null, "Book Issued Successfully");
                    updateBookQuantity();
                    loadBookDetails();
                } else {
                    JOptionPane.showMessageDialog(null, "Book Issue Failed");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Book Already Issued");
            }
            break;
        }
    }// GEN-LAST:event_addButtonActionPerformed

    private void txt_StudentIDFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txt_StudentIDFocusLost
        // TODO add your handling code here:
        fetchStudentDetails();
    }// GEN-LAST:event_txt_StudentIDFocusLost

    private void txt_ComboStudentIDActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txt_ComboStudentIDActionPerformed
        loadStudentDetails();
    }// GEN-LAST:event_txt_ComboStudentIDActionPerformed

    private void txt_ComboBookIDActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txt_ComboBookIDActionPerformed
        loadBookDetails();
    }// GEN-LAST:event_txt_ComboBookIDActionPerformed

    private void txt_BookIDFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txt_BookIDFocusLost
        fetchBookDetails();
    }// GEN-LAST:event_txt_BookIDFocusLost

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_backButtonActionPerformed
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }// GEN-LAST:event_backButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton addButton;
    private com.k33ptoo.components.KButton backButton;
    private javax.swing.JLabel checkErrorLabel;
    private javax.swing.JLabel issueDateLabel;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private com.k33ptoo.components.KGradientPanel kGradientPanel10;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private components.PanelBorder panelBorder1;
    private com.k33ptoo.components.KGradientPanel panelPieChart1;
    private javax.swing.JTextField txt_BookAuthor;
    private javax.swing.JTextField txt_BookID;
    private javax.swing.JTextField txt_BookName;
    private javax.swing.JTextField txt_Branch;
    private javax.swing.JComboBox<String> txt_ComboBookID;
    private javax.swing.JComboBox<String> txt_ComboStudentID;
    private com.toedter.calendar.JDateChooser txt_DueDate;
    private com.toedter.calendar.JDateChooser txt_IssueDate;
    private javax.swing.JTextField txt_Quantity;
    private javax.swing.JTextField txt_StudentID;
    private javax.swing.JTextField txt_StudentName;
    private javax.swing.JTextField txt_Year;
    // End of variables declaration//GEN-END:variables
}
