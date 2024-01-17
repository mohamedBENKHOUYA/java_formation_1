package com.unionistashop.crud_app_1.crud_app_2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee2")
public class Employee2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String LastName;

    @Column(name = "email")
    private String email;

    public Employee2(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        LastName = lastName;
        this.email = email;
    }

    public Employee2() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
