package com.unionistashop.crud_app_1.entities.security_tables;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    String username;

    @Column(nullable = false)
    String password;

    @Column(nullable = false)
    Boolean enabled;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    Set<Authority> authorities;


    public User(String username, String password, Boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
