/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import model.IssueBook;
import model.ReturnBook;

import java.beans.JavaBean;
import java.util.Date;

import model.Books;
import model.Students;
import model.Users;

/**
 *
 * @author dangc
 */
public class TestFeeReturn {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Date i_date = new Date(123, 5, 25),
                d_date = new Date(123, 5, 9), currentDate = new Date();

        Users user = new Users(1, "Dang", "123", "w@gsdf.cs", "admin", 0, 0);
        Books book = new Books(1, "Java", "Dang", 10, 1000);
        IssueBook issueBook = new IssueBook(1, 1, "JavaBean", 112, "WinLax", i_date, d_date, "Returned");
        System.out.println(issueBook.toString());
        System.out.println("idate" + issueBook.getIssue_date());
        System.out.println("ddate" + issueBook.getDue_date());
        System.out.println("cdate" + currentDate);
        double fee;
        fee = issueBook.calculateFeeReturn(book.getBook_fee(), currentDate);
        issueBook.returnBook(user, book.getBook_fee(), issueBook.getDue_date(), issueBook.getStatus());
        System.out.println("User pending : " + user.getFee_pending());
        System.out.println("User returned : " + user.getFee_returned());
        System.out.println("User pending : " + user.getFee_pending());
        System.out.println("User returned : " + user.getFee_returned());
    }

}
