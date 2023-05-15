/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author dangc
 */
public class IssueBook {
    private int issue_id;
    private Books book;
    private Students student;
    private Date issue_date;
    private Date return_date;
    private String status;

    @Override
    public String toString() {
        return "IssueBook{" + "issue_id=" + issue_id + "d=\" + iss, book=" + book + ", student=" + student + ", issue_date=" + issue_date + ", return_date=" + return_date + ", status=" + status + '}';
    }

    public IssueBook(int issue_id, Books book, Students student, Date issue_date, Date return_date, String status) {
        this.book = book;
        this.student = student;
        this.issue_date = issue_date;
        this.return_date = return_date;
        this.status = status;
    }

    public IssueBook() {
    }

    public int getIssue_id() {
        return issue_id;
    }

    public void setIssue_id(int issue_id) {
        this.issue_id = issue_id;
    }

    public void setBook_id(int book_id) {
        this.book.setBook_id(book_id);
    }

    public int getBook_id() {
        return this.book.getBook_id();
    }

    public void setBook_name(String book_name) {
        this.book.setBook_name(book_name);
    }

    public String getBook_name() {
        return this.book.getBook_name();
    }

    public void setStudent_name(String student_name) {
        this.student.setStudent_name(student_name);
    }

    public String getStudent_name() {
        return this.student.getStudent_name();
    }

    public void setStudent_id(int student_id) {
        this.student.setStudent_id(student_id);
    }

    public int getStudent_id() {
        return this.student.getStudent_id();
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    public Date getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(Date issue_date) {
        this.issue_date = issue_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
