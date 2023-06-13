/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package components;

import dao.DBConnection;
import dao.StudentsDao;
import model.Students;

import java.sql.Connection;
// import java.sql.DriverManager;
import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author dangc
 */
public class ManageStudents extends javax.swing.JInternalFrame {

    /**
     * Creates new form ManageStudents
     */
    String student_name, year, branch;
    int student_id;
    DefaultTableModel model;

    public ManageStudents() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        reloadTable();
    }

    public void reloadTable() {
        if (model != null) {
            model.setRowCount(0);
        }
        setStudentDetailToTable();
    }

    public void setStudentDetailToTable() {
        // connect to database
        // try {
        // Connection con = DBConnection.getConnection();
        // Statement st = con.createStatement();
        // ResultSet rs = st.executeQuery("select * from student_details");
        // while (rs.next()) {
        // student_id = rs.getInt("student_id");
        // student_name = rs.getString("student_name");
        // branch = rs.getString("branch");
        // year = rs.getString("year");
        // model = (DefaultTableModel) studentDetailsTable.getModel();
        // model.addRow(new Object[] { student_id, student_name, branch, year });
        // }
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
        StudentsDao dao = new StudentsDao();
        model = (DefaultTableModel) studentDetailsTable.getModel();
        for (Students student : dao.getAllStudents()) {
            model.addRow(new Object[] { student.getStudent_id(), student.getStudent_name(), student.getBranch(),
                    student.getYear() });
        }
    }

    public boolean addStudent() {
        int student_id = Integer.parseInt(txt_StudentID.getText());
        String student_name = txt_StudentName.getText();
        String branch = txt_branch.getSelectedItem().toString();
        String year = txt_year.getSelectedItem().toString();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO student_details VALUES(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, student_id);
            pst.setString(2, student_name);
            pst.setString(3, branch);
            pst.setString(4, year);
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

    public boolean updateStudent() {
        boolean isUpdated = false;
        int student_id = Integer.parseInt(txt_StudentID.getText());
        String student_name = txt_StudentName.getText();
        String branch = txt_branch.getSelectedItem().toString();
        String year = txt_year.getSelectedItem().toString();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE student_details SET student_name = ?, branch = ?, year = ? WHERE student_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, student_name);
            pst.setString(2, branch);
            pst.setString(3, year);
            pst.setInt(4, student_id);
            int rs = pst.executeUpdate();
            if (rs > 0) {
                isUpdated = true;
            } else {
                isUpdated = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    public boolean removeStudent() {
        int student_id = Integer.parseInt(txt_StudentID.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql = "DELETE FROM student_details WHERE student_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, student_id);
            int rs = pst.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // filter
    public void filter(String query) {
        // DefaultTableModel model = (DefaultTableModel) studentDetailsTable.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        studentDetailsTable.setRowSorter(tr);
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        panelBorder1 = new components.PanelBorder();
        jScrollPane4 = new javax.swing.JScrollPane();
        studentDetailsTable = new rojeru_san.complementos.RSTableMetro();
        jLabel25 = new javax.swing.JLabel();
        panelBorder2 = new components.PanelBorder();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txt_StudentID = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txt_StudentName = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txt_year = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        txt_branch = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        removeButton = new com.k33ptoo.components.KButton();
        jLabel12 = new javax.swing.JLabel();
        updateButton = new com.k33ptoo.components.KButton();
        jLabel13 = new javax.swing.JLabel();
        addButton = new com.k33ptoo.components.KButton();
        panelBorder3 = new components.PanelBorder();
        txt_Search = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        kGradientPanel2.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        kGradientPanel2.setkBorderRadius(0);
        kGradientPanel2.setkEndColor(new java.awt.Color(204, 204, 204));
        kGradientPanel2.setkStartColor(new java.awt.Color(245, 246, 241));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setBorder(null);

        studentDetailsTable.setForeground(new java.awt.Color(255, 255, 255));
        studentDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Branch", "Year"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        studentDetailsTable.setToolTipText("");
        studentDetailsTable.setAlignmentX(0.0F);
        studentDetailsTable.setAlignmentY(0.0F);
        studentDetailsTable.setColorBackgoundHead(new java.awt.Color(255, 255, 255));
        studentDetailsTable.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        studentDetailsTable.setColorBordeHead(new java.awt.Color(255, 255, 255));
        studentDetailsTable.setColorFilasBackgound1(new java.awt.Color(245, 246, 241));
        studentDetailsTable.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        studentDetailsTable.setColorFilasForeground1(new java.awt.Color(36, 36, 36));
        studentDetailsTable.setColorFilasForeground2(new java.awt.Color(36, 36, 36));
        studentDetailsTable.setColorForegroundHead(new java.awt.Color(36, 36, 36));
        studentDetailsTable.setColorSelBackgound(new java.awt.Color(255, 204, 204));
        studentDetailsTable.setColorSelForeground(new java.awt.Color(36, 36, 36));
        studentDetailsTable.setDragEnabled(true);
        studentDetailsTable.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        studentDetailsTable.setFuenteFilas(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        studentDetailsTable.setFuenteFilasSelect(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        studentDetailsTable.setFuenteHead(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        studentDetailsTable.setGridColor(new java.awt.Color(255, 255, 255));
        studentDetailsTable.setRowHeight(34);
        studentDetailsTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        studentDetailsTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        studentDetailsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        studentDetailsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentDetailsTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(studentDetailsTable);
        if (studentDetailsTable.getColumnModel().getColumnCount() > 0) {
            studentDetailsTable.getColumnModel().getColumn(0).setMinWidth(80);
            studentDetailsTable.getColumnModel().getColumn(0).setMaxWidth(80);
            studentDetailsTable.getColumnModel().getColumn(3).setMaxWidth(80);
        }

        panelBorder1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 530, 580));

        jLabel25.setBackground(new java.awt.Color(36, 36, 36));
        jLabel25.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("Student List");
        panelBorder1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        kGradientPanel2.add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 570, 690));

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setBackground(new java.awt.Color(36, 36, 36));
        jLabel24.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(36, 36, 36));
        jLabel24.setText("Student ID");
        panelBorder2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel26.setBackground(new java.awt.Color(36, 36, 36));
        jLabel26.setFont(new java.awt.Font("DVN-Poppins", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(36, 36, 36));
        jLabel26.setText("Student details");
        panelBorder2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        txt_StudentID.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_StudentID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_StudentID.setMargin(new java.awt.Insets(2, 10, 2, 10));
        panelBorder2.add(txt_StudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 250, -1));

        jLabel27.setBackground(new java.awt.Color(36, 36, 36));
        jLabel27.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(36, 36, 36));
        jLabel27.setText("Name of student");
        panelBorder2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        txt_StudentName.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_StudentName.setForeground(new java.awt.Color(36, 36, 36));
        txt_StudentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_StudentName.setCaretColor(new java.awt.Color(36, 36, 36));
        txt_StudentName.setMargin(new java.awt.Insets(2, 10, 2, 10));
        panelBorder2.add(txt_StudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 250, -1));

        jLabel28.setBackground(new java.awt.Color(36, 36, 36));
        jLabel28.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(36, 36, 36));
        jLabel28.setText("Year");
        panelBorder2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        txt_year.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "K18", "K19", "K20", "K21", "K22", "K23", "K24" }));
        txt_year.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_year.setOpaque(true);
        panelBorder2.add(txt_year, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 250, -1));

        jLabel29.setBackground(new java.awt.Color(36, 36, 36));
        jLabel29.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(36, 36, 36));
        jLabel29.setText("Branch");
        panelBorder2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        txt_branch.setFont(new java.awt.Font("DVN-Poppins", 0, 18)); // NOI18N
        txt_branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Công nghệ Thông tin", "Hệ thống Thông tin", "Khoa học Máy tính", "Kỹ thuật Phần mềm", "Kỹ thuật Máy tính", "An toàn Thông tin", "Thương mại Điện tử", "Khoa học Dữ liệu" }));
        txt_branch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 204)));
        txt_branch.setOpaque(true);
        panelBorder2.add(txt_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 250, -1));

        kGradientPanel2.add(panelBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 320, 540));

        jLabel11.setFont(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Remove");
        kGradientPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 680, -1, -1));

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
        kGradientPanel2.add(removeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 670, 100, 40));

        jLabel12.setFont(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(36, 36, 36));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Update");
        kGradientPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 680, -1, -1));

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
        kGradientPanel2.add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 670, 110, 40));

        jLabel13.setFont(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(36, 36, 36));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Add");
        kGradientPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 680, -1, -1));

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
        kGradientPanel2.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 670, 90, 40));

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
        // TODO add your handling code here:
        String query = txt_Search.getText();
        filter(query);
    }// GEN-LAST:event_txt_SearchKeyReleased

    private void studentDetailsTableMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_studentDetailsTableMouseClicked
        // TODO add your handling code here:
        int i = studentDetailsTable.getSelectedRow();
        TableModel model = studentDetailsTable.getModel();
        txt_StudentID.setText(model.getValueAt(i, 0).toString());
        txt_StudentName.setText(model.getValueAt(i, 1).toString());
        txt_branch.setSelectedItem(model.getValueAt(i, 2).toString());
        txt_year.setSelectedItem(model.getValueAt(i, 3).toString());
    }// GEN-LAST:event_studentDetailsTableMouseClicked

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_removeButtonActionPerformed
        // TODO add your handling code here:
        if (removeStudent()) {
            reloadTable();
        } else {
            JOptionPane.showMessageDialog(null, "Student ID does not exist");
        }
    }// GEN-LAST:event_removeButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_updateButtonActionPerformed
        if (updateStudent()) {
            reloadTable();
        } else {
            JOptionPane.showMessageDialog(null, "Cannot update Student ID");
        }
    }// GEN-LAST:event_updateButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addButtonActionPerformed
        if (addStudent()) {
            reloadTable();
        } else {
            JOptionPane.showMessageDialog(null, "Student ID already exists");
        }
    }// GEN-LAST:event_addButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton addButton;
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
    private rojeru_san.complementos.RSTableMetro studentDetailsTable;
    private javax.swing.JTextField txt_Search;
    private javax.swing.JTextField txt_StudentID;
    private javax.swing.JTextField txt_StudentName;
    private javax.swing.JComboBox<String> txt_branch;
    private javax.swing.JComboBox<String> txt_year;
    private com.k33ptoo.components.KButton updateButton;
    // End of variables declaration//GEN-END:variables
}
