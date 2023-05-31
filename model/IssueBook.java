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
    private int book_id;
    private String book_name;
    private int student_id;
    private String student_name;
    private Date issue_date;
    private Date due_date;
    private String status;

    @Override
    public String toString() {
        return "IssueBook{" + "issue_id=" + issue_id + ", book_id=" + book_id + ", book_name=" + book_name
                + ", student_id=" + student_id + ", student_name=" + student_name + ", issue_date=" + issue_date
                + ", due_date=" + due_date + ", status=" + status + '}';
    }

    public IssueBook(int issue_id, int book_id, String book_name, int student_id, String student_name, Date issue_date,
            Date due_date, String status) {
        this.issue_id = issue_id;
        this.book_id = book_id;
        this.book_name = book_name;
        this.student_id = student_id;
        this.student_name = student_name;
        this.issue_date = issue_date;
        this.due_date = due_date;
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
        this.book_id = book_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public Date getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(Date issue_date) {
        this.issue_date = issue_date;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
