package com.unionistashop.crud_app_1.entities.security_tables;


import com.unionistashop.crud_app_1.DAOs.AuthorityPrimaryKey;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Table(name = "authorities")
@IdClass(AuthorityPrimaryKey.class)
public class Authority {


    @Id
    String username;

    @Id
    String authority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    @MapsId("username")
    @OnDelete(action = OnDeleteAction.CASCADE)
    User user;



    public Authority() {

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
