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
    private String breed;
    private int age;
    private String gender;
    private String temperament; // e.g., calm, playful, protective
    private int activity;
    private boolean goodWithKids;
    private boolean goodWithPets;

}
