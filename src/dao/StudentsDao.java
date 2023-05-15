/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Students;

/**
 *
 * @author winlax
 */
public class StudentsDao extends DBConnection {
  public Students manageStudents(int student_id, String student_name, String branch, String year) {
    Students student = null;
    try {
      String sql = "UPDATE students SET student_name = ?, branch = ?, year = ? WHERE student_id = ?";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, student_name);
      ps.setString(2, branch);
      ps.setString(3, year);
      ps.setInt(4, student_id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        student = new Students();
        student.setStudent_id(rs.getInt("student_id"));
        student.setStudent_name(rs.getString("student_name"));
        student.setBranch(rs.getString("branch"));
        student.setYear(rs.getString("year"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return student;
  }

}
