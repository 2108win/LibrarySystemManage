/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Books;
// import model.Students;

/**
 *
 * @author winlax
 */
public class BooksDao extends DBConnection {
  public Books manageBooks(int book_id, String book_name, String author, int quantity, double book_fee) {
    Books book = null;
    try {
      String sql = "SELECT * FROM book_details WHERE book_id = ? AND book_name = ? AND author = ? AND quantity = ? AND book_fee = ? ";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, book_id);
      ps.setString(2, book_name);
      ps.setString(3, author);
      ps.setInt(4, quantity);
      ps.setDouble(5, book_fee);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        book = new Books();
        book.setBook_id(rs.getInt("book_id"));
        book.setBook_name(rs.getString("book_name"));
        book.setAuthor(rs.getString("author"));
        book.setQuantity(rs.getInt("quantity"));
        book.setBook_fee(rs.getDouble("book_fee"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return book;
  }

  public ArrayList<Books> getAllBooks() {
    ArrayList<Books> books = new ArrayList<>();
    try {
      String sql = "SELECT * FROM book_details";
      PreparedStatement ps = con.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        Books book = new Books();
        book.setBook_id(rs.getInt("book_id"));
        book.setBook_name(rs.getString("book_name"));
        book.setAuthor(rs.getString("author"));
        book.setQuantity(rs.getInt("quantity"));
        book.setBook_fee(rs.getDouble("book_fee"));
        books.add(book);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return books;
  }

  // get book by id
  public Books getBookById(int book_id) {
    Books book = null;
    try {
      String sql = "SELECT * FROM book_details WHERE book_id = ?";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, book_id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        book = new Books();
        book.setBook_id(rs.getInt("book_id"));
        book.setBook_name(rs.getString("book_name"));
        book.setAuthor(rs.getString("author"));
        book.setQuantity(rs.getInt("quantity"));
        book.setBook_fee(rs.getDouble("book_fee"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return book;
  }

  public Books updateBook(int book_id, String book_name, String author, int quantity, double book_fee) {
    Books book = null;
    try {
      String sql = "UPDATE book_details SET book_name = ?, author = ?, quantity = ?, book_fee = ? WHERE book_id = ?";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, book_name);
      ps.setString(2, author);
      ps.setInt(3, quantity);
      ps.setDouble(4, book_fee);
      ps.setInt(5, book_id);
      int i = ps.executeUpdate();
      if (i == 1) {
        book = new Books();
        book.setBook_id(book_id);
        book.setBook_name(book_name);
        book.setAuthor(author);
        book.setQuantity(quantity);
        book.setBook_fee(book_fee);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return book;
  }

  public void addBook(String book_name, String author, int quantity, double book_fee) {
    try {
      String sql = "INSERT INTO book_details (book_name, author, quantity, book_fee) VALUES (?, ?, ?, ?)";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, book_name);
      ps.setString(2, author);
      ps.setInt(3, quantity);
      ps.setDouble(4, book_fee);
      ps.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void deleteBook(int book_id) {
    try {
      String sql = "DELETE FROM book_details WHERE book_id = ?";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, book_id);
      ps.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
