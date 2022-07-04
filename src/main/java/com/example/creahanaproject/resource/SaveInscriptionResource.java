package com.example.creahanaproject.resource;

import javax.validation.constraints.NotNull;
import java.util.Calendar;

public class SaveInscriptionResource {
    private Long userId;
    private String courseName;
    private Calendar purchaseDate;

    public Long getUserId() {
        return userId;
    }
    public SaveInscriptionResource setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getCourseName() {
        return courseName;
    }
    public SaveInscriptionResource setCourseName(String courseName) {
        this.courseName = courseName;
        return this;
    }

    public Calendar getPurchaseDate() {
        return purchaseDate;
    }
    public SaveInscriptionResource setPurchaseDate(Calendar purchaseDate) {
        this.purchaseDate = purchaseDate;
        return this;
    }
}
