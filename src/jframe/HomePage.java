/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import connect_database.DBConnection;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;

import javax.swing.table.DefaultTableModel;

//import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author dangc
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    String book_name, author, student_name, branch, year, status;
    int book_id, quantity, student_id, issue_id;
    Date issue_date, due_date;

    public HomePage() {
        initComponents();
        loadDataUser();
        setBookDetailToTable();
        setStudentDetailToTable();
        setStatusBookDetails();
        setIssueBookDetails();
        // showPieChart();
    }

    // public void showPieChart() {
    // String title = "Library Management System";
    // // create dataset from database book_details
    // DefaultPieDataset barDataset = new DefaultPieDataset();
    // JFreeChart piechart = ChartFactory.createPieChart(title, barDataset, false,
    // true, false);
    // PiePlot piePlot = (PiePlot) piechart.getPlot();
    // // random r, g, b to set color for pie chart
    // Random random = new Random();
    // try {
    // Connection con = DBConnection.getConnection();
    // Statement st = con.createStatement();
    // ResultSet rs = st.executeQuery("SELECT * FROM book_details");
    // while (rs.next()) {
    // int r = random.nextInt(255);
    // int g = random.nextInt(255);
    // int b = random.nextInt(255);
    // book_name = rs.getString("book_name");
    // quantity = rs.getInt("quantity");
    // if (quantity == 0) {
    // continue;
    // }
    // barDataset.setValue(book_name, quantity);
    // piePlot.setSectionPaint(book_name, new Color(r, 220, b));
    // }
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    //
    // // create chart
    // // set color and font for title
    // piechart.getTitle().setPaint(new Color(102, 102, 102));
    // piechart.getTitle().setFont(new Font("DVN-Poppins", Font.BOLD, 18));
    //
    // piePlot.setBackgroundPaint(Color.white);
    // // border none
    // piePlot.setOutlineVisible(false);
    //
    // // create chartPanel to display chart(graph)
    // ChartPanel barChartPanel = new ChartPanel(piechart);
    // panelPieChart.add(barChartPanel, BorderLayout.CENTER);
    // panelPieChart.validate();
    // }

    public void loadDataUser() {
        // connect to database get data user login

    }

    public void setDataUser() {
        // connect to database get data user login

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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dashboardButton = new com.k33ptoo.components.KButton();
        jLabel4 = new javax.swing.JLabel();
        homePageButton = new com.k33ptoo.components.KButton();
        jLabel5 = new javax.swing.JLabel();
        manageBookButton = new com.k33ptoo.components.KButton();
        jLabel6 = new javax.swing.JLabel();
        manageStudentsButton = new com.k33ptoo.components.KButton();
        jLabel7 = new javax.swing.JLabel();
        issueBookButton = new com.k33ptoo.components.KButton();
        jLabel8 = new javax.swing.JLabel();
        returnBookButton = new com.k33ptoo.components.KButton();
        jLabel9 = new javax.swing.JLabel();
        viewRecordsButton = new com.k33ptoo.components.KButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        defaultListButton = new com.k33ptoo.components.KButton();
        jLabel12 = new javax.swing.JLabel();
        logoutButton = new com.k33ptoo.components.KButton();
        viewIssueBooksButton = new com.k33ptoo.components.KButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(245, 246, 241)));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 80));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("DVN-Poppins ExtBd", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(247, 171, 10));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jLabel1.setText("Win Lã");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("DVN-Poppins ExtBd", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(247, 171, 10));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logoMain.png"))); // NOI18N
        jLabel2.setText("Library");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 70));

        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(245, 246, 241));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(204, 204, 204));
        jLabel13.setFont(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setLabelFor(dashboardButton);
        jLabel13.setText("Future");
        kGradientPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(36, 36, 36));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/dashboard.png"))); // NOI18N
        jLabel3.setLabelFor(dashboardButton);
        jLabel3.setText("   Dashboard");
        kGradientPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        dashboardButton.setAlignmentX(0.5F);
        dashboardButton.setFont(new java.awt.Font("DVN-Poppins", 1, 18)); // NOI18N
        dashboardButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        dashboardButton.setIconTextGap(2);
        dashboardButton.setkBackGroundColor(new java.awt.Color(247, 171, 10));
        dashboardButton.setkBorderRadius(20);
        dashboardButton.setkEndColor(new java.awt.Color(204, 204, 204));
        dashboardButton.setkForeGround(new java.awt.Color(36, 36, 36));
        dashboardButton.setkHoverEndColor(new java.awt.Color(247, 171, 10));
        dashboardButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        dashboardButton.setkHoverStartColor(new java.awt.Color(204, 204, 204));
        dashboardButton.setkSelectedColor(new java.awt.Color(247, 171, 10));
        dashboardButton.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.add(dashboardButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 230, -1));

        jLabel4.setFont(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home.png"))); // NOI18N
        jLabel4.setLabelFor(homePageButton);
        jLabel4.setText("   Home Page");
        kGradientPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        homePageButton.setAlignmentX(0.5F);
        homePageButton.setFont(new java.awt.Font("DVN-Poppins", 1, 18)); // NOI18N
        homePageButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        homePageButton.setIconTextGap(2);
        homePageButton.setkBackGroundColor(new java.awt.Color(247, 171, 10));
        homePageButton.setkBorderRadius(20);
        homePageButton.setkEndColor(new java.awt.Color(247, 171, 10));
        homePageButton.setkForeGround(new java.awt.Color(36, 36, 36));
        homePageButton.setkHoverColor(new java.awt.Color(204, 204, 204));
        homePageButton.setkHoverEndColor(new java.awt.Color(247, 171, 10));
        homePageButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        homePageButton.setkHoverStartColor(new java.awt.Color(247, 171, 10));
        homePageButton.setkSelectedColor(new java.awt.Color(247, 171, 10));
        homePageButton.setkStartColor(new java.awt.Color(247, 171, 10));
        kGradientPanel1.add(homePageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 230, -1));

        jLabel5.setFont(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(36, 36, 36));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book.png"))); // NOI18N
        jLabel5.setLabelFor(manageBookButton);
        jLabel5.setText("   Manage Book");
        kGradientPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        manageBookButton.setAlignmentX(0.5F);
        manageBookButton.setFont(new java.awt.Font("DVN-Poppins", 1, 18)); // NOI18N
        manageBookButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        manageBookButton.setIconTextGap(2);
        manageBookButton.setkBackGroundColor(new java.awt.Color(247, 171, 10));
        manageBookButton.setkBorderRadius(20);
        manageBookButton.setkEndColor(new java.awt.Color(204, 204, 204));
        manageBookButton.setkForeGround(new java.awt.Color(36, 36, 36));
        manageBookButton.setkHoverEndColor(new java.awt.Color(247, 171, 10));
        manageBookButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        manageBookButton.setkHoverStartColor(new java.awt.Color(204, 204, 204));
        manageBookButton.setkSelectedColor(new java.awt.Color(247, 171, 10));
        manageBookButton.setkStartColor(new java.awt.Color(255, 255, 255));
        manageBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageBookButtonActionPerformed(evt);
            }
        });
        kGradientPanel1.add(manageBookButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 230, -1));

        jLabel6.setFont(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(36, 36, 36));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/member.png"))); // NOI18N
        jLabel6.setLabelFor(manageStudentsButton);
        jLabel6.setText("   Manage Students");
        kGradientPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        manageStudentsButton.setAlignmentX(0.5F);
        manageStudentsButton.setFont(new java.awt.Font("DVN-Poppins", 1, 18)); // NOI18N
        manageStudentsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        manageStudentsButton.setIconTextGap(2);
        manageStudentsButton.setkBackGroundColor(new java.awt.Color(247, 171, 10));
        manageStudentsButton.setkBorderRadius(20);
        manageStudentsButton.setkEndColor(new java.awt.Color(204, 204, 204));
        manageStudentsButton.setkForeGround(new java.awt.Color(36, 36, 36));
        manageStudentsButton.setkHoverEndColor(new java.awt.Color(247, 171, 10));
        manageStudentsButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        manageStudentsButton.setkHoverStartColor(new java.awt.Color(204, 204, 204));
        manageStudentsButton.setkSelectedColor(new java.awt.Color(247, 171, 10));
        manageStudentsButton.setkStartColor(new java.awt.Color(255, 255, 255));
        manageStudentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageStudentsButtonActionPerformed(evt);
            }
        });
        kGradientPanel1.add(manageStudentsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 230, -1));

        jLabel7.setFont(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(36, 36, 36));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/issue.png"))); // NOI18N
        jLabel7.setLabelFor(issueBookButton);
        jLabel7.setText("   Issue Book");
        kGradientPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        issueBookButton.setAlignmentX(0.5F);
        issueBookButton.setFont(new java.awt.Font("DVN-Poppins", 1, 18)); // NOI18N
        issueBookButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        issueBookButton.setIconTextGap(2);
        issueBookButton.setkBackGroundColor(new java.awt.Color(247, 171, 10));
        issueBookButton.setkBorderRadius(20);
        issueBookButton.setkEndColor(new java.awt.Color(204, 204, 204));
        issueBookButton.setkForeGround(new java.awt.Color(36, 36, 36));
        issueBookButton.setkHoverEndColor(new java.awt.Color(247, 171, 10));
        issueBookButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        issueBookButton.setkHoverStartColor(new java.awt.Color(204, 204, 204));
        issueBookButton.setkSelectedColor(new java.awt.Color(247, 171, 10));
        issueBookButton.setkStartColor(new java.awt.Color(255, 255, 255));
        issueBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueBookButtonActionPerformed(evt);
            }
        });
        kGradientPanel1.add(issueBookButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 230, -1));

        jLabel8.setFont(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(36, 36, 36));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/return.png"))); // NOI18N
        jLabel8.setLabelFor(returnBookButton);
        jLabel8.setText("   Return Book");
        kGradientPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        returnBookButton.setAlignmentX(0.5F);
        returnBookButton.setFont(new java.awt.Font("DVN-Poppins", 1, 18)); // NOI18N
        returnBookButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        returnBookButton.setIconTextGap(2);
        returnBookButton.setkBackGroundColor(new java.awt.Color(247, 171, 10));
        returnBookButton.setkBorderRadius(20);
        returnBookButton.setkEndColor(new java.awt.Color(204, 204, 204));
        returnBookButton.setkForeGround(new java.awt.Color(36, 36, 36));
        returnBookButton.setkHoverEndColor(new java.awt.Color(247, 171, 10));
        returnBookButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        returnBookButton.setkHoverStartColor(new java.awt.Color(204, 204, 204));
        returnBookButton.setkSelectedColor(new java.awt.Color(247, 171, 10));
        returnBookButton.setkStartColor(new java.awt.Color(255, 255, 255));
        returnBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBookButtonActionPerformed(evt);
            }
        });
        kGradientPanel1.add(returnBookButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 230, -1));

        jLabel9.setFont(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(36, 36, 36));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/record.png"))); // NOI18N
        jLabel9.setLabelFor(viewRecordsButton);
        jLabel9.setText("   View Records");
        kGradientPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        viewRecordsButton.setAlignmentX(0.5F);
        viewRecordsButton.setFont(new java.awt.Font("DVN-Poppins", 1, 18)); // NOI18N
        viewRecordsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        viewRecordsButton.setIconTextGap(2);
        viewRecordsButton.setkBackGroundColor(new java.awt.Color(247, 171, 10));
        viewRecordsButton.setkBorderRadius(20);
        viewRecordsButton.setkEndColor(new java.awt.Color(204, 204, 204));
        viewRecordsButton.setkForeGround(new java.awt.Color(36, 36, 36));
        viewRecordsButton.setkHoverEndColor(new java.awt.Color(247, 171, 10));
        viewRecordsButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        viewRecordsButton.setkHoverStartColor(new java.awt.Color(204, 204, 204));
        viewRecordsButton.setkSelectedColor(new java.awt.Color(247, 171, 10));
        viewRecordsButton.setkStartColor(new java.awt.Color(255, 255, 255));
        viewRecordsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewRecordsButtonActionPerformed(evt);
            }
        });
        kGradientPanel1.add(viewRecordsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 230, -1));

        jLabel10.setFont(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(36, 36, 36));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/issue.png"))); // NOI18N
        jLabel10.setLabelFor(viewIssueBooksButton);
        jLabel10.setText("   View Issue Books");
        kGradientPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        jLabel11.setFont(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(36, 36, 36));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/scope.png"))); // NOI18N
        jLabel11.setLabelFor(defaultListButton);
        jLabel11.setText("   Default List");
        kGradientPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, -1));

        defaultListButton.setAlignmentX(0.5F);
        defaultListButton.setFont(new java.awt.Font("DVN-Poppins", 1, 18)); // NOI18N
        defaultListButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        defaultListButton.setIconTextGap(2);
        defaultListButton.setkBackGroundColor(new java.awt.Color(247, 171, 10));
        defaultListButton.setkBorderRadius(20);
        defaultListButton.setkEndColor(new java.awt.Color(204, 204, 204));
        defaultListButton.setkForeGround(new java.awt.Color(36, 36, 36));
        defaultListButton.setkHoverEndColor(new java.awt.Color(247, 171, 10));
        defaultListButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        defaultListButton.setkHoverStartColor(new java.awt.Color(204, 204, 204));
        defaultListButton.setkSelectedColor(new java.awt.Color(247, 171, 10));
        defaultListButton.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.add(defaultListButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 230, -1));

        jLabel12.setFont(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(36, 36, 36));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout.png"))); // NOI18N
        jLabel12.setLabelFor(logoutButton);
        jLabel12.setText("   Logout");
        kGradientPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 680, -1, -1));

        logoutButton.setAlignmentX(0.5F);
        logoutButton.setFont(new java.awt.Font("DVN-Poppins", 1, 18)); // NOI18N
        logoutButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        logoutButton.setIconTextGap(2);
        logoutButton.setkBackGroundColor(new java.awt.Color(247, 171, 10));
        logoutButton.setkBorderRadius(20);
        logoutButton.setkEndColor(new java.awt.Color(204, 204, 204));
        logoutButton.setkForeGround(new java.awt.Color(36, 36, 36));
        logoutButton.setkHoverEndColor(new java.awt.Color(247, 171, 10));
        logoutButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        logoutButton.setkHoverStartColor(new java.awt.Color(204, 204, 204));
        logoutButton.setkSelectedColor(new java.awt.Color(247, 171, 10));
        logoutButton.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 670, 230, -1));

        viewIssueBooksButton.setAlignmentX(0.5F);
        viewIssueBooksButton.setFont(new java.awt.Font("DVN-Poppins", 1, 18)); // NOI18N
        viewIssueBooksButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        viewIssueBooksButton.setIconTextGap(2);
        viewIssueBooksButton.setkBackGroundColor(new java.awt.Color(247, 171, 10));
        viewIssueBooksButton.setkBorderRadius(20);
        viewIssueBooksButton.setkEndColor(new java.awt.Color(204, 204, 204));
        viewIssueBooksButton.setkForeGround(new java.awt.Color(36, 36, 36));
        viewIssueBooksButton.setkHoverEndColor(new java.awt.Color(247, 171, 10));
        viewIssueBooksButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        viewIssueBooksButton.setkHoverStartColor(new java.awt.Color(204, 204, 204));
        viewIssueBooksButton.setkSelectedColor(new java.awt.Color(247, 171, 10));
        viewIssueBooksButton.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.add(viewIssueBooksButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 230, -1));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 250, 730));

        kGradientPanel2.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        kGradientPanel2.setkBorderRadius(0);
        kGradientPanel2.setkEndColor(new java.awt.Color(204, 204, 204));
        kGradientPanel2.setkStartColor(new java.awt.Color(245, 246, 241));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder4.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        countReturnLabel.setFont(new java.awt.Font("DVN-Poppins ExtBd", 1, 40)); // NOI18N
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

        countPendingLabel.setFont(new java.awt.Font("DVN-Poppins ExtBd", 1, 40)); // NOI18N
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

        countStudentLabel.setFont(new java.awt.Font("DVN-Poppins ExtBd", 1, 40)); // NOI18N
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

        countBookLabel.setFont(new java.awt.Font("DVN-Poppins ExtBd", 1, 40)); // NOI18N
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
        jScrollPane4.setBorder(new javax.swing.border.MatteBorder(null));
        jScrollPane4.setForeground(new java.awt.Color(255, 255, 255));

        IssueBookDetailsTable.setForeground(new java.awt.Color(255, 255, 255));
        IssueBookDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "ID", "Book ID", "Book Name", "Student ID", "Student Name", "Issue Date", "Due Date", "Status"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
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
        IssueBookDetailsTable.setFuenteHead(new java.awt.Font("DVN-Poppins", 1, 14)); // NOI18N
        IssueBookDetailsTable.setGridColor(new java.awt.Color(255, 255, 255));
        IssueBookDetailsTable.setRowHeight(34);
        IssueBookDetailsTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        IssueBookDetailsTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        IssueBookDetailsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(IssueBookDetailsTable);
        if (IssueBookDetailsTable.getColumnModel().getColumnCount() > 0) {
            IssueBookDetailsTable.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        panelBorder5.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 850, 200));

        jLabel25.setBackground(new java.awt.Color(36, 36, 36));
        jLabel25.setFont(new java.awt.Font("DVN-Poppins", 1, 15)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setLabelFor(seeMoreViewIssueBooksButton);
        jLabel25.setText("See more >");
        panelBorder5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, -1, 20));

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
        panelBorder5.add(seeMoreViewIssueBooksButton,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 140, 20));

        jLabel26.setBackground(new java.awt.Color(36, 36, 36));
        jLabel26.setFont(new java.awt.Font("DVN-Poppins", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("Issue List");
        panelBorder5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        kGradientPanel2.add(panelBorder5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 890, 270));

        getContentPane().add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 950, 730));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void manageBookButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_manageBookButtonActionPerformed
        ManageBook mb = new ManageBook();
        mb.setVisible(true);
        this.dispose();

    }// GEN-LAST:event_manageBookButtonActionPerformed

    private void manageStudentsButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_manageStudentsButtonActionPerformed
        ManageStudents ms = new ManageStudents();
        ms.setVisible(true);
        this.dispose();
    }// GEN-LAST:event_manageStudentsButtonActionPerformed

    private void issueBookButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_issueBookButtonActionPerformed
        IssueBook ib = new IssueBook();
        ib.setVisible(true);
        this.dispose();
    }// GEN-LAST:event_issueBookButtonActionPerformed

    private void returnBookButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_returnBookButtonActionPerformed
        ReturnBook rb = new ReturnBook();
        rb.setVisible(true);
        this.dispose();
    }// GEN-LAST:event_returnBookButtonActionPerformed

    private void viewRecordsButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_viewRecordsButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_viewRecordsButtonActionPerformed

    private void viewIssueBooksButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_viewIssueBooksButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_viewIssueBooksButtonActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomePage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSTableMetro IssueBookDetailsTable;
    private javax.swing.JLabel countBookLabel;
    private javax.swing.JLabel countPendingLabel;
    private javax.swing.JLabel countReturnLabel;
    private javax.swing.JLabel countStudentLabel;
    private com.k33ptoo.components.KButton dashboardButton;
    private com.k33ptoo.components.KButton defaultListButton;
    private com.k33ptoo.components.KButton homePageButton;
    private com.k33ptoo.components.KButton issueBookButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private com.k33ptoo.components.KButton logoutButton;
    private com.k33ptoo.components.KButton manageBookButton;
    private com.k33ptoo.components.KButton manageStudentsButton;
    private components.PanelBorder panelBorder1;
    private components.PanelBorder panelBorder2;
    private components.PanelBorder panelBorder3;
    private components.PanelBorder panelBorder4;
    private components.PanelBorder panelBorder5;
    private com.k33ptoo.components.KButton returnBookButton;
    private com.k33ptoo.components.KButton seeMoreViewIssueBooksButton;
    private com.k33ptoo.components.KButton viewIssueBooksButton;
    private com.k33ptoo.components.KButton viewRecordsButton;
    // End of variables declaration//GEN-END:variables
}
