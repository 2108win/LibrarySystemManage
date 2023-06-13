/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package components;

import dao.BooksDao;
import dao.IssueBookDao;
import model.IssueBook;

import java.util.Date;

import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author winlax
 */
public class ViewSalesPage extends javax.swing.JInternalFrame {

    /**
     * Creates new form HomePageData
     */
    String book_name, author, student_name, branch, year, status;
    int book_id, quantity, student_id, issue_id;
    Date issue_date, due_date;
    DefaultTableModel model;

    public ViewSalesPage() {
        initComponents();
        // set border null
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setIssueBookPending();
        setIssueBookReturned();
    }

    public void setIssueBookDetails() {
        IssueBookDao issueBookDao = new IssueBookDao();
        model = (DefaultTableModel) issueBookPendingTable.getModel();
        model.setRowCount(0);
        for (IssueBook issueBook : issueBookDao.getAllIssueBooks()) {
            IssueBook iBook = new IssueBook();
            double fee_pending = iBook.calculateFee(BooksDao.getBookFee(issueBook.getBook_id()),
                    issueBook.getDue_date());
            issueBookDao.updateIssueFee(issueBook.getIssue_id(), fee_pending);
            model.addRow(new Object[] {
                    issueBook.getIssue_id(), issueBook.getBook_id(), issueBook.getBook_name(),
                    issueBook.getStudent_id(), issueBook.getStudent_name(), issueBook.getIssue_date(),
                    issueBook.getDue_date(), issueBook.getStatus()
            });
        }
    }

    public void setIssueBookPending() {
        IssueBookDao issueBookDao = new IssueBookDao();
        model = (DefaultTableModel) issueBookPendingTable.getModel();
        for (IssueBook issueBook : issueBookDao.getAllIssueBooks()) {
            if (issueBook.getStatus().equals("Pending")) {
                model.addRow(new Object[] {
                        issueBook.getIssue_id(), issueBook.getBook_id(), issueBook.getBook_name(),
                        issueBook.getStudent_id(), issueBook.getStudent_name(), issueBook.getIssue_date(),
                        issueBook.getDue_date(), issueBook.getStatus()
                });
            }
        }
    }

    public void setIssueBookReturned() {
        IssueBookDao issueBookDao = new IssueBookDao();
        model = (DefaultTableModel) issueBookPendingTable.getModel();
        for (IssueBook issueBook : issueBookDao.getAllIssueBooks()) {
            if (issueBook.getStatus().equals("Returned")) {
                model.addRow(new Object[] {
                        issueBook.getIssue_id(), issueBook.getBook_id(), issueBook.getBook_name(),
                        issueBook.getStudent_id(), issueBook.getStudent_name(), issueBook.getIssue_date(),
                        issueBook.getDue_date(), issueBook.getStatus()
                });
            }
        }
    }

    public void setIssueBookOverdue() {
        IssueBookDao issueBookDao = new IssueBookDao();
        model = (DefaultTableModel) issueBookPendingTable.getModel();
        for (IssueBook issueBook : issueBookDao.getAllIssueBooks()) {
            if (issueBook.getStatus().equals("Overdue")) {
                model.addRow(new Object[] {
                        issueBook.getIssue_id(), issueBook.getBook_id(), issueBook.getBook_name(),
                        issueBook.getStudent_id(), issueBook.getStudent_name(), issueBook.getIssue_date(),
                        issueBook.getDue_date(), issueBook.getStatus()
                });
            }
        }
    }

