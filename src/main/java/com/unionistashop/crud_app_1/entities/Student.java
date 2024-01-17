package com.unionistashop.crud_app_1.entities;

import com.unionistashop.crud_app_1.annotations.CourseCode;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.lang.annotation.ElementType;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message="firstName must not be empty")
    @Column(name="first_name")
    private String firstName;

    @NotNull(message = "is required")
    @NotEmpty(message = "must not be empty")
    @Column(name="last_name")
    private String lastName;

    @Min(value=0, message = "must be greater than or equal to zero")
    @Max(value=10, message="must be greater than or equal to 10")
    @NotNull(message = "is required")
    @Column(name="free_passes")
    private Integer freePasses;



    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message="only 5 chars/digits")
    @NotNull()
    @Column()
    private String postalCode;


    @CourseCode(value = "UN", message = "must start with UN")
    private String courseCode;

    @Column(name="email")
    private String email;

    @Column(name="country")
    private String country;

    @Column(name="lng")
    private String lng;



    public Student() {

    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
