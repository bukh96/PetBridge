package com.example.PetBridge.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "app_user") // ✅ Custom table name to avoid SQL conflict
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String lifestyle; // e.g., active, home, mixed
    private String experience; // e.g., beginner, intermediate, expert
    private boolean hasKids;
    private boolean hasOtherPets;
}