    // filter
    public void filter(String query) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        issueBookPendingTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
        // tr.setRowFilter(RowFilter.regexFilter(fromDate, 5));
        // tr.setRowFilter(RowFilter.regexFilter(toDate, 5));
    }

    // public void filterStatus(String query) {
    // TableRowSorter<DefaultTableModel> tr = new
    // TableRowSorter<DefaultTableModel>(model);
    // IssueBookDetailsTable.setRowSorter(tr);
    // tr.setRowFilter(RowFilter.regexFilter(query, 7));
    // }

    // public void filterFromDateToDate(String query) {
    // TableRowSorter<DefaultTableModel> tr = new
    // TableRowSorter<DefaultTableModel>(model);
    // IssueBookDetailsTable.setRowSorter(tr);
    // tr.setRowFilter(RowFilter.regexFilter(query, 5));
    // }
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        panelBorder6 = new components.PanelBorder();
        jScrollPane5 = new javax.swing.JScrollPane();
        issueBookReturnTable = new rojeru_san.complementos.RSTableMetro();
        jLabel27 = new javax.swing.JLabel();
        panelBorder5 = new components.PanelBorder();
        jScrollPane4 = new javax.swing.JScrollPane();
        issueBookPendingTable = new rojeru_san.complementos.RSTableMetro();
        jLabel26 = new javax.swing.JLabel();
        panelBorder3 = new components.PanelBorder();
        txt_Search = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        panelBorder1 = new components.PanelBorder();
        txt_ComboSearchStatus = new javax.swing.JComboBox<>();
        panelBorder2 = new components.PanelBorder();
        txt_Fee = new javax.swing.JLabel();
        txt_Status = new javax.swing.JLabel();
        studentNameLabel2 = new javax.swing.JLabel();
        txt_StudentName = new javax.swing.JLabel();

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

        panelBorder6.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane5.setBorder(null);
        jScrollPane5.setForeground(new java.awt.Color(255, 255, 255));

        issueBookReturnTable.setForeground(new java.awt.Color(255, 255, 255));
        issueBookReturnTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "ID", "Book Name", "Student Name", "Fee Return"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        issueBookReturnTable.setToolTipText("");
        issueBookReturnTable.setAlignmentX(0.0F);
        issueBookReturnTable.setAlignmentY(0.0F);
        issueBookReturnTable.setColorBackgoundHead(new java.awt.Color(255, 255, 255));
        issueBookReturnTable.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        issueBookReturnTable.setColorBordeHead(new java.awt.Color(255, 255, 255));
        issueBookReturnTable.setColorFilasBackgound1(new java.awt.Color(245, 246, 241));
        issueBookReturnTable.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        issueBookReturnTable.setColorFilasForeground1(new java.awt.Color(36, 36, 36));
        issueBookReturnTable.setColorFilasForeground2(new java.awt.Color(36, 36, 36));
        issueBookReturnTable.setColorForegroundHead(new java.awt.Color(36, 36, 36));
        issueBookReturnTable.setColorSelBackgound(new java.awt.Color(255, 204, 204));
        issueBookReturnTable.setColorSelForeground(new java.awt.Color(36, 36, 36));
        issueBookReturnTable.setDragEnabled(true);
        issueBookReturnTable.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        issueBookReturnTable.setFuenteFilas(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        issueBookReturnTable.setFuenteFilasSelect(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        issueBookReturnTable.setFuenteHead(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        issueBookReturnTable.setGridColor(new java.awt.Color(255, 255, 255));
        issueBookReturnTable.setRowHeight(34);
        issueBookReturnTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        issueBookReturnTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        issueBookReturnTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane5.setViewportView(issueBookReturnTable);
        if (issueBookReturnTable.getColumnModel().getColumnCount() > 0) {
            issueBookReturnTable.getColumnModel().getColumn(0).setMaxWidth(50);
            issueBookReturnTable.getColumnModel().getColumn(3).setMinWidth(100);
            issueBookReturnTable.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        panelBorder6.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 410, 530));

        jLabel27.setBackground(new java.awt.Color(36, 36, 36));
        jLabel27.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("Return List");
        panelBorder6.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        kGradientPanel2.add(panelBorder6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 450, 600));

        panelBorder5.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setBorder(null);
        jScrollPane4.setForeground(new java.awt.Color(255, 255, 255));

        issueBookPendingTable.setForeground(new java.awt.Color(255, 255, 255));
        issueBookPendingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "ID", "Book Name", "Student Name", "Fee Pending"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        issueBookPendingTable.setToolTipText("");
        issueBookPendingTable.setAlignmentX(0.0F);
        issueBookPendingTable.setAlignmentY(0.0F);
        issueBookPendingTable.setColorBackgoundHead(new java.awt.Color(255, 255, 255));
        issueBookPendingTable.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        issueBookPendingTable.setColorBordeHead(new java.awt.Color(255, 255, 255));
        issueBookPendingTable.setColorFilasBackgound1(new java.awt.Color(245, 246, 241));
        issueBookPendingTable.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        issueBookPendingTable.setColorFilasForeground1(new java.awt.Color(36, 36, 36));
        issueBookPendingTable.setColorFilasForeground2(new java.awt.Color(36, 36, 36));
        issueBookPendingTable.setColorForegroundHead(new java.awt.Color(36, 36, 36));
        issueBookPendingTable.setColorSelBackgound(new java.awt.Color(255, 204, 204));
        issueBookPendingTable.setColorSelForeground(new java.awt.Color(36, 36, 36));
        issueBookPendingTable.setDragEnabled(true);
        issueBookPendingTable.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        issueBookPendingTable.setFuenteFilas(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        issueBookPendingTable.setFuenteFilasSelect(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        issueBookPendingTable.setFuenteHead(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        issueBookPendingTable.setGridColor(new java.awt.Color(255, 255, 255));
        issueBookPendingTable.setRowHeight(34);
        issueBookPendingTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        issueBookPendingTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        issueBookPendingTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(issueBookPendingTable);
        if (issueBookPendingTable.getColumnModel().getColumnCount() > 0) {
            issueBookPendingTable.getColumnModel().getColumn(0).setMaxWidth(50);
            issueBookPendingTable.getColumnModel().getColumn(3).setMinWidth(100);
            issueBookPendingTable.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        panelBorder5.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 400, 530));

        jLabel26.setBackground(new java.awt.Color(36, 36, 36));
        jLabel26.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("Pending List");
        panelBorder5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        kGradientPanel2.add(panelBorder5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 440, 600));

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
        panelBorder3.add(txt_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 150, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        panelBorder3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        kGradientPanel2.add(panelBorder3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 240, 70));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_ComboSearchStatus.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_ComboSearchStatus.setForeground(new java.awt.Color(36, 36, 36));
        txt_ComboSearchStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Status", "Pending", "Returned", "Overdue" }));
        txt_ComboSearchStatus.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_ComboSearchStatus.setOpaque(true);
        txt_ComboSearchStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ComboSearchStatusActionPerformed(evt);
            }
        });
        panelBorder1.add(txt_ComboSearchStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 30));

        kGradientPanel2.add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, 160, 70));

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_Fee.setFont(new java.awt.Font("DVN-Poppins", 2, 16)); // NOI18N
        txt_Fee.setForeground(new java.awt.Color(0, 204, 0));
        txt_Fee.setText("0.0đ");
        txt_Fee.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        panelBorder2.add(txt_Fee, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 100, 30));

        txt_Status.setFont(new java.awt.Font("DVN-Poppins", 3, 16)); // NOI18N
        txt_Status.setForeground(new java.awt.Color(0, 204, 0));
        txt_Status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_Status.setText("Status");
        panelBorder2.add(txt_Status, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 90, 30));

        studentNameLabel2.setFont(new java.awt.Font("DVN-Poppins", 2, 16)); // NOI18N
        studentNameLabel2.setText("--");
        panelBorder2.add(studentNameLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 20, 30));

        txt_StudentName.setFont(new java.awt.Font("DVN-Poppins", 2, 16)); // NOI18N
        txt_StudentName.setText(" Student_name");
        panelBorder2.add(txt_StudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 200, 30));

        kGradientPanel2.add(panelBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 470, 70));

        getContentPane().add(kGradientPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void issueBookDetailsTable1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_issueBookDetailsTable1MouseClicked
        // TODO add your handling code here:
    }// GEN-LAST:event_issueBookDetailsTable1MouseClicked

    private void issueBookDetailsTableMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_issueBookDetailsTableMouseClicked
        // TODO add your handling code here:
        int i = issueBookPendingTable.getSelectedRow();
        model = (DefaultTableModel) issueBookPendingTable.getModel();
        txt_StudentName.setText(model.getValueAt(i, 4).toString());
        IssueBookDao issueBookDao = new IssueBookDao();
        int issueBookId = Integer.parseInt(model.getValueAt(i, 0).toString());
        double fee = issueBookDao.getIssueFeeByIssueId(issueBookId);
        // pending và overdue thì color [255,153,153] , returned thì color [0,204,0]
        txt_Fee.setText(fee + " đ");
        if (model.getValueAt(i, 7).toString().equals("Pending")) {
            txt_Status.setText("Pending");
            txt_Status.setForeground(new java.awt.Color(255, 153, 153));
            txt_Fee.setForeground(new java.awt.Color(255, 153, 153));
        } else if (model.getValueAt(i, 7).toString().equals("Overdue")) {
            txt_Status.setText("Overdue");
            txt_Status.setForeground(new java.awt.Color(255, 153, 153));
            txt_Fee.setForeground(new java.awt.Color(255, 153, 153));
        } else if (model.getValueAt(i, 7).toString().equals("Returned")) {
            txt_Status.setText("Returned");
            txt_Status.setForeground(new java.awt.Color(0, 204, 0));
            txt_Fee.setForeground(new java.awt.Color(0, 204, 0));
        }
        // gán txt_Fee = issue_fee từ database của bảng issue_book_details

    }// GEN-LAST:event_issueBookDetailsTableMouseClicked

    private void txt_ComboSearchStatusActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txt_ComboSearchStatusActionPerformed
        // TODO add your handling code here:
        String status = txt_ComboSearchStatus.getSelectedItem().toString();
        if (status.equals("Pending")) {
            // clear table
            model = (DefaultTableModel) issueBookPendingTable.getModel();
            model.setRowCount(0);
            setIssueBookPending();
        } else if (status.equals("Returned")) {
            // clear table
            model = (DefaultTableModel) issueBookPendingTable.getModel();
            model.setRowCount(0);
            setIssueBookReturned();
        } else if (status.equals("Overdue")) {
            // clear table
            model = (DefaultTableModel) issueBookPendingTable.getModel();
            model.setRowCount(0);
            setIssueBookOverdue();
        } else {
            // clear table
            model = (DefaultTableModel) issueBookPendingTable.getModel();
            model.setRowCount(0);
            setIssueBookDetails();
        }

    }// GEN-LAST:event_txt_ComboSearchStatusActionPerformed

    private void txt_SearchKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txt_SearchKeyReleased
        // TODO add your handling code here:
        String query = txt_Search.getText();
        filter(query);
    }// GEN-LAST:event_txt_SearchKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSTableMetro issueBookPendingTable;
    private rojeru_san.complementos.RSTableMetro issueBookReturnTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private components.PanelBorder panelBorder1;
    private components.PanelBorder panelBorder2;
    private components.PanelBorder panelBorder3;
    private components.PanelBorder panelBorder5;
    private components.PanelBorder panelBorder6;
    private javax.swing.JLabel studentNameLabel2;
    private javax.swing.JComboBox<String> txt_ComboSearchStatus;
    private javax.swing.JLabel txt_Fee;
    private javax.swing.JTextField txt_Search;
    private javax.swing.JLabel txt_Status;
    private javax.swing.JLabel txt_StudentName;
    // End of variables declaration//GEN-END:variables
}
