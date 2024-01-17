package com.unionistashop.crud_app_1.entities.custom_security;


import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="roles")
@IdClass(RolePrimaryKey.class)
public class Role {

    @Id
    @Column(name = "user_id")
    String userId;

    @Id
    @Column(name = "role")
    String role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @MapsId("userId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    Member member;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
