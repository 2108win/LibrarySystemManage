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

import javax.swing.JOptionPane;

/**
 *
 * @author dangc
 */
public class ReturnBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    int book_id, student_id, quantity;
    String book_name, book_author, student_name, branch, year, issue_date, due_date;

    public ReturnBook() {
        initComponents();
        loadComboIssueID();
    }

    public void loadComboIssueID() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select issue_id from issue_book_details where status='Pending'");
            while (rs.next()) {
                txt_ComboIssueID.addItem(rs.getString("issue_id"));
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
                    .prepareStatement("select * from issue_book_details where book_id=? and student_id=? and status=?");
            pst.setInt(1, bookID);
            pst.setInt(2, studentID);
            pst.setString(3, "Pending");
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

    // update book_details table after return book
    public void updateBookQuantity() {
        int bookID = Integer.parseInt(txt_BookID.getText());
        try {
            Connection con = DBConnection.getConnection();
            // get quantity of book
            PreparedStatement pst1 = con.prepareStatement("select quantity from book_details where book_id=?");
            pst1.setInt(1, bookID);
            while (pst1.executeQuery().next()) {
                quantity = pst1.executeQuery().getInt("quantity");
            }
            PreparedStatement pst = con
                    .prepareStatement("update book_details set quantity=? where book_id=? and status=?");
            pst.setInt(1, quantity + 1);
            pst.setInt(2, bookID);
            pst.setString(3, "Returned");
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadBookIssueDetails() {
        int issueID = Integer.parseInt(txt_ComboIssueID.getSelectedItem().toString());
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                    "select * from issue_book_details where issue_id=" + issueID + " and status='Pending'");
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

    public boolean returnBook() {
        boolean isReturned = false;
        int issueID = Integer.parseInt(txt_ComboIssueID.getSelectedItem().toString());
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("update issue_book_details set status=? where issue_id=?");
            pst.setString(1, "Returned");
            pst.setInt(2, issueID);
            pst.executeUpdate();
            updateBookQuantity();
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
                    .prepareStatement("select * from issue_book_details where book_id=? and student_id=? and status=?");
            pst.setInt(1, bookID);
            pst.setInt(2, studentID);
            pst.setString(3, "Pending");
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
    // <editor-fold defaultstate="coll∆apsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        kGradientPanel9 = new com.k33ptoo.components.KGradientPanel();
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
        returnBookGroup = new com.k33ptoo.components.KGradientPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        returnButton = new com.k33ptoo.components.KButton();
        jLabel37 = new javax.swing.JLabel();
        checkErrorLabel = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txt_StudentID = new javax.swing.JTextField();
        txt_BookID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        backButton = new com.k33ptoo.components.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel2.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        kGradientPanel2.setkBorderRadius(0);
        kGradientPanel2.setkEndColor(new java.awt.Color(204, 204, 204));
        kGradientPanel2.setkStartColor(new java.awt.Color(245, 246, 241));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        kGradientPanel9.setForeground(new java.awt.Color(255, 255, 255));
        kGradientPanel9.setkBorderRadius(20);
        kGradientPanel9.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel9.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setBackground(new java.awt.Color(36, 36, 36));
        jLabel25.setFont(new java.awt.Font("DVN-Poppins", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("Issue Book details");
        kGradientPanel9.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        jLabel27.setBackground(new java.awt.Color(36, 36, 36));
        jLabel27.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(36, 36, 36));
        jLabel27.setText("Book Name");
        kGradientPanel9.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        txt_BookName.setEditable(false);
        txt_BookName.setBackground(new java.awt.Color(255, 255, 255));
        txt_BookName.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_BookName.setForeground(new java.awt.Color(36, 36, 36));
        txt_BookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_BookName.setMargin(new java.awt.Insets(2, 10, 2, 10));
        kGradientPanel9.add(txt_BookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 290, -1));

        txt_IssueDate.setEditable(false);
        txt_IssueDate.setBackground(new java.awt.Color(255, 255, 255));
        txt_IssueDate.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_IssueDate.setForeground(new java.awt.Color(36, 36, 36));
        txt_IssueDate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_IssueDate.setMargin(new java.awt.Insets(2, 10, 2, 10));
        kGradientPanel9.add(txt_IssueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 290, -1));

        txt_DueDate.setEditable(false);
        txt_DueDate.setBackground(new java.awt.Color(255, 255, 255));
        txt_DueDate.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_DueDate.setForeground(new java.awt.Color(36, 36, 36));
        txt_DueDate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_DueDate.setMargin(new java.awt.Insets(2, 10, 2, 10));
        kGradientPanel9.add(txt_DueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 290, -1));

        jLabel33.setBackground(new java.awt.Color(36, 36, 36));
        jLabel33.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(36, 36, 36));
        jLabel33.setText("Student Name");
        kGradientPanel9.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        txt_StudentName.setEditable(false);
        txt_StudentName.setBackground(new java.awt.Color(255, 255, 255));
        txt_StudentName.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_StudentName.setForeground(new java.awt.Color(36, 36, 36));
        txt_StudentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_StudentName.setMargin(new java.awt.Insets(2, 10, 2, 10));
        kGradientPanel9.add(txt_StudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 290, -1));

        issueDateLabel.setBackground(new java.awt.Color(36, 36, 36));
        issueDateLabel.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        issueDateLabel.setForeground(new java.awt.Color(36, 36, 36));
        issueDateLabel.setText("Issue Date");
        kGradientPanel9.add(issueDateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel38.setBackground(new java.awt.Color(36, 36, 36));
        jLabel38.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(36, 36, 36));
        jLabel38.setText("Due Date");
        kGradientPanel9.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        txt_ComboIssueID.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_ComboIssueID.setForeground(new java.awt.Color(36, 36, 36));
        txt_ComboIssueID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_ComboIssueID.setOpaque(true);
        txt_ComboIssueID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ComboIssueIDActionPerformed(evt);
            }
        });
        kGradientPanel9.add(txt_ComboIssueID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 290, -1));

        jLabel30.setBackground(new java.awt.Color(36, 36, 36));
        jLabel30.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(36, 36, 36));
        jLabel30.setText("Issue ID");
        kGradientPanel9.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        kGradientPanel2.add(kGradientPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 460, 380));

        returnBookGroup.setkBorderRadius(20);
        returnBookGroup.setkEndColor(new java.awt.Color(255, 255, 255));
        returnBookGroup.setkStartColor(new java.awt.Color(255, 255, 255));
        returnBookGroup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setBackground(new java.awt.Color(36, 36, 36));
        jLabel26.setFont(new java.awt.Font("DVN-Poppins", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(36, 36, 36));
        jLabel26.setText("Return Book");
        returnBookGroup.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        jLabel13.setFont(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(245, 246, 241));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setLabelFor(returnButton);
        jLabel13.setText("Return");
        returnBookGroup.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, -1, -1));

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
        returnBookGroup.add(returnButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 140, 40));

        jLabel37.setBackground(new java.awt.Color(36, 36, 36));
        jLabel37.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(36, 36, 36));
        jLabel37.setText("Student ID");
        returnBookGroup.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        checkErrorLabel.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        checkErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
        checkErrorLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        checkErrorLabel.setText(" ");
        returnBookGroup.add(checkErrorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 280, -1));

        jLabel24.setBackground(new java.awt.Color(36, 36, 36));
        jLabel24.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(36, 36, 36));
        jLabel24.setText("Book ID");
        returnBookGroup.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        txt_StudentID.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_StudentID.setForeground(new java.awt.Color(36, 36, 36));
        txt_StudentID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_StudentID.setMargin(new java.awt.Insets(2, 10, 2, 10));
        txt_StudentID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_StudentIDFocusLost(evt);
            }
        });
        returnBookGroup.add(txt_StudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 280, -1));

        txt_BookID.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_BookID.setForeground(new java.awt.Color(36, 36, 36));
        txt_BookID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_BookID.setMargin(new java.awt.Insets(2, 10, 2, 10));
        txt_BookID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_BookIDFocusLost(evt);
            }
        });
        returnBookGroup.add(txt_BookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 280, -1));

        kGradientPanel2.add(returnBookGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 430, 290));

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

        getContentPane().add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 730));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_BookIDFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txt_BookIDFocusLost
        // TODO add your handling code here:
        if (isIssued() == false) {
            checkErrorLabel.setText("ID not found");
        } else {
            checkErrorLabel.setText(" ");
        }
    }// GEN-LAST:event_txt_BookIDFocusLost

    private void txt_StudentIDFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txt_StudentIDFocusLost
        // TODO add your handling code here:
        if (isIssued() == false) {
            checkErrorLabel.setText("ID not found");
        } else {
            checkErrorLabel.setText(" ");
        }
    }// GEN-LAST:event_txt_StudentIDFocusLost

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_returnButtonActionPerformed
        // TODO add your handling code here:
        if (returnBook() == true) {
            loadBookIssueDetails();
            JOptionPane.showMessageDialog(null, "Book returned");
            loadComboIssueID();
        } else {
            JOptionPane.showMessageDialog(null, "Book Return Failed");
        }
    }// GEN-LAST:event_returnButtonActionPerformed

    private void txt_ComboIssueIDActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txt_ComboIssueIDActionPerformed
        loadBookIssueDetails();
    }// GEN-LAST:event_txt_ComboIssueIDActionPerformed

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
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton backButton;
    private javax.swing.JLabel checkErrorLabel;
    private javax.swing.JLabel issueDateLabel;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private com.k33ptoo.components.KGradientPanel kGradientPanel9;
    private com.k33ptoo.components.KGradientPanel returnBookGroup;
    private com.k33ptoo.components.KButton returnButton;
    private javax.swing.JTextField txt_BookID;
    private javax.swing.JTextField txt_BookName;
    private javax.swing.JComboBox<String> txt_ComboIssueID;
    private javax.swing.JTextField txt_DueDate;
    private javax.swing.JTextField txt_IssueDate;
    private javax.swing.JTextField txt_StudentID;
    private javax.swing.JTextField txt_StudentName;
    // End of variables declaration//GEN-END:variables
}
