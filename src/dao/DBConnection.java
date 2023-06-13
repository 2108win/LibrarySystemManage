/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author dangc
 */
public class DBConnection {
    static Connection con = null;

    public static Connection getConnection() {
        try {
            if (con == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                // mặc định sẽ là localhost:3306
                // con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms",
                // "root", "123456");
                con = DriverManager.getConnection("jdbc:mysql://localhost:8111/library_ms", "root", "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
