/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package components;

import dao.DBConnection;
import dao.IssueBookDao;
import model.IssueBook;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
    DefaultTableModel model;

    public HomePage() {
        initComponents();
        // set border null
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);

        setCountDetails();
        setIssueBookDetails();
        setStudentBooksCountTable();
    }

    public void setCountDetails() {
        int countBook = 0;
        int countStudent = 0;
        int countOverdue = 0;
        int countPending = 0;
        int countReturn = 0;
        double fee_pending = 0;
        double fee_returned = 0;
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
            ResultSet rs2 = st.executeQuery("SELECT * FROM issue_book_details where status='Overdue'");
            while (rs2.next()) {
                countOverdue++;
            }
            ResultSet rs3 = st.executeQuery("SELECT * FROM student_details");
            while (rs3.next()) {
                countStudent++;
            }
            ResultSet rs4 = st.executeQuery("SELECT * FROM book_details");
            while (rs4.next()) {
                countBook++;
            }
            // lấy ra số tiền fee_pending của user
            ResultSet rs5 = st.executeQuery("SELECT * FROM users");
            while (rs5.next()) {
                fee_pending += rs5.getDouble("fee_pending");
            }
            // lấy ra số tiền fee_returned của user
            ResultSet rs6 = st.executeQuery("SELECT * FROM users");
            while (rs6.next()) {
                fee_returned += rs6.getDouble("fee_returned");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        countPendingLabel.setText(" " + String.valueOf(countPending));
        countReturnLabel.setText(" " + String.valueOf(countReturn));
        countOverdueLabel.setText(" " + String.valueOf(countOverdue));
        countStudentLabel.setText(" " + String.valueOf(countStudent));
        countBookLabel.setText(" " + String.valueOf(countBook));
        countFeePendingLabel.setText(" " + String.valueOf(fee_pending) + " đ");
        countFeeReturnedLabel.setText(" " + String.valueOf(fee_returned) + " đ");
    }

    public void setIssueBookDetails() {
        IssueBookDao issueBookDao = new IssueBookDao();
        model = (DefaultTableModel) issueBookDetailsTable.getModel();
        model.setRowCount(0);
        for (IssueBook issueBook : issueBookDao.getAllIssueBooks()) {
            model.addRow(new Object[] { issueBook.getBook_id(), issueBook.getBook_name(), issueBook.getStudent_name(),
                    issueBook.getIssue_date(),
                    issueBook.getDue_date() });
        }
    }

    public void setStudentBooksCountTable() {
        IssueBookDao issueBookDao = new IssueBookDao();
        model = (DefaultTableModel) studentBooksCountTable.getModel();
        model.setRowCount(0);
        ArrayList<IssueBook> issueBooks = issueBookDao.getPendingIssueBooks();
        while (issueBooks.size() > 0) {
            int count = 0;
            IssueBook issueBook = issueBooks.get(0);
            for (IssueBook issueBook1 : issueBooks) {
                if (issueBook.getStudent_id() == issueBook1.getStudent_id()) {
                    count++;
                }
            }
            model.addRow(new Object[] { issueBook.getStudent_name(), count });
            issueBooks.removeIf(issueBook1 -> issueBook.getStudent_id() == issueBook1.getStudent_id());
        }
    }

    public void setNameBookList(String student_name) {
        IssueBookDao issueBookDao = new IssueBookDao();
        ArrayList<IssueBook> issueBooks = issueBookDao.getBooksByStudentName(student_name);
        model = (DefaultTableModel) nameBookListTable.getModel();
        model.setRowCount(0);
        for (IssueBook issueBook : issueBooks) {
            model.addRow(new Object[] { issueBook.getBook_name() });
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
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        componentResizerUtil1 = new com.k33ptoo.utils.ComponentResizerUtil();
        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        returnBookPanel = new components.PanelBorder();
        countReturnLabel = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        PendingBookPanel = new components.PanelBorder();
        countPendingLabel = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        studentsPanel = new components.PanelBorder();
        countStudentLabel = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        booksPanel = new components.PanelBorder();
        countBookLabel = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        panelBorder6 = new components.PanelBorder();
        studentNameLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        studentBooksCountTable = new rojeru_san.complementos.RSTableMetro();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        nameBookListTable = new rojeru_san.complementos.RSTableMetro();
        panelBorder8 = new components.PanelBorder();
        jScrollPane6 = new javax.swing.JScrollPane();
        issueBookDetailsTable = new rojeru_san.complementos.RSTableMetro();
        jLabel26 = new javax.swing.JLabel();
        returnBookPanel2 = new components.PanelBorder();
        countOverdueLabel = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        returnBookPanel3 = new components.PanelBorder();
        countFeePendingLabel = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        returnBookPanel4 = new components.PanelBorder();
        countFeeReturnedLabel = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();

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

        returnBookPanel.setBackground(new java.awt.Color(255, 255, 255));
        returnBookPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        countReturnLabel.setFont(new java.awt.Font("DVN-Poppins", 1, 40)); // NOI18N
        countReturnLabel.setForeground(new java.awt.Color(153, 204, 0));
        countReturnLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/return.png"))); // NOI18N
        countReturnLabel.setText("   100");
        returnBookPanel.add(countReturnLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel21.setFont(new java.awt.Font("DVN-Poppins", 0, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Return books");
        returnBookPanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        kGradientPanel2.add(returnBookPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 210, 110));

        PendingBookPanel.setBackground(new java.awt.Color(255, 255, 255));
        PendingBookPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        countPendingLabel.setFont(new java.awt.Font("DVN-Poppins", 1, 40)); // NOI18N
        countPendingLabel.setForeground(new java.awt.Color(204, 204, 0));
        countPendingLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pending.png"))); // NOI18N
        countPendingLabel.setText("   100");
        PendingBookPanel.add(countPendingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel19.setFont(new java.awt.Font("DVN-Poppins", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Pending books");
        PendingBookPanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        kGradientPanel2.add(PendingBookPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 210, 110));

        studentsPanel.setBackground(new java.awt.Color(255, 255, 255));
        studentsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        countStudentLabel.setFont(new java.awt.Font("DVN-Poppins", 1, 40)); // NOI18N
        countStudentLabel.setForeground(new java.awt.Color(36, 36, 36));
        countStudentLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/member.png"))); // NOI18N
        countStudentLabel.setText("   100");
        studentsPanel.add(countStudentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel17.setFont(new java.awt.Font("DVN-Poppins", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Students");
        studentsPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        kGradientPanel2.add(studentsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 210, 110));

        booksPanel.setBackground(new java.awt.Color(255, 255, 255));
        booksPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        countBookLabel.setFont(new java.awt.Font("DVN-Poppins", 1, 40)); // NOI18N
        countBookLabel.setForeground(new java.awt.Color(36, 36, 36));
        countBookLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book.png"))); // NOI18N
        countBookLabel.setText("   100");
        booksPanel.add(countBookLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel15.setFont(new java.awt.Font("DVN-Poppins", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Total books");
        booksPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        kGradientPanel2.add(booksPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 210, 110));

        panelBorder6.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        studentNameLabel.setFont(new java.awt.Font("DVN-Poppins", 2, 16)); // NOI18N
        studentNameLabel.setText(" ");
        panelBorder6.add(studentNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 180, -1));

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setBorder(null);
        jScrollPane4.setForeground(new java.awt.Color(255, 255, 255));

        studentBooksCountTable.setForeground(new java.awt.Color(255, 255, 255));
        studentBooksCountTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null },
                        { null, null },
                        { null, null },
                        { null, null }
                },
                new String[] {
                        "Student Name", "Count"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        studentBooksCountTable.setToolTipText("");
        studentBooksCountTable.setAlignmentX(0.0F);
        studentBooksCountTable.setAlignmentY(0.0F);
        studentBooksCountTable.setAltoHead(30);
        studentBooksCountTable.setColorBackgoundHead(new java.awt.Color(255, 255, 255));
        studentBooksCountTable.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        studentBooksCountTable.setColorBordeHead(new java.awt.Color(255, 255, 255));
        studentBooksCountTable.setColorFilasBackgound1(new java.awt.Color(245, 246, 241));
        studentBooksCountTable.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        studentBooksCountTable.setColorFilasForeground1(new java.awt.Color(36, 36, 36));
        studentBooksCountTable.setColorFilasForeground2(new java.awt.Color(36, 36, 36));
        studentBooksCountTable.setColorForegroundHead(new java.awt.Color(36, 36, 36));
        studentBooksCountTable.setColorSelBackgound(new java.awt.Color(255, 204, 204));
        studentBooksCountTable.setColorSelForeground(new java.awt.Color(36, 36, 36));
        studentBooksCountTable.setDragEnabled(true);
        studentBooksCountTable.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        studentBooksCountTable.setFuenteFilas(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        studentBooksCountTable.setFuenteFilasSelect(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        studentBooksCountTable.setFuenteHead(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        studentBooksCountTable.setGridColor(new java.awt.Color(255, 255, 255));
        studentBooksCountTable.setRowHeight(50);
        studentBooksCountTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        studentBooksCountTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        studentBooksCountTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        studentBooksCountTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentBooksCountTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(studentBooksCountTable);
        if (studentBooksCountTable.getColumnModel().getColumnCount() > 0) {
            studentBooksCountTable.getColumnModel().getColumn(1).setMinWidth(50);
            studentBooksCountTable.getColumnModel().getColumn(1).setMaxWidth(50);
        }

        panelBorder6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 280, 230));

        jLabel20.setFont(new java.awt.Font("DVN-Poppins", 0, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Top Student");
        panelBorder6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 290, -1));

        jLabel22.setFont(new java.awt.Font("DVN-Poppins", 0, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setText("List Book by:");
        panelBorder6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane5.setBorder(null);
        jScrollPane5.setForeground(new java.awt.Color(255, 255, 255));

        nameBookListTable.setForeground(new java.awt.Color(255, 255, 255));
        nameBookListTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null },
                        { null }
                },
                new String[] {
                        ""
                }) {
            boolean[] canEdit = new boolean[] {
                    false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        nameBookListTable.setToolTipText("");
        nameBookListTable.setAlignmentX(0.0F);
        nameBookListTable.setAlignmentY(0.0F);
        nameBookListTable.setAltoHead(0);
        nameBookListTable.setColorBackgoundHead(new java.awt.Color(255, 255, 255));
        nameBookListTable.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        nameBookListTable.setColorBordeHead(new java.awt.Color(255, 255, 255));
        nameBookListTable.setColorFilasBackgound1(new java.awt.Color(245, 246, 241));
        nameBookListTable.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        nameBookListTable.setColorFilasForeground1(new java.awt.Color(36, 36, 36));
        nameBookListTable.setColorFilasForeground2(new java.awt.Color(36, 36, 36));
        nameBookListTable.setColorForegroundHead(new java.awt.Color(36, 36, 36));
        nameBookListTable.setColorSelBackgound(new java.awt.Color(255, 204, 204));
        nameBookListTable.setColorSelForeground(new java.awt.Color(36, 36, 36));
        nameBookListTable.setDragEnabled(true);
        nameBookListTable.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        nameBookListTable.setFuenteFilas(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        nameBookListTable.setFuenteFilasSelect(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        nameBookListTable.setFuenteHead(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        nameBookListTable.setGridColor(new java.awt.Color(255, 255, 255));
        nameBookListTable.setRowHeight(50);
        nameBookListTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        nameBookListTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        nameBookListTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane5.setViewportView(nameBookListTable);

        panelBorder6.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 280, 100));

        kGradientPanel2.add(panelBorder6, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 280, 320, 430));

        panelBorder8.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane6.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane6.setBorder(null);
        jScrollPane6.setForeground(new java.awt.Color(255, 255, 255));

        issueBookDetailsTable.setForeground(new java.awt.Color(255, 255, 255));
        issueBookDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null }
                },
                new String[] {
                        "Book ID", "Book Name", "Student Name", "Issue Date", "Due Date"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        issueBookDetailsTable.setToolTipText("");
        issueBookDetailsTable.setAlignmentX(0.0F);
        issueBookDetailsTable.setAlignmentY(0.0F);
        issueBookDetailsTable.setAltoHead(30);
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
        jScrollPane6.setViewportView(issueBookDetailsTable);
        if (issueBookDetailsTable.getColumnModel().getColumnCount() > 0) {
            issueBookDetailsTable.getColumnModel().getColumn(0).setMinWidth(65);
            issueBookDetailsTable.getColumnModel().getColumn(0).setMaxWidth(65);
        }

        panelBorder8.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 520, 370));

        jLabel26.setBackground(new java.awt.Color(36, 36, 36));
        jLabel26.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("Issue List");
        panelBorder8.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        kGradientPanel2.add(panelBorder8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 560, 430));

        returnBookPanel2.setBackground(new java.awt.Color(255, 255, 255));
        returnBookPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        countOverdueLabel.setFont(new java.awt.Font("DVN-Poppins", 1, 40)); // NOI18N
        countOverdueLabel.setForeground(new java.awt.Color(255, 153, 153));
        countOverdueLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/overdue.png"))); // NOI18N
        countOverdueLabel.setText("   100");
        returnBookPanel2.add(countOverdueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel24.setFont(new java.awt.Font("DVN-Poppins", 0, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("Overdue books");
        returnBookPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        kGradientPanel2.add(returnBookPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 150, 210, 110));

        returnBookPanel3.setBackground(new java.awt.Color(255, 255, 255));
        returnBookPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        countFeePendingLabel.setFont(new java.awt.Font("DVN-Poppins", 1, 40)); // NOI18N
        countFeePendingLabel.setForeground(new java.awt.Color(255, 153, 153));
        countFeePendingLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/fee_pending.png"))); // NOI18N
        countFeePendingLabel.setText("   100 đ");
        returnBookPanel3.add(countFeePendingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel25.setFont(new java.awt.Font("DVN-Poppins", 0, 16)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("Fee Pending");
        returnBookPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        kGradientPanel2.add(returnBookPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 320, 110));

        returnBookPanel4.setBackground(new java.awt.Color(255, 255, 255));
        returnBookPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        countFeeReturnedLabel.setFont(new java.awt.Font("DVN-Poppins", 1, 40)); // NOI18N
        countFeeReturnedLabel.setForeground(new java.awt.Color(0, 204, 0));
        countFeeReturnedLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/fee_return.png"))); // NOI18N
        countFeeReturnedLabel.setText("   100 đ");
        returnBookPanel4.add(countFeeReturnedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel27.setFont(new java.awt.Font("DVN-Poppins", 0, 16)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("Fee Returned");
        returnBookPanel4.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        kGradientPanel2.add(returnBookPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 330, 110));

        getContentPane().add(kGradientPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void studentBooksCountTableMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_studentBooksCountTableMouseClicked
        int i = studentBooksCountTable.getSelectedRow();
        TableModel model = studentBooksCountTable.getModel();
        String student_name = model.getValueAt(i, 0).toString();
        studentNameLabel.setText(student_name);
        setNameBookList(student_name);
    }// GEN-LAST:event_studentBooksCountTableMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.PanelBorder PendingBookPanel;
    private components.PanelBorder booksPanel;
    private com.k33ptoo.utils.ComponentResizerUtil componentResizerUtil1;
    private javax.swing.JLabel countBookLabel;
    private javax.swing.JLabel countFeePendingLabel;
    private javax.swing.JLabel countFeeReturnedLabel;
    private javax.swing.JLabel countOverdueLabel;
    private javax.swing.JLabel countPendingLabel;
    private javax.swing.JLabel countReturnLabel;
    private javax.swing.JLabel countStudentLabel;
    private rojeru_san.complementos.RSTableMetro issueBookDetailsTable;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private rojeru_san.complementos.RSTableMetro nameBookListTable;
    private components.PanelBorder panelBorder6;
    private components.PanelBorder panelBorder8;
    private components.PanelBorder returnBookPanel;
    private components.PanelBorder returnBookPanel2;
    private components.PanelBorder returnBookPanel3;
    private components.PanelBorder returnBookPanel4;
    private rojeru_san.complementos.RSTableMetro studentBooksCountTable;
    private javax.swing.JLabel studentNameLabel;
    private components.PanelBorder studentsPanel;
    // End of variables declaration//GEN-END:variables
}
