package com.example.PetBridge.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Match {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Animal animal;

    private LocalDateTime matchedAt;
}
