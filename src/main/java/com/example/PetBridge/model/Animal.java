package com.example.PetBridge.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Animal {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String species; // e.g., dog, cat
    private String temperament; // e.g., calm, playful, protective
    private boolean goodWithKids;
    private boolean goodWithPets;
}
