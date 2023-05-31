/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package components;

import dao.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author winlax
 */
public class HomePage extends javax.swing.JInternalFrame {

    /**
     * Creates new form HomePageData
     */
    String book_name, author, student_name, branch, year, status;
    int book_id, quantity, student_id, issue_id;
    Date issue_date, due_date;

    public HomePage() {
        initComponents();
        // set border null
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setStudentDetailToTable();
        setBookDetailToTable();
        setStatusBookDetails();
        setIssueBookDetails();
    }

    public void setStudentDetailToTable() {
        // connect to database
        int countStudent = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student_details");
            while (rs.next()) {
                countStudent++;
                // student_id = rs.getInt("student_id");
                // student_name = rs.getString("student_name");
                // branch = rs.getString("branch");
                // year = rs.getString("year");
                // DefaultTableModel model = (DefaultTableModel) tableStudent.getModel();
                // model.addRow(new Object[] { student_id, student_name, branch, year });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        countStudentLabel.setText(" " + String.valueOf(countStudent));
    }

    public void setBookDetailToTable() {
        // connect to database
        int countBook = 0;
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM book_details");
            while (rs.next()) {
                countBook++;
                // book_id = rs.getInt("book_id");
                // book_name = rs.getString("book_name");
                // author = rs.getString("author");
                // quantity = rs.getInt("quantity");
                // DefaultTableModel model = (DefaultTableModel) tableBook.getModel();
                // model.addRow(new Object[] { book_id, book_name, author, quantity });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        countBookLabel.setText(" " + String.valueOf(countBook));
    }

    public void setStatusBookDetails() {
        int countPending = 0;
        int countReturn = 0;
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM issue_book_details where status='Pending'");
            while (rs.next()) {
                countPending++;
            }
            ResultSet rs1 = st.executeQuery("SELECT * FROM issue_book_details where status='Returned'");
            while (rs1.next()) {
                countReturn++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        countPendingLabel.setText(" " + String.valueOf(countPending));
        countReturnLabel.setText(" " + String.valueOf(countReturn));
    }

    public void setIssueBookDetails() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM issue_book_details");
            while (rs.next()) {
                issue_id = rs.getInt("issue_id");
                book_id = rs.getInt("book_id");
                book_name = rs.getString("book_name");
                student_id = rs.getInt("student_id");
                student_name = rs.getString("student_name");
                issue_date = rs.getDate("issue_date");
                due_date = rs.getDate("due_date");
                status = rs.getString("status");
                DefaultTableModel model = (DefaultTableModel) IssueBookDetailsTable.getModel();
                model.addRow(new Object[] { issue_id, book_id, book_name, student_id, student_name, issue_date,
                        due_date, status });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
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
        panelBorder4 = new components.PanelBorder();
        countReturnLabel = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        panelBorder3 = new components.PanelBorder();
        countPendingLabel = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        panelBorder2 = new components.PanelBorder();
        countStudentLabel = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        panelBorder1 = new components.PanelBorder();
        countBookLabel = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        panelBorder5 = new components.PanelBorder();
        jScrollPane4 = new javax.swing.JScrollPane();
        IssueBookDetailsTable = new rojeru_san.complementos.RSTableMetro();
        jLabel25 = new javax.swing.JLabel();
        seeMoreViewIssueBooksButton = new com.k33ptoo.components.KButton();
        jLabel26 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setFocusable(false);
        setOpaque(true);
        setPreferredSize(new java.awt.Dimension(950, 730));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        kGradientPanel2.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        kGradientPanel2.setkBorderRadius(0);
        kGradientPanel2.setkEndColor(new java.awt.Color(204, 204, 204));
        kGradientPanel2.setkStartColor(new java.awt.Color(245, 246, 241));
        kGradientPanel2.setPreferredSize(new java.awt.Dimension(950, 730));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder4.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        countReturnLabel.setFont(new java.awt.Font("DVN-Poppins", 1, 40)); // NOI18N
        countReturnLabel.setForeground(new java.awt.Color(36, 36, 36));
        countReturnLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/return.png"))); // NOI18N
        countReturnLabel.setText("   100");
        panelBorder4.add(countReturnLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel21.setFont(new java.awt.Font("DVN-Poppins", 0, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Return books");
        panelBorder4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        kGradientPanel2.add(panelBorder4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, 200, 110));

        panelBorder3.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        countPendingLabel.setFont(new java.awt.Font("DVN-Poppins", 1, 40)); // NOI18N
        countPendingLabel.setForeground(new java.awt.Color(36, 36, 36));
        countPendingLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pending.png"))); // NOI18N
        countPendingLabel.setText("   100");
        panelBorder3.add(countPendingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel19.setFont(new java.awt.Font("DVN-Poppins", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Pending books");
        panelBorder3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        kGradientPanel2.add(panelBorder3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 200, 110));

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        countStudentLabel.setFont(new java.awt.Font("DVN-Poppins", 1, 40)); // NOI18N
        countStudentLabel.setForeground(new java.awt.Color(36, 36, 36));
        countStudentLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/member.png"))); // NOI18N
        countStudentLabel.setText("   100");
        panelBorder2.add(countStudentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel17.setFont(new java.awt.Font("DVN-Poppins", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Students");
        panelBorder2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        kGradientPanel2.add(panelBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 200, 110));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        countBookLabel.setFont(new java.awt.Font("DVN-Poppins", 1, 40)); // NOI18N
        countBookLabel.setForeground(new java.awt.Color(36, 36, 36));
        countBookLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book.png"))); // NOI18N
        countBookLabel.setText("   100");
        panelBorder1.add(countBookLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel15.setFont(new java.awt.Font("DVN-Poppins", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Total books");
        panelBorder1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        kGradientPanel2.add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 200, 110));

        panelBorder5.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setBorder(null);
        jScrollPane4.setForeground(new java.awt.Color(255, 255, 255));

        IssueBookDetailsTable.setForeground(new java.awt.Color(255, 255, 255));
        IssueBookDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        IssueBookDetailsTable.setToolTipText("");
        IssueBookDetailsTable.setAlignmentX(0.0F);
        IssueBookDetailsTable.setAlignmentY(0.0F);
        IssueBookDetailsTable.setColorBackgoundHead(new java.awt.Color(255, 255, 255));
        IssueBookDetailsTable.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        IssueBookDetailsTable.setColorBordeHead(new java.awt.Color(255, 255, 255));
        IssueBookDetailsTable.setColorFilasBackgound1(new java.awt.Color(245, 246, 241));
        IssueBookDetailsTable.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        IssueBookDetailsTable.setColorFilasForeground1(new java.awt.Color(36, 36, 36));
        IssueBookDetailsTable.setColorFilasForeground2(new java.awt.Color(36, 36, 36));
        IssueBookDetailsTable.setColorForegroundHead(new java.awt.Color(36, 36, 36));
        IssueBookDetailsTable.setColorSelBackgound(new java.awt.Color(255, 204, 204));
        IssueBookDetailsTable.setColorSelForeground(new java.awt.Color(36, 36, 36));
        IssueBookDetailsTable.setDragEnabled(true);
        IssueBookDetailsTable.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        IssueBookDetailsTable.setFuenteFilas(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        IssueBookDetailsTable.setFuenteFilasSelect(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        IssueBookDetailsTable.setFuenteHead(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        IssueBookDetailsTable.setGridColor(new java.awt.Color(255, 255, 255));
        IssueBookDetailsTable.setRowHeight(34);
        IssueBookDetailsTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        IssueBookDetailsTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        IssueBookDetailsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(IssueBookDetailsTable);
        if (IssueBookDetailsTable.getColumnModel().getColumnCount() > 0) {
            IssueBookDetailsTable.getColumnModel().getColumn(0).setMaxWidth(80);
            IssueBookDetailsTable.getColumnModel().getColumn(1).setMaxWidth(80);
            IssueBookDetailsTable.getColumnModel().getColumn(3).setMaxWidth(80);
            IssueBookDetailsTable.getColumnModel().getColumn(5).setMinWidth(110);
            IssueBookDetailsTable.getColumnModel().getColumn(5).setMaxWidth(110);
            IssueBookDetailsTable.getColumnModel().getColumn(6).setMinWidth(110);
            IssueBookDetailsTable.getColumnModel().getColumn(6).setMaxWidth(110);
            IssueBookDetailsTable.getColumnModel().getColumn(7).setMaxWidth(100);
        }

        panelBorder5.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 850, 200));

        jLabel25.setBackground(new java.awt.Color(36, 36, 36));
        jLabel25.setFont(new java.awt.Font("DVN-Poppins", 0, 15)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("See more >");
        panelBorder5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, -1, 20));

        seeMoreViewIssueBooksButton.setBorder(null);
        seeMoreViewIssueBooksButton.setAlignmentX(0.5F);
        seeMoreViewIssueBooksButton.setFont(new java.awt.Font("DVN-Poppins", 1, 18)); // NOI18N
        seeMoreViewIssueBooksButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        seeMoreViewIssueBooksButton.setIconTextGap(2);
        seeMoreViewIssueBooksButton.setkBackGroundColor(new java.awt.Color(247, 171, 10));
        seeMoreViewIssueBooksButton.setkBorderRadius(20);
        seeMoreViewIssueBooksButton.setkEndColor(new java.awt.Color(204, 204, 204));
        seeMoreViewIssueBooksButton.setkForeGround(new java.awt.Color(36, 36, 36));
        seeMoreViewIssueBooksButton.setkHoverEndColor(new java.awt.Color(247, 171, 10));
        seeMoreViewIssueBooksButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        seeMoreViewIssueBooksButton.setkHoverStartColor(new java.awt.Color(204, 204, 204));
        seeMoreViewIssueBooksButton.setkSelectedColor(new java.awt.Color(247, 171, 10));
        seeMoreViewIssueBooksButton.setkStartColor(new java.awt.Color(255, 255, 255));
        seeMoreViewIssueBooksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seeMoreViewIssueBooksButtonActionPerformed(evt);
            }
        });
        panelBorder5.add(seeMoreViewIssueBooksButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 140, 20));

        jLabel26.setBackground(new java.awt.Color(36, 36, 36));
        jLabel26.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("Issue List");
        panelBorder5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        kGradientPanel2.add(panelBorder5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 890, 270));

        getContentPane().add(kGradientPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void seeMoreViewIssueBooksButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_seeMoreViewIssueBooksButtonActionPerformed
        // TODO add your handling code here:
        // IssueBook ib = new IssueBook();
        // ib.setVisible(true);
        // dispose();
    }// GEN-LAST:event_seeMoreViewIssueBooksButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSTableMetro IssueBookDetailsTable;
    private javax.swing.JLabel countBookLabel;
    private javax.swing.JLabel countPendingLabel;
    private javax.swing.JLabel countReturnLabel;
    private javax.swing.JLabel countStudentLabel;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JScrollPane jScrollPane4;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private components.PanelBorder panelBorder1;
    private components.PanelBorder panelBorder2;
    private components.PanelBorder panelBorder3;
    private components.PanelBorder panelBorder4;
    private components.PanelBorder panelBorder5;
    private com.k33ptoo.components.KButton seeMoreViewIssueBooksButton;
    // End of variables declaration//GEN-END:variables
}
