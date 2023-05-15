/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library_management_system;

/**
 *
 * @author dangc
 */
public class ReturnBook {

    private IssueBook issueBook;
    private Students students;
    private Books books;

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
