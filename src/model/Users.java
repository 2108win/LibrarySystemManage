/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dangc
 */
public class Users {

    private int id;
    private String name;
    private String email;
    private String password;
    private String contact;
    private double fee_pending;
    private double fee_returned;

    @Override
    public String toString() {
        return id + "_" + name;
    }

    public Users() {
    }

    public Users(int id, String name, String password, String email, String contact, double fee_pending,
            double fee_returned) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.contact = contact;
        this.fee_pending = fee_pending;
        this.fee_returned = fee_returned;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public double getFee_pending() {
        return fee_pending;
    }

    public void setFee_pending(double fee_pending) {
        this.fee_pending = fee_pending;
    }

    public double getFee_returned() {
        return fee_returned;
    }

    public void setFee_returned(double fee_returned) {
        this.fee_returned = fee_returned;
    }

}
