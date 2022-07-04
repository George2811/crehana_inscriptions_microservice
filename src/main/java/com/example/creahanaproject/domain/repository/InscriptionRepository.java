package com.example.creahanaproject.domain.repository;

import com.example.creahanaproject.domain.model.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
    List<Inscription> findByUserId(Long userId);
    List<Inscription> findByCourseName(String courseName);
    boolean existsInscriptionByUserIdAndCourseName(Long userId, String courseName);
}
