/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library_management_system;

import java.util.Date;

/**
 *
 * @author dangc
 */
public class IssueBook {

    private Books book;
    private Students student;
    private Date issue_date;
    private Date return_date;
    private String status;

    public IssueBook(Books book, Students student, Date issue_date, Date return_date, String status) {
        this.book = book;
        this.student = student;
        this.issue_date = issue_date;
        this.return_date = return_date;
        this.status = status;
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
