/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dangc
 */
public class ReturnBook {

    private IssueBook issueBook;
    private Students students;
    private Books books;

    @Override
    public String toString() {
        return "ReturnBook{" + "issueBook=" + issueBook + ", students=" + students + ", books=" + books + '}';
    }

    public ReturnBook(IssueBook issueBook, Students students, Books books) {
        this.issueBook = issueBook;
        this.students = students;
        this.books = books;
    }

    public IssueBook getIssueBook() {
        return issueBook;
    }

    public void setIssueBook(IssueBook issueBook) {
        this.issueBook = issueBook;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

}
