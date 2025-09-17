package com.example.PetBridge.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor

public class Animal {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "date")
    private String species; // e.g., dog, cat
    private String breed;
    private int age;
    private String gender;
    private String temperament; // e.g., calm, playful, protective
    private int activity;
    private boolean goodWithKids;
    private boolean goodWithPets;
    private String photoUrl;

}
