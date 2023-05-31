/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dangc
 */
public class Students {

    private Integer student_id;
    private String student_name;
    private String branch;
    private String year;

    @Override
    public String toString() {
        return "Students{" + "student_id=" + student_id + ", student_name=" + student_name + ", branch=" + branch + ", year=" + year + '}';
    }

    public Students(int student_id, String student_name, String branch, String year) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.branch = branch;
        this.year = year;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Students() {
    }

}
