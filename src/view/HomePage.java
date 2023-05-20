/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Color;

import components.TopBar;
import view.LoginPage;

// import dao.DBConnection;
// import java.sql.Connection;
// import java.sql.ResultSet;
// import java.sql.Statement;
// import java.util.Date;

// import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dangc
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    // String book_name, author, student_name, branch, year, status;
    // int book_id, quantity, student_id, issue_id;
    // Date issue_date, due_date;
    Color pressColor = new Color(247, 171, 10);
    Color defaultStartColor = new Color(255, 255, 255);
    Color defaultEndColor = new Color(204, 204, 204);

    public HomePage() {
        initComponents();
        topBar.initMoving(this);
        // loadDataUser();
        loadDataUser();
        // setBookDetailToTable();
        // setStudentDetailToTable();
        // setStatusBookDetails();
        // setIssueBookDetails();
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
        if (LoginPage.currentUser == null) {
            LoginPage loginPage = new LoginPage();
            loginPage.setVisible(true);
            this.dispose();
        }
        String name = LoginPage.currentUser.getName();
        currentNameLabel.setText(name);
        components.HomePage home = new components.HomePage();
        mainPanel.removeAll();
        mainPanel.add(home).setVisible(true);
    }

    public void setDataUser() {
        // connect to database get data user login

    }

    // public void setStudentDetailToTable() {
    // // connect to database
    // int countStudent = 0;
    // try {
    // Class.forName("com.mysql.cj.jdbc.Driver");
    // Connection con = DBConnection.getConnection();
    // Statement st = con.createStatement();
    // ResultSet rs = st.executeQuery("select * from student_details");
    // while (rs.next()) {
    // countStudent++;
    // // student_id = rs.getInt("student_id");
    // // student_name = rs.getString("student_name");
    // // branch = rs.getString("branch");
    // // year = rs.getString("year");
    // // DefaultTableModel model = (DefaultTableModel) tableStudent.getModel();
    // // model.addRow(new Object[] { student_id, student_name, branch, year });
    // }
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // countStudentLabel.setText(" " + String.valueOf(countStudent));
    // }

    // public void setBookDetailToTable() {
    // // connect to database
    // int countBook = 0;
    // try {
    // Connection con = DBConnection.getConnection();
    // Statement st = con.createStatement();
    // ResultSet rs = st.executeQuery("SELECT * FROM book_details");
    // while (rs.next()) {
    // countBook++;
    // // book_id = rs.getInt("book_id");
    // // book_name = rs.getString("book_name");
    // // author = rs.getString("author");
    // // quantity = rs.getInt("quantity");
    // // DefaultTableModel model = (DefaultTableModel) tableBook.getModel();
    // // model.addRow(new Object[] { book_id, book_name, author, quantity });
    // }

    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // countBookLabel.setText(" " + String.valueOf(countBook));
    // }

    // public void setStatusBookDetails() {
    // int countPending = 0;
    // int countReturn = 0;
    // try {
    // Connection con = DBConnection.getConnection();
    // Statement st = con.createStatement();
    // ResultSet rs = st.executeQuery("SELECT * FROM issue_book_details where
    // status='Pending'");
    // while (rs.next()) {
    // countPending++;
    // }
    // ResultSet rs1 = st.executeQuery("SELECT * FROM issue_book_details where
    // status='Returned'");
    // while (rs1.next()) {
    // countReturn++;
    // }
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // countPendingLabel.setText(" " + String.valueOf(countPending));
    // countReturnLabel.setText(" " + String.valueOf(countReturn));
    // }

    // public void setIssueBookDetails() {
    // try {
    // Connection con = DBConnection.getConnection();
    // Statement st = con.createStatement();
    // ResultSet rs = st.executeQuery("SELECT * FROM issue_book_details");
    // while (rs.next()) {
    // issue_id = rs.getInt("issue_id");
    // book_id = rs.getInt("book_id");
    // book_name = rs.getString("book_name");
    // student_id = rs.getInt("student_id");
    // student_name = rs.getString("student_name");
    // issue_date = rs.getDate("issue_date");
    // due_date = rs.getDate("due_date");
    // status = rs.getString("status");
    // DefaultTableModel model = (DefaultTableModel)
    // IssueBookDetailsTable.getModel();
    // model.addRow(new Object[] { issue_id, book_id, book_name, student_id,
    // student_name, issue_date,
    // due_date, status });
    // }

    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // }

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
        currentNameLabel = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        topBar = new components.TopBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        kGradientPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jLabel3.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(36, 36, 36));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/dashboard.png"))); // NOI18N
        jLabel3.setLabelFor(dashboardButton);
        jLabel3.setText("   Dashboard");
        kGradientPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        dashboardButton.setBorder(null);
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
        kGradientPanel1.add(dashboardButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 230, -1));

        jLabel4.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home.png"))); // NOI18N
        jLabel4.setLabelFor(homePageButton);
        jLabel4.setText("   Home Page");
        kGradientPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        homePageButton.setBorder(null);
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
        homePageButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                homePageButtonMousePressed(evt);
            }
        });
        homePageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homePageButtonActionPerformed(evt);
            }
        });
        kGradientPanel1.add(homePageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 230, -1));

        jLabel5.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(36, 36, 36));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book.png"))); // NOI18N
        jLabel5.setLabelFor(manageBookButton);
        jLabel5.setText("   Manage Book");
        kGradientPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        manageBookButton.setBorder(null);
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
        manageBookButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                manageBookButtonMousePressed(evt);
            }
        });
        manageBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageBookButtonActionPerformed(evt);
            }
        });
        kGradientPanel1.add(manageBookButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 230, -1));

        jLabel6.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(36, 36, 36));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/member.png"))); // NOI18N
        jLabel6.setLabelFor(manageStudentsButton);
        jLabel6.setText("   Manage Students");
        kGradientPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        manageStudentsButton.setBorder(null);
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
        manageStudentsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                manageStudentsButtonMousePressed(evt);
            }
        });
        manageStudentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageStudentsButtonActionPerformed(evt);
            }
        });
        kGradientPanel1.add(manageStudentsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 230, -1));

        jLabel7.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(36, 36, 36));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/issue.png"))); // NOI18N
        jLabel7.setLabelFor(issueBookButton);
        jLabel7.setText("   Issue Book");
        kGradientPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        issueBookButton.setBorder(null);
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
        issueBookButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                issueBookButtonMousePressed(evt);
            }
        });
        issueBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueBookButtonActionPerformed(evt);
            }
        });
        kGradientPanel1.add(issueBookButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 230, -1));

        jLabel8.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(36, 36, 36));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/return.png"))); // NOI18N
        jLabel8.setLabelFor(returnBookButton);
        jLabel8.setText("   Return Book");
        kGradientPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        returnBookButton.setBorder(null);
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
        returnBookButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                returnBookButtonMousePressed(evt);
            }
        });
        returnBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBookButtonActionPerformed(evt);
            }
        });
        kGradientPanel1.add(returnBookButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 230, -1));

        jLabel9.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(36, 36, 36));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/record.png"))); // NOI18N
        jLabel9.setLabelFor(viewRecordsButton);
        jLabel9.setText("   View Records");
        kGradientPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        viewRecordsButton.setBorder(null);
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
        kGradientPanel1.add(viewRecordsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 230, -1));

        jLabel10.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(36, 36, 36));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/issue.png"))); // NOI18N
        jLabel10.setLabelFor(viewIssueBooksButton);
        jLabel10.setText("   View Issue Books");
        kGradientPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, -1));

        jLabel11.setFont(new java.awt.Font("DVN-Poppins", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(36, 36, 36));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/scope.png"))); // NOI18N
        jLabel11.setLabelFor(defaultListButton);
        jLabel11.setText("   Default List");
        kGradientPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, -1, -1));

        defaultListButton.setBorder(null);
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
        kGradientPanel1.add(defaultListButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 230, -1));

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
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        kGradientPanel1.add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 670, 230, -1));

        viewIssueBooksButton.setBorder(null);
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
        kGradientPanel1.add(viewIssueBooksButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 230, -1));

        currentNameLabel.setFont(new java.awt.Font("DVN-Poppins", 1, 22)); // NOI18N
        currentNameLabel.setForeground(new java.awt.Color(247, 171, 10));
        currentNameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        currentNameLabel.setText("Win Lã");
        kGradientPanel1.add(currentNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 250, 730));

        mainPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mainPanel.setLayout(new java.awt.BorderLayout());
        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 950, 730));
        getContentPane().add(topBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 70));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void homePageButtonMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_homePageButtonMousePressed
        // TODO add your handling code here:
        homePageButton.setkStartColor(pressColor);
        homePageButton.setkEndColor(pressColor);
        manageBookButton.setkStartColor(defaultStartColor);
        manageBookButton.setkEndColor(defaultEndColor);
        manageStudentsButton.setkStartColor(defaultStartColor);
        manageStudentsButton.setkEndColor(defaultEndColor);
        issueBookButton.setkStartColor(defaultStartColor);
        issueBookButton.setkEndColor(defaultEndColor);
        returnBookButton.setkStartColor(defaultStartColor);
        returnBookButton.setkEndColor(defaultEndColor);
    }// GEN-LAST:event_homePageButtonMousePressed

    private void manageBookButtonMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_manageBookButtonMousePressed
        // TODO add your handling code here:
        homePageButton.setkStartColor(defaultStartColor);
        homePageButton.setkEndColor(defaultEndColor);
        manageBookButton.setkStartColor(pressColor);
        manageBookButton.setkEndColor(pressColor);
        manageStudentsButton.setkStartColor(defaultStartColor);
        manageStudentsButton.setkEndColor(defaultEndColor);
        issueBookButton.setkStartColor(defaultStartColor);
        issueBookButton.setkEndColor(defaultEndColor);
        returnBookButton.setkStartColor(defaultStartColor);
        returnBookButton.setkEndColor(defaultEndColor);
    }// GEN-LAST:event_manageBookButtonMousePressed

    private void manageStudentsButtonMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_manageStudentsButtonMousePressed
        // TODO add your handling code here:
        homePageButton.setkStartColor(defaultStartColor);
        homePageButton.setkEndColor(defaultEndColor);
        manageBookButton.setkStartColor(defaultStartColor);
        manageBookButton.setkEndColor(defaultEndColor);
        manageStudentsButton.setkStartColor(pressColor);
        manageStudentsButton.setkEndColor(pressColor);
        issueBookButton.setkStartColor(defaultStartColor);
        issueBookButton.setkEndColor(defaultEndColor);
        returnBookButton.setkStartColor(defaultStartColor);
        returnBookButton.setkEndColor(defaultEndColor);
    }// GEN-LAST:event_manageStudentsButtonMousePressed

    private void issueBookButtonMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_issueBookButtonMousePressed
        // TODO add your handling code here:
        homePageButton.setkStartColor(defaultStartColor);
        homePageButton.setkEndColor(defaultEndColor);
        manageBookButton.setkStartColor(defaultStartColor);
        manageBookButton.setkEndColor(defaultEndColor);
        manageStudentsButton.setkStartColor(defaultStartColor);
        manageStudentsButton.setkEndColor(defaultEndColor);
        issueBookButton.setkStartColor(pressColor);
        issueBookButton.setkEndColor(pressColor);
        returnBookButton.setkStartColor(defaultStartColor);
        returnBookButton.setkEndColor(defaultEndColor);
    }// GEN-LAST:event_issueBookButtonMousePressed

    private void returnBookButtonMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_returnBookButtonMousePressed
        // TODO add your handling code here:
        homePageButton.setkStartColor(defaultStartColor);
        homePageButton.setkEndColor(defaultEndColor);
        manageBookButton.setkStartColor(defaultStartColor);
        manageBookButton.setkEndColor(defaultEndColor);
        manageStudentsButton.setkStartColor(defaultStartColor);
        manageStudentsButton.setkEndColor(defaultEndColor);
        issueBookButton.setkStartColor(defaultStartColor);
        issueBookButton.setkEndColor(defaultEndColor);
        returnBookButton.setkStartColor(pressColor);
        returnBookButton.setkEndColor(pressColor);
    }// GEN-LAST:event_returnBookButtonMousePressed

    private void issueBookButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_issueBookButtonActionPerformed
        // TODO add your handling code here:
        components.IssueBook page = new components.IssueBook();
        mainPanel.removeAll();
        mainPanel.add(page).setVisible(true);
    }// GEN-LAST:event_issueBookButtonActionPerformed

    private void homePageButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_homePageButtonActionPerformed
        components.HomePage page = new components.HomePage();
        mainPanel.removeAll();
        mainPanel.add(page).setVisible(true);
    }// GEN-LAST:event_homePageButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_logoutButtonActionPerformed
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
        dispose();
    }// GEN-LAST:event_logoutButtonActionPerformed

    private void manageBookButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_manageBookButtonActionPerformed
        components.ManageBook page = new components.ManageBook();
        mainPanel.removeAll();
        mainPanel.add(page).setVisible(true);
    }// GEN-LAST:event_manageBookButtonActionPerformed

    private void manageStudentsButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_manageStudentsButtonActionPerformed
        components.ManageStudents page = new components.ManageStudents();
        mainPanel.removeAll();
        mainPanel.add(page).setVisible(true);
    }// GEN-LAST:event_manageStudentsButtonActionPerformed

    private void returnBookButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_returnBookButtonActionPerformed
        components.ReturnBook page = new components.ReturnBook();
        mainPanel.removeAll();
        mainPanel.add(page).setVisible(true);
    }// GEN-LAST:event_returnBookButtonActionPerformed

    private void viewRecordsButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_viewRecordsButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_viewRecordsButtonActionPerformed

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
    private javax.swing.JLabel currentNameLabel;
    private com.k33ptoo.components.KButton dashboardButton;
    private com.k33ptoo.components.KButton defaultListButton;
    private com.k33ptoo.components.KButton homePageButton;
    private com.k33ptoo.components.KButton issueBookButton;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private com.k33ptoo.components.KButton logoutButton;
    private javax.swing.JPanel mainPanel;
    private com.k33ptoo.components.KButton manageBookButton;
    private com.k33ptoo.components.KButton manageStudentsButton;
    private com.k33ptoo.components.KButton returnBookButton;
    private components.TopBar topBar;
    private com.k33ptoo.components.KButton viewIssueBooksButton;
    private com.k33ptoo.components.KButton viewRecordsButton;
    // End of variables declaration//GEN-END:variables
}
