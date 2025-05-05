package com.example.reminder.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name", length = 50, nullable = false)
    private String userName;

    @Column(name = "user_last_name", length = 150, nullable = false)
    private String userLastName;

    @Column(name = "user_pass", length = 30, nullable = false)
    private String userPass;

    @Column(name = "user_email", length = 100, unique = true, nullable = false)
    private String userEmail;

    @Column(name = "user_handle", length = 50, unique = true, nullable = false)
    private String userHandle;

    @Column(name = "user_born")
    private LocalDate userBorn;

    public LocalDate getUserBorn() {
        return userBorn;
    }

    public void setUserBorn(LocalDate userBorn) {
        this.userBorn = userBorn;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserHandle() {
        return userHandle;
    }

    public void setUserHandle(String userHandle) {
        this.userHandle = userHandle;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
}
