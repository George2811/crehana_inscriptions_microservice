package com.example.creahanaproject.service;

import com.example.creahanaproject.domain.model.Inscription;
import com.example.creahanaproject.domain.repository.InscriptionRepository;
import com.example.creahanaproject.domain.service.InscriptionService;
import com.example.creahanaproject.exception.ResourceNotFoundException;
import com.example.creahanaproject.resource.SaveInscriptionResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscriptionServiceImpl implements InscriptionService {
    @Autowired
    private InscriptionRepository inscriptionRepository;

    @Override
    public List<Inscription> getAllInscriptions() {
        return inscriptionRepository.findAll();
    }

    @Override
    public List<Inscription> getAllInscriptionsByUserId(Long userId) {
        return inscriptionRepository.findByUserId(userId);
    }

    @Override
    public List<Inscription> getAllInscriptionsByCourseName(String courseName) {
        return inscriptionRepository.findByCourseName(courseName);
    }

    @Override
    public Inscription createInscription(SaveInscriptionResource resource) {
        Inscription newInscription = new Inscription(
                resource.getUserId(),
                resource.getCourseName(),
                resource.getPurchaseDate()
        );
        if(inscriptionRepository.existsInscriptionByUserIdAndCourseName(newInscription.getUserId(), newInscription.getCourseName()))
            throw new ResourceNotFoundException("El usuario ya se encuentra registrado en el curso");
        return inscriptionRepository.save(newInscription);
    }
}
