package com.example.Rimshop.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    private Long id;

    private String login;

    private String password;

    private Role role;

    @ManyToOne
    @JoinColumn(name = "role_ID")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @Column(name = "password")
    @Type(type = "org.hibernate.type.TextType")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "login", unique = true)
    @Type(type = "org.hibernate.type.TextType")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}