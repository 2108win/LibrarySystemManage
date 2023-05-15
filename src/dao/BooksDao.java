/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Books;

/**
 *
 * @author winlax
 */
public class BooksDao extends DBConnection {
  public Books manageBooks(int book_id, String book_name, String author, int quantity) {
    Books book = null;
    try {
      String sql = "SELECT * FROM book_details WHERE book_id = ? AND book_name = ? AND author = ? AND quantity = ? ";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, book_id);
      ps.setString(2, book_name);
      ps.setString(3, author);
      ps.setInt(4, quantity);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        book = new Books();
        book.setBook_id(rs.getInt("book_id"));
        book.setBook_name(rs.getString("book_name"));
        book.setAuthor(rs.getString("author"));
        book.setQuantity(rs.getInt("quantity"));

      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return book;
  }
}
