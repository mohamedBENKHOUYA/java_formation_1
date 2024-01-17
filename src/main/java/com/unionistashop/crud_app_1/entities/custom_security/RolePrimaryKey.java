package com.unionistashop.crud_app_1.entities.custom_security;

import java.io.Serializable;

public class RolePrimaryKey implements Serializable {

    String userId;


    String role;

    public RolePrimaryKey(String userId, String role) {
        this.userId = userId;
        this.role = role;
    }

    public RolePrimaryKey() {
    }


}
