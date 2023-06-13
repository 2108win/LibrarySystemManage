/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package components;

import dao.BooksDao;
import dao.DBConnection;
import dao.StudentsDao;
import model.Books;
import model.Students;

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
public class IssueBook extends javax.swing.JInternalFrame {

    /**
     * Creates new form IssueBook
     */
    int book_id, student_id, quantity;
    String book_name, book_author, student_name, branch, year, issue_date, due_date;

    public IssueBook() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
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
        BooksDao bd = new BooksDao();
        bd.getBookById(bookID);
        Books b = bd.getBookById(bookID);
        txt_ComboBookID.setSelectedItem(txt_BookID.getText());
        txt_BookName.setText(b.getBook_name());
        txt_BookAuthor.setText(b.getAuthor());
        txt_Quantity.setText(String.valueOf(b.getQuantity()));
        txt_BookFee.setText(String.valueOf(b.getBook_fee()));
    }

    public void fetchStudentDetails() {
        int studentID = Integer.parseInt(txt_StudentID.getText());
        StudentsDao sd = new StudentsDao();
        sd.getStudentById(studentID);
        Students s = sd.getStudentById(studentID);
        // change to set selected item
        txt_ComboStudentID.setSelectedItem(txt_StudentID.getText());
        txt_StudentName.setText(s.getStudent_name());
        txt_Branch.setText(s.getBranch());
        txt_Year.setText(s.getYear());
    }

    public void loadBookDetails() {
        int bookID = Integer.parseInt(txt_ComboBookID.getSelectedItem().toString());
        txt_BookID.setText(String.valueOf(bookID));
        BooksDao bd = new BooksDao();
        bd.getBookById(bookID);
        Books b = bd.getBookById(bookID);
        txt_BookName.setText(b.getBook_name());
        txt_BookAuthor.setText(b.getAuthor());
        txt_Quantity.setText(String.valueOf(b.getQuantity()));
        txt_BookFee.setText(String.valueOf(b.getBook_fee()));
    }

    public void loadStudentDetails() {
        int studentID = Integer.parseInt(txt_ComboStudentID.getSelectedItem().toString());
        txt_StudentID.setText(String.valueOf(studentID));
        StudentsDao sd = new StudentsDao();
        sd.getStudentById(studentID);
        Students s = sd.getStudentById(studentID);
        txt_StudentName.setText(s.getStudent_name());
        txt_Branch.setText(s.getBranch());
        txt_Year.setText(s.getYear());
    }

    public boolean issueBook() {
        Date curDate = new Date();
        Long lCurrentDate = curDate.getTime();
        java.sql.Date currentDate = new java.sql.Date(lCurrentDate);
        boolean isIssued = false;
        int bookID = Integer.parseInt(txt_BookID.getText());
        int studentID = Integer.parseInt(txt_StudentID.getText());
        String bookName = txt_BookName.getText();
        String studentName = txt_StudentName.getText();
        Date uIssueDate = txt_IssueDate.getDate();
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
            if (currentDate.compareTo(dueDate) > 0) {
                pst.setString(7, "Overdue");
            } else {
                pst.setString(7, "Pending");
            }
            int i = pst.executeUpdate();
            if (i > 0) {
                isIssued = true;
            } else {
                isIssued = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isIssued;
    }

    public void updateDetail() {
        int bookID = Integer.parseInt(txt_BookID.getText());
        int quantity = Integer.parseInt(txt_Quantity.getText());
        double bookFee = Double.parseDouble(txt_BookFee.getText());
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

            // update fee_pending of user
            try {
                Connection con = DBConnection.getConnection();
                PreparedStatement pst = con.prepareStatement(
                        "update users set fee_pending=fee_pending+?");
                pst.setDouble(1, bookFee);
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
                            "select * from issue_book_details where book_id=? and student_id=? and (status='Pending' or status='Overdue')");
            pst.setInt(1, bookID);
            pst.setInt(2, studentID);
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
    @SuppressWarnings("unchecked")
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
        txt_BookFee = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txt_Quantity = new javax.swing.JTextField();
        panelBorder3 = new components.PanelBorder();
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
        panelBorder2 = new components.PanelBorder();
        txt_ComboStudentID = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txt_StudentName = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txt_Branch = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txt_Year = new javax.swing.JTextField();

        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

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
        panelBorder1.add(txt_ComboBookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 430, -1));

        jLabel25.setBackground(new java.awt.Color(36, 36, 36));
        jLabel25.setFont(new java.awt.Font("DVN-Poppins", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("Book details");
        panelBorder1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

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
        panelBorder1.add(txt_BookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 430, -1));

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
        panelBorder1.add(txt_BookAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 430, -1));

        txt_BookFee.setEditable(false);
        txt_BookFee.setBackground(new java.awt.Color(255, 255, 255));
        txt_BookFee.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_BookFee.setForeground(new java.awt.Color(36, 36, 36));
        txt_BookFee.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_BookFee.setMargin(new java.awt.Insets(2, 10, 2, 10));
        panelBorder1.add(txt_BookFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 430, -1));

        jLabel36.setBackground(new java.awt.Color(36, 36, 36));
        jLabel36.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(36, 36, 36));
        jLabel36.setText("Fee");
        panelBorder1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

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
        panelBorder1.add(txt_Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 430, -1));

        kGradientPanel2.add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 570, 360));

        panelBorder3.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setBackground(new java.awt.Color(36, 36, 36));
        jLabel24.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(36, 36, 36));
        jLabel24.setText("Book ID");
        panelBorder3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel26.setBackground(new java.awt.Color(36, 36, 36));
        jLabel26.setFont(new java.awt.Font("DVN-Poppins", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(36, 36, 36));
        jLabel26.setText("Issue Book");
        panelBorder3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        txt_BookID.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_BookID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_BookID.setMargin(new java.awt.Insets(2, 10, 2, 10));
        txt_BookID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_BookIDFocusLost(evt);
            }
        });
        panelBorder3.add(txt_BookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 260, -1));

        issueDateLabel.setBackground(new java.awt.Color(36, 36, 36));
        issueDateLabel.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        issueDateLabel.setForeground(new java.awt.Color(36, 36, 36));
        issueDateLabel.setText("Issue Date");
        panelBorder3.add(issueDateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        txt_StudentID.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_StudentID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_StudentID.setMargin(new java.awt.Insets(2, 10, 2, 10));
        txt_StudentID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_StudentIDFocusLost(evt);
            }
        });
        panelBorder3.add(txt_StudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 260, -1));

        jLabel13.setFont(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(245, 246, 241));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Add");
        panelBorder3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 640, -1, -1));

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
        panelBorder3.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 630, 130, 40));

        jLabel37.setBackground(new java.awt.Color(36, 36, 36));
        jLabel37.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(36, 36, 36));
        jLabel37.setText("Student ID");
        panelBorder3.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel38.setBackground(new java.awt.Color(36, 36, 36));
        jLabel38.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(36, 36, 36));
        jLabel38.setText("Due Date");
        panelBorder3.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        txt_DueDate.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        panelBorder3.add(txt_DueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 260, 40));

        txt_IssueDate.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        panelBorder3.add(txt_IssueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 260, 40));

        checkErrorLabel.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        checkErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
        checkErrorLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        checkErrorLabel.setText(" ");
        panelBorder3.add(checkErrorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 170, -1));

        kGradientPanel2.add(panelBorder3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 320, 690));

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_ComboStudentID.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_ComboStudentID.setForeground(new java.awt.Color(36, 36, 36));
        txt_ComboStudentID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_ComboStudentID.setOpaque(true);
        txt_ComboStudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ComboStudentIDActionPerformed(evt);
            }
        });
        panelBorder2.add(txt_ComboStudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 430, -1));

        jLabel31.setBackground(new java.awt.Color(36, 36, 36));
        jLabel31.setFont(new java.awt.Font("DVN-Poppins", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(102, 102, 102));
        jLabel31.setText("Student detaills");
        panelBorder2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        jLabel32.setBackground(new java.awt.Color(36, 36, 36));
        jLabel32.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(36, 36, 36));
        jLabel32.setText("Student ID");
        panelBorder2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel33.setBackground(new java.awt.Color(36, 36, 36));
        jLabel33.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(36, 36, 36));
        jLabel33.setText("Name");
        panelBorder2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        txt_StudentName.setEditable(false);
        txt_StudentName.setBackground(new java.awt.Color(255, 255, 255));
        txt_StudentName.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_StudentName.setForeground(new java.awt.Color(36, 36, 36));
        txt_StudentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_StudentName.setMargin(new java.awt.Insets(2, 10, 2, 10));
        panelBorder2.add(txt_StudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 430, -1));

        jLabel34.setBackground(new java.awt.Color(36, 36, 36));
        jLabel34.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(36, 36, 36));
        jLabel34.setText("Branch");
        panelBorder2.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        txt_Branch.setEditable(false);
        txt_Branch.setBackground(new java.awt.Color(255, 255, 255));
        txt_Branch.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_Branch.setForeground(new java.awt.Color(36, 36, 36));
        txt_Branch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_Branch.setMargin(new java.awt.Insets(2, 10, 2, 10));
        panelBorder2.add(txt_Branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 430, -1));

        jLabel35.setBackground(new java.awt.Color(36, 36, 36));
        jLabel35.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(36, 36, 36));
        jLabel35.setText("Year");
        panelBorder2.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        txt_Year.setEditable(false);
        txt_Year.setBackground(new java.awt.Color(255, 255, 255));
        txt_Year.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_Year.setForeground(new java.awt.Color(36, 36, 36));
        txt_Year.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_Year.setMargin(new java.awt.Insets(2, 10, 2, 10));
        panelBorder2.add(txt_Year, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 430, -1));

        kGradientPanel2.add(panelBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 570, 310));

        getContentPane().add(kGradientPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_ComboBookIDActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txt_ComboBookIDActionPerformed
        loadBookDetails();
    }// GEN-LAST:event_txt_ComboBookIDActionPerformed

    private void txt_BookIDFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txt_BookIDFocusLost
        fetchBookDetails();
    }// GEN-LAST:event_txt_BookIDFocusLost

    private void txt_StudentIDFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txt_StudentIDFocusLost
        fetchStudentDetails();
    }// GEN-LAST:event_txt_StudentIDFocusLost

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addButtonActionPerformed
        while (checkDueDate()) {
            if (isAlreadyIssue() == false) {
                checkDueDate();
                if (issueBook() == true) {
                    JOptionPane.showMessageDialog(null, "Book Issued Successfully");
                    updateDetail();
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

    private void txt_ComboStudentIDActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txt_ComboStudentIDActionPerformed
        loadStudentDetails();
    }// GEN-LAST:event_txt_ComboStudentIDActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton addButton;
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
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private components.PanelBorder panelBorder1;
    private components.PanelBorder panelBorder2;
    private components.PanelBorder panelBorder3;
    private javax.swing.JTextField txt_BookAuthor;
    private javax.swing.JTextField txt_BookFee;
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
