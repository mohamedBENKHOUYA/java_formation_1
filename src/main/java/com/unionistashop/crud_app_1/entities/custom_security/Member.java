package com.unionistashop.crud_app_1.entities.custom_security;

import jakarta.persistence.*;
import org.hibernate.id.factory.internal.AutoGenerationTypeStrategy;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @Column(name = "user_id")
    String userId;

    @Column
    String pw;

    @Column
    Boolean active;

    public Member(String userId, String pw, Boolean active) {
        this.userId = userId;
        this.pw = pw;
        this.active = active;
    }

    public Member(String pw, Boolean active) {
        this.pw = pw;
        this.active = active;
    }

    public Member() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
