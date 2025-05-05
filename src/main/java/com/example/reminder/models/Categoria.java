package com.example.reminder.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "categoria", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "category_name"}))
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario user;

    @Column(name = "category_name", length = 50, nullable = false)
    private String categoryName;

    @Column(name = "category_desc", length = 150)
    private String categoryDesc;

    @Column(name = "category_created", insertable = false, updatable = false)
    private LocalDateTime categoryCreated;

    @Lob
    @Column(name = "category_img")
    private byte[] categoryImg;


    public LocalDateTime getCategoryCreated() {
        return categoryCreated;
    }

    public void setCategoryCreated(LocalDateTime categoryCreated) {
        this.categoryCreated = categoryCreated;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public byte[] getCategoryImg() {
        return categoryImg;
    }

    public void setCategoryImg(byte[] categoryImg) {
        this.categoryImg = categoryImg;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}
