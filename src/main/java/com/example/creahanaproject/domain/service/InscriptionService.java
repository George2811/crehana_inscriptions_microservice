package com.example.creahanaproject.domain.service;

import com.example.creahanaproject.domain.model.Inscription;
import com.example.creahanaproject.resource.SaveInscriptionResource;

import java.util.List;

public interface InscriptionService {
    List<Inscription> getAllInscriptions();
    List<Inscription> getAllInscriptionsByUserId(Long userId);
    List<Inscription> getAllInscriptionsByCourseName(String courseName);
    Inscription createInscription(SaveInscriptionResource inscription);

}
