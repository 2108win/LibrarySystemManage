/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.IssueBook;

/**
 *
 * @author winlax
 */
public class IssueBookDao extends DBConnection {
  public IssueBook issueBook(int issue_id, int book_id, String book_name, int student_id, String student_name,
      String issue_date, String return_date, String status) {
    IssueBook issueBook = new IssueBook();
    try {
      String sql = "select * from issue_book_details where id=?";
      PreparedStatement pst = con.prepareStatement(sql);
      pst.setInt(issue_id, issue_id);
      ResultSet rs = pst.executeQuery();
      if (rs.next()) {
        issueBook.setIssue_id(rs.getInt("issue_id"));
        issueBook.setBook_id(rs.getInt("book_id"));
        issueBook.setBook_name(rs.getString("book_name"));
        issueBook.setStudent_id(rs.getInt("student_id"));
        issueBook.setStudent_name(rs.getString("student_name"));
        issueBook.setIssue_date(rs.getDate("issue_date"));
        issueBook.setReturn_date(rs.getDate("return_date"));
        issueBook.setStatus(rs.getString("status"));
      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
    return issueBook;
  }

}
