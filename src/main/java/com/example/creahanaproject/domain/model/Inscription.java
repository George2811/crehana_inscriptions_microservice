package com.example.creahanaproject.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table(name = "inscriptions")
public class Inscription implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false, length = 150)
    private String courseName;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar purchaseDate;

    public Inscription() {
    }
    public Inscription(Long id, Long userId, String courseName, Calendar purchaseDate) {
        this.id = id;
        this.userId = userId;
        this.courseName = courseName;
        this.purchaseDate = purchaseDate;
    }
    public Inscription(Long userId, String courseName, Calendar purchaseDate) {
        this.userId = userId;
        this.courseName = courseName;
        this.purchaseDate = purchaseDate;
    }

    public Long getId() {
        return id;
    }
    public Inscription setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }
    public Inscription setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getCourseName() {
        return courseName;
    }
    public Inscription setCourseName(String courseName) {
        this.courseName = courseName;
        return this;
    }

    public Calendar getPurchaseDate() {
        return purchaseDate;
    }
    public Inscription setPurchaseDate(Calendar purchaseDate) {
        this.purchaseDate = purchaseDate;
        return this;
    }
}
