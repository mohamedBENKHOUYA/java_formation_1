package com.unionistashop.crud_app_1.DAOs;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;


public class AuthorityPrimaryKey implements Serializable {

    String username;

    String authority;

    public AuthorityPrimaryKey(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    public AuthorityPrimaryKey() {
    }

}
