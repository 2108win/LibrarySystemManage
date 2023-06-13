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
    private double issue_fee;

    @Override
    public String toString() {
        return "IssueBook{" + "issue_id=" + issue_id + ", book_id=" + book_id + ", book_name=" + book_name
                + ", student_id=" + student_id + ", student_name=" + student_name + ", issue_date=" + issue_date
                + ", due_date=" + due_date + ", status=" + status + ", issue_fee=" + issue_fee + '}';
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
        this.issue_fee = 0.0;
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

    public double getIssue_fee() {
        return issue_fee;
    }

    public void setIssue_fee(double issue_fee) {
        this.issue_fee = issue_fee;
    }

    public double calculateFee(double book_fee, Date due_date) {
        // daysLate là số ngày tính từ due_date đến ngày hôm nay
        Date currentDate = new Date();
        long daysLate = (currentDate.getTime() - due_date.getTime()) / (24 * 60 * 60 * 1000);
        // System.out.println("daysLate: " + daysLate);
        double Fee = 0.0;
        if (daysLate > 0) {
            if (daysLate <= 10) {
                Fee = book_fee * 1.1;
            } else {
                Fee = book_fee * 3;
            }
        } else {
            Fee = book_fee;
        }
        return Fee;
    }

    public void returnBook(Users user, double bookFee, Date dueDate, String status) {
        // Cập nhật số tiền đã nhận
        if (status.equals("Returned")) {
            double receivedAmount = user.getFee_returned();
            user.setFee_returned(receivedAmount);
            // Tính phí trả sách
            double returnFee = calculateFee(bookFee, dueDate);
            // Cập nhật số tiền phí trả sách
            double feeReturn = user.getFee_returned();
            feeReturn += returnFee;
            user.setFee_returned(feeReturn);
        } else {
            double pendingAmount = user.getFee_pending();
            pendingAmount += bookFee;
            user.setFee_pending(pendingAmount);
        }
    }
}
