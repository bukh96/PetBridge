package com.example.PetBridge.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class AdoptionRequest {
    //TODO for production, difficulty architecture...
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;


    @ManyToOne
    private Animal animal;

    private String status;

    private LocalDateTime matchedAt;


}
