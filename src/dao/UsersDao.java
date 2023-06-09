/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Users;

/**
 *
 * @author winlax
 */
public class UsersDao extends DBConnection {
  public Users userLogin(String name, String password) {
    Users user = null;
    try {
      String sql = "select * from users where name=? and password=?";
      PreparedStatement pst = getConnection().prepareStatement(sql);
      pst.setString(1, name);
      pst.setString(2, password);
      ResultSet rs = pst.executeQuery();
      if (rs.next()) {
        user = new Users();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));
        user.setContact(rs.getString("contact"));
        user.setFee_pending(rs.getDouble("fee_pending"));
        user.setFee_returned(rs.getDouble("fee_returned"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return user;
  }

  public boolean userRegister(Users user) {
    boolean flag = false;
    try {
      String sql = "insert into users(name, password, email, contact) values(?,?,?,?)";
      PreparedStatement pst = getConnection().prepareStatement(sql);
      pst.setString(1, user.getName());
      pst.setString(2, user.getPassword());
      pst.setString(3, user.getEmail());
      pst.setString(4, user.getContact());
      int i = pst.executeUpdate();
      if (i == 1) {
        flag = true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return flag;
  }

  // check if user exists
  public boolean userExists(String name) {
    boolean flag = false;
    try {
      String sql = "select * from users where name=?";
      PreparedStatement pst = getConnection().prepareStatement(sql);
      pst.setString(1, name);
      ResultSet rs = pst.executeQuery();
      if (rs.next()) {
        flag = true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return flag;
  }
}
