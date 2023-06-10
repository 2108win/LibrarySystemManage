/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.IssueBook;

/**
 *
 * @author winlax
 */
public class IssueBookDao extends DBConnection {
  public IssueBook issueBook(int issue_id, int book_id, String book_name, int student_id, String student_name,
      String issue_date, String due_date, String status) {
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
        issueBook.setDue_date(rs.getDate("due_date"));
        issueBook.setStatus(rs.getString("status"));
      }
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
    return issueBook;
  }

  public ArrayList<IssueBook> getAllIssueBooks() {
    ArrayList<IssueBook> issueBooks = new ArrayList<>();
    try {
      String sql = "SELECT * FROM issue_book_details ORDER BY issue_id DESC";
      PreparedStatement ps = con.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        IssueBook issueBook = new IssueBook();
        issueBook.setIssue_id(rs.getInt("issue_id"));
        issueBook.setBook_id(rs.getInt("book_id"));
        issueBook.setBook_name(rs.getString("book_name"));
        issueBook.setStudent_id(rs.getInt("student_id"));
        issueBook.setStudent_name(rs.getString("student_name"));
        issueBook.setIssue_date(rs.getDate("issue_date"));
        issueBook.setDue_date(rs.getDate("due_date"));
        issueBook.setStatus(rs.getString("status"));
        issueBooks.add(issueBook);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return issueBooks;
  }

  // get IssueBook have status = "Pending"
  public ArrayList<IssueBook> getPendingIssueBooks() {
    ArrayList<IssueBook> issueBooks = new ArrayList<>();
    try {
      String sql = "SELECT * FROM issue_book_details WHERE (status = 'Pending' or status = 'Overdue') ORDER BY issue_id DESC";
      PreparedStatement ps = con.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        IssueBook issueBook = new IssueBook();
        issueBook.setIssue_id(rs.getInt("issue_id"));
        issueBook.setBook_id(rs.getInt("book_id"));
        issueBook.setBook_name(rs.getString("book_name"));
        issueBook.setStudent_id(rs.getInt("student_id"));
        issueBook.setStudent_name(rs.getString("student_name"));
        issueBook.setIssue_date(rs.getDate("issue_date"));
        issueBook.setDue_date(rs.getDate("due_date"));
        issueBook.setStatus(rs.getString("status"));
        issueBooks.add(issueBook);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return issueBooks;
  }

  // get IssueBook have status = "Returned"
  public ArrayList<IssueBook> getReturnedIssueBooks() {
    ArrayList<IssueBook> issueBooks = new ArrayList<>();
    try {
      String sql = "SELECT * FROM issue_book_details WHERE status = 'Returned'";
      PreparedStatement ps = con.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        IssueBook issueBook = new IssueBook();
        issueBook.setIssue_id(rs.getInt("issue_id"));
        issueBook.setBook_id(rs.getInt("book_id"));
        issueBook.setBook_name(rs.getString("book_name"));
        issueBook.setStudent_id(rs.getInt("student_id"));
        issueBook.setStudent_name(rs.getString("student_name"));
        issueBook.setIssue_date(rs.getDate("issue_date"));
        issueBook.setDue_date(rs.getDate("due_date"));
        issueBook.setStatus(rs.getString("status"));
        issueBooks.add(issueBook);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return issueBooks;
  }

  // get IssueBook have status = "Overdue"
  public ArrayList<IssueBook> getOverdueIssueBooks() {
    ArrayList<IssueBook> issueBooks = new ArrayList<>();
    try {
      String sql = "SELECT * FROM issue_book_details WHERE status = 'Overdue'";
      PreparedStatement ps = con.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        IssueBook issueBook = new IssueBook();
        issueBook.setIssue_id(rs.getInt("issue_id"));
        issueBook.setBook_id(rs.getInt("book_id"));
        issueBook.setBook_name(rs.getString("book_name"));
        issueBook.setStudent_id(rs.getInt("student_id"));
        issueBook.setStudent_name(rs.getString("student_name"));
        issueBook.setIssue_date(rs.getDate("issue_date"));
        issueBook.setDue_date(rs.getDate("due_date"));
        issueBook.setStatus(rs.getString("status"));
        issueBooks.add(issueBook);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return issueBooks;
  }

  public int getCountBookById(int book_id) {
    int count = 0;
    try {
      String sql = "SELECT COUNT(*) FROM issue_book_details WHERE book_id = ?";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, book_id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        count = rs.getInt(1);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }

  public static int getBook_idByIssue_id(int issue_id) {
    int book_id = 0;
    try {
      String sql = "SELECT book_id FROM issue_book_details WHERE issue_id = ?";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, issue_id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        book_id = rs.getInt("book_id");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return book_id;
  }

  public ArrayList<IssueBook> getBooksByStudentName(String student_name) {
    ArrayList<IssueBook> issueBooks = new ArrayList<>();
    try {
      String sql = "SELECT * FROM issue_book_details WHERE student_name = ? and status = 'Pending'";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, student_name);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        IssueBook issueBook = new IssueBook();
        issueBook.setIssue_id(rs.getInt("issue_id"));
        issueBook.setBook_id(rs.getInt("book_id"));
        issueBook.setBook_name(rs.getString("book_name"));
        issueBook.setStudent_id(rs.getInt("student_id"));
        issueBook.setStudent_name(rs.getString("student_name"));
        issueBook.setIssue_date(rs.getDate("issue_date"));
        issueBook.setDue_date(rs.getDate("due_date"));
        issueBook.setStatus(rs.getString("status"));
        issueBooks.add(issueBook);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return issueBooks;
  }

  // update issue_fee
  public boolean updateIssueFee(int issue_id, double issue_fee) {
    boolean status = false;
    try {
      String sql = "UPDATE issue_book_details SET issue_fee = ? WHERE issue_id = ?";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setDouble(1, issue_fee);
      ps.setInt(2, issue_id);
      int rs = ps.executeUpdate();
      if (rs > 0) {
        status = true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return status;
  }

  // get issue_fee by issue_id
  public double getIssueFeeByIssueId(int issue_id) {
    double issue_fee = 0;
    try {
      String sql = "SELECT issue_fee FROM issue_book_details WHERE issue_id = ?";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, issue_id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        issue_fee = rs.getDouble("issue_fee");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return issue_fee;
  }

}
