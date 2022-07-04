package com.example.creahanaproject.controller;

import com.example.creahanaproject.domain.model.Inscription;
//import com.example.creahanaproject.domain.repository.InscriptionRepository;
import com.example.creahanaproject.domain.service.InscriptionService;
import com.example.creahanaproject.resource.SaveInscriptionResource;
//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class InscriptionsController {
    @Autowired
    private InscriptionService inscriptionService;

    @Operation(summary = "Get All Inscriptions", description = "Get All Inscriptions by Pages", tags = {"Inscriptions"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Inscriptions returned", content = @Content(mediaType =
                    "application/json"))
    })
    @GetMapping("/inscriptions")
    public ResponseEntity<List<Inscription>> getAllInscriptions(){
        try {
            return new ResponseEntity<>(inscriptionService.getAllInscriptions(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Get All Inscriptions by User", description = "Get All Inscriptions by User and Pages", tags = {"Inscriptions"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All User Inscriptions returned", content = @Content(mediaType =
                    "application/json"))
    })
    @GetMapping("/inscriptions/user/{userId}")
    public ResponseEntity<List<Inscription>> getAllInscriptionsByUserId(@PathVariable(name = "userId") Long userId){
        try {
            return new ResponseEntity<>(inscriptionService.getAllInscriptionsByUserId(userId), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Get All Inscriptions by Course", description = "Get All Inscriptions by Course and Pages", tags = {"Inscriptions"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Course Inscriptions returned", content = @Content(mediaType =
                    "application/json"))
    })
    @GetMapping("/inscriptions/course/{courseName}")
    public ResponseEntity<List<Inscription>> getAllInscriptionsByCourseName(@PathVariable(name = "courseName") String courseName){
        try {
            return new ResponseEntity<>(inscriptionService.getAllInscriptionsByCourseName(courseName), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Post Inscription", description = "Create an Inscription", tags = {"Inscriptions"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Inscription registered", content = @Content(mediaType =
                    "application/json"))
    })
    @PostMapping("/inscriptions")
    public ResponseEntity<?> createInscription(@Valid @RequestBody SaveInscriptionResource resource){
        try {
            return new ResponseEntity<>(inscriptionService.createInscription(resource), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
