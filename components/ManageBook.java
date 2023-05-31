/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package components;

import dao.BooksDao;
import dao.DBConnection;
import model.Books;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author dangc
 */
public class ManageBook extends javax.swing.JInternalFrame {

    /**
     * Creates new form ManageBook
     */
    String book_name, author;
    int book_id, quantity;
    DefaultTableModel model;

    public ManageBook() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        reloadTable();
    }

    public void reloadTable() {
        if (model != null) {
            model.setRowCount(0);
        }
        setBookDetailToTable();
    }

    public void setBookDetailToTable() {
        // connect to database
        // try {
        // Class.forName("com.mysql.cj.jdbc.Driver");
        // Connection con =
        // DriverManager.getConnection("jdbc:mysql://localhost:8111/library_ms", "root",
        // "");
        // Statement st = con.createStatement();
        // ResultSet rs = st.executeQuery("SELECT * FROM book_details");
        // while (rs.next()) {
        // book_id = rs.getInt("book_id");
        // book_name = rs.getString("book_name");
        // author = rs.getString("author");
        // quantity = rs.getInt("quantity");
        // model = (DefaultTableModel) bookDetailsTable.getModel();
        // model.addRow(new Object[] { book_id, book_name, author, quantity });
        // }
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
        BooksDao booksDao = new BooksDao();
        model = (DefaultTableModel) bookDetailsTable.getModel();
        for (Books book : booksDao.getAllBooks()) {
            model.addRow(new Object[] { book.getBook_id(), book.getBook_name(), book.getAuthor(), book.getQuantity() });
        }
    }

    public boolean addBook() {
        int book_id = Integer.parseInt(txt_BookID.getText());
        String book_name = txt_BookName.getText();
        String author = txt_BookAuthor.getText();
        int quantity = Integer.parseInt(txt_Quantity.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO book_details VALUES(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, book_id);
            pst.setString(2, book_name);
            pst.setString(3, author);
            pst.setInt(4, quantity);
            int rs = pst.executeUpdate();
            if (rs > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateBook() {
        int book_id = Integer.parseInt(txt_BookID.getText());
        String book_name = txt_BookName.getText();
        String author = txt_BookAuthor.getText();
        int quantity = Integer.parseInt(txt_Quantity.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE book_details SET book_name = ?, author = ?, quantity = ? WHERE book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, book_name);
            pst.setString(2, author);
            pst.setInt(3, quantity);
            pst.setInt(4, book_id);
            int rs = pst.executeUpdate();
            if (rs > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removeBook() {
        int book_id = Integer.parseInt(txt_BookID.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql = "DELETE FROM book_details WHERE book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, book_id);
            int rs = pst.executeUpdate();
            if (rs > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // filter
    public void filter(String query) {
        // DefaultTableModel model = (DefaultTableModel) bookDetailsTable.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        bookDetailsTable.setRowSorter(tr);
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        jLabel11 = new javax.swing.JLabel();
        removeButton = new com.k33ptoo.components.KButton();
        jLabel12 = new javax.swing.JLabel();
        updateButton = new com.k33ptoo.components.KButton();
        jLabel13 = new javax.swing.JLabel();
        addButton = new com.k33ptoo.components.KButton();
        panelBorder1 = new components.PanelBorder();
        jScrollPane4 = new javax.swing.JScrollPane();
        bookDetailsTable = new rojeru_san.complementos.RSTableMetro();
        jLabel25 = new javax.swing.JLabel();
        panelBorder2 = new components.PanelBorder();
        txt_BookAuthor = new javax.swing.JTextField();
        txt_Quantity = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txt_BookID = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txt_BookName = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        panelBorder3 = new components.PanelBorder();
        txt_Search = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        kGradientPanel2.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        kGradientPanel2.setkBorderRadius(0);
        kGradientPanel2.setkEndColor(new java.awt.Color(204, 204, 204));
        kGradientPanel2.setkStartColor(new java.awt.Color(245, 246, 241));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Remove");
        kGradientPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 640, -1, -1));

        removeButton.setAlignmentX(0.5F);
        removeButton.setFont(new java.awt.Font("DVN-Poppins", 1, 18)); // NOI18N
        removeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        removeButton.setIconTextGap(2);
        removeButton.setkBackGroundColor(new java.awt.Color(247, 171, 10));
        removeButton.setkBorderRadius(20);
        removeButton.setkEndColor(new java.awt.Color(204, 204, 204));
        removeButton.setkForeGround(new java.awt.Color(36, 36, 36));
        removeButton.setkHoverEndColor(new java.awt.Color(247, 171, 10));
        removeButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        removeButton.setkHoverStartColor(new java.awt.Color(247, 171, 10));
        removeButton.setkSelectedColor(new java.awt.Color(247, 171, 10));
        removeButton.setkStartColor(new java.awt.Color(255, 255, 255));
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });
        kGradientPanel2.add(removeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 630, 100, 40));

        jLabel12.setFont(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(36, 36, 36));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Update");
        kGradientPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 640, -1, -1));

        updateButton.setAlignmentX(0.5F);
        updateButton.setFont(new java.awt.Font("DVN-Poppins", 1, 18)); // NOI18N
        updateButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        updateButton.setIconTextGap(2);
        updateButton.setkBackGroundColor(new java.awt.Color(247, 171, 10));
        updateButton.setkBorderRadius(20);
        updateButton.setkEndColor(new java.awt.Color(204, 204, 204));
        updateButton.setkForeGround(new java.awt.Color(36, 36, 36));
        updateButton.setkHoverEndColor(new java.awt.Color(247, 171, 10));
        updateButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        updateButton.setkHoverStartColor(new java.awt.Color(247, 171, 10));
        updateButton.setkSelectedColor(new java.awt.Color(247, 171, 10));
        updateButton.setkStartColor(new java.awt.Color(255, 255, 255));
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        kGradientPanel2.add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 630, 110, 40));

        jLabel13.setFont(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(36, 36, 36));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Add");
        kGradientPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 640, -1, -1));

        addButton.setAlignmentX(0.5F);
        addButton.setFont(new java.awt.Font("DVN-Poppins", 1, 18)); // NOI18N
        addButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addButton.setIconTextGap(2);
        addButton.setkBackGroundColor(new java.awt.Color(247, 171, 10));
        addButton.setkBorderRadius(20);
        addButton.setkEndColor(new java.awt.Color(204, 204, 204));
        addButton.setkForeGround(new java.awt.Color(36, 36, 36));
        addButton.setkHoverEndColor(new java.awt.Color(247, 171, 10));
        addButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        addButton.setkHoverStartColor(new java.awt.Color(247, 171, 10));
        addButton.setkSelectedColor(new java.awt.Color(247, 171, 10));
        addButton.setkStartColor(new java.awt.Color(255, 255, 255));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        kGradientPanel2.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 630, 90, 40));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setBorder(null);
        jScrollPane4.setOpaque(false);

        bookDetailsTable.setForeground(new java.awt.Color(255, 255, 255));
        bookDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Name", "Author", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bookDetailsTable.setToolTipText("");
        bookDetailsTable.setAlignmentX(0.0F);
        bookDetailsTable.setAlignmentY(0.0F);
        bookDetailsTable.setColorBackgoundHead(new java.awt.Color(255, 255, 255));
        bookDetailsTable.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        bookDetailsTable.setColorBordeHead(new java.awt.Color(255, 255, 255));
        bookDetailsTable.setColorFilasBackgound1(new java.awt.Color(245, 246, 241));
        bookDetailsTable.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        bookDetailsTable.setColorFilasForeground1(new java.awt.Color(36, 36, 36));
        bookDetailsTable.setColorFilasForeground2(new java.awt.Color(36, 36, 36));
        bookDetailsTable.setColorForegroundHead(new java.awt.Color(36, 36, 36));
        bookDetailsTable.setColorSelBackgound(new java.awt.Color(255, 204, 204));
        bookDetailsTable.setColorSelForeground(new java.awt.Color(36, 36, 36));
        bookDetailsTable.setDragEnabled(true);
        bookDetailsTable.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        bookDetailsTable.setFuenteFilas(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        bookDetailsTable.setFuenteFilasSelect(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        bookDetailsTable.setFuenteHead(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        bookDetailsTable.setGridColor(new java.awt.Color(255, 255, 255));
        bookDetailsTable.setRowHeight(34);
        bookDetailsTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        bookDetailsTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        bookDetailsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        bookDetailsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookDetailsTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(bookDetailsTable);
        if (bookDetailsTable.getColumnModel().getColumnCount() > 0) {
            bookDetailsTable.getColumnModel().getColumn(0).setMaxWidth(110);
            bookDetailsTable.getColumnModel().getColumn(3).setMaxWidth(80);
        }

        panelBorder1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 530, 580));

        jLabel25.setBackground(new java.awt.Color(36, 36, 36));
        jLabel25.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("Book List");
        panelBorder1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        kGradientPanel2.add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 570, 650));

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_BookAuthor.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_BookAuthor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_BookAuthor.setMargin(new java.awt.Insets(2, 10, 2, 10));
        panelBorder2.add(txt_BookAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 260, -1));

        txt_Quantity.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_Quantity.setForeground(new java.awt.Color(36, 36, 36));
        txt_Quantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_Quantity.setCaretColor(new java.awt.Color(36, 36, 36));
        txt_Quantity.setMargin(new java.awt.Insets(2, 10, 2, 10));
        panelBorder2.add(txt_Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 260, -1));

        jLabel24.setBackground(new java.awt.Color(36, 36, 36));
        jLabel24.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(36, 36, 36));
        jLabel24.setText("Book ID");
        panelBorder2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel26.setBackground(new java.awt.Color(36, 36, 36));
        jLabel26.setFont(new java.awt.Font("DVN-Poppins", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(36, 36, 36));
        jLabel26.setText("Book details");
        panelBorder2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        txt_BookID.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_BookID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_BookID.setMargin(new java.awt.Insets(2, 10, 2, 10));
        panelBorder2.add(txt_BookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 260, -1));

        jLabel27.setBackground(new java.awt.Color(36, 36, 36));
        jLabel27.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(36, 36, 36));
        jLabel27.setText("Name of book");
        panelBorder2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        txt_BookName.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_BookName.setForeground(new java.awt.Color(36, 36, 36));
        txt_BookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_BookName.setCaretColor(new java.awt.Color(36, 36, 36));
        txt_BookName.setMargin(new java.awt.Insets(2, 10, 2, 10));
        panelBorder2.add(txt_BookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 260, -1));

        jLabel28.setBackground(new java.awt.Color(36, 36, 36));
        jLabel28.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(36, 36, 36));
        jLabel28.setText("Quantity");
        panelBorder2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        jLabel29.setBackground(new java.awt.Color(36, 36, 36));
        jLabel29.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(36, 36, 36));
        jLabel29.setText("Author");
        panelBorder2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        kGradientPanel2.add(panelBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 320, 500));

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

        getContentPane().add(kGradientPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_SearchKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txt_SearchKeyReleased
        String query = txt_Search.getText();
        filter(query);
    }// GEN-LAST:event_txt_SearchKeyReleased

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_removeButtonActionPerformed
        // TODO add your handling code here:
        if (removeBook()) {
            reloadTable();
        } else {
            JOptionPane.showMessageDialog(null, "Book Not Removed!");
        }
    }// GEN-LAST:event_removeButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        if (updateBook()) {
            reloadTable();
        } else {
            JOptionPane.showMessageDialog(null, "Book ID Does Not Exists");
        }
    }// GEN-LAST:event_updateButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        if (addBook()) {
            reloadTable();
        } else {
            JOptionPane.showMessageDialog(null, "Same Book ID Already Exists");
        }
    }// GEN-LAST:event_addButtonActionPerformed

    private void bookDetailsTableMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_bookDetailsTableMouseClicked
        // TODO add your handling code here:
        int i = bookDetailsTable.getSelectedRow();
        TableModel model = bookDetailsTable.getModel();
        txt_BookID.setText(model.getValueAt(i, 0).toString());
        txt_BookName.setText(model.getValueAt(i, 1).toString());
        txt_BookAuthor.setText(model.getValueAt(i, 2).toString());
        txt_Quantity.setText(model.getValueAt(i, 3).toString());
    }// GEN-LAST:event_bookDetailsTableMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton addButton;
    private rojeru_san.complementos.RSTableMetro bookDetailsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JScrollPane jScrollPane4;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private components.PanelBorder panelBorder1;
    private components.PanelBorder panelBorder2;
    private components.PanelBorder panelBorder3;
    private com.k33ptoo.components.KButton removeButton;
    private javax.swing.JTextField txt_BookAuthor;
    private javax.swing.JTextField txt_BookID;
    private javax.swing.JTextField txt_BookName;
    private javax.swing.JTextField txt_Quantity;
    private javax.swing.JTextField txt_Search;
    private com.k33ptoo.components.KButton updateButton;
    // End of variables declaration//GEN-END:variables
}
