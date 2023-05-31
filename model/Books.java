/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dangc
 */
public class Books {

    private int book_id;
    private String book_name;
    private String author;
    private int quantity;

    @Override
    public String toString() {
        return "Books{" + "book_id=" + book_id + ", book_name=" + book_name + ", author=" + author + ", quantity=" + quantity + '}';
    }

    public Books(int book_id, String book_name, String author, int quantity) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.author = author;
        this.quantity = quantity;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Books() {
    }

}
