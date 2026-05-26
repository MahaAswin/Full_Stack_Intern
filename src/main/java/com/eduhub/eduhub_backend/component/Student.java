package com.eduhub.eduhub_backend.component;

import jdk.jfr.DataAmount;
import org.springframework.stereotype.Component;

@Component
public class Student {
    private int id;
    private String firstname;
    private String lastname;

    // Have an empty constructor to avoid the error "No default constructor"
    public Student(){

    }

    public Student(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
