package com.example.PetBridge.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "app_user") // Custom table name to avoid SQL conflict
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private int age;
    private String housing;
    private int lifestyle; // e.g., active, home, mixed (to do scale in UI "how much you active from 1 to 10 where 1-3 inactive, 4-7 mixed, 7-10 active)
    private String experience; // e.g., had (has) pets? beginner, intermediate, expert
    private boolean hasKids;
    private boolean hasOtherPets;
    private String preferredSpecies;
    private String preferredBreed;
    private Integer preferredAgeMin;
    private Integer preferredAgeMax;
    private String preferredGender;

}
