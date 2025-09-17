package com.example.PetBridge.dto;

public class UserDTO {
    private Long id;
    private String name;
    private int age;
    private int lifestyle; // e.g., active, home, mixed (to do scale in UI "how much you active from 1 to 10 where 1-3 inactive, 4-7 mixed, 7-10 active)
    private String experience; // e.g., had (has) pets? beginner, intermediate, expert
    private boolean hasKids;
    private boolean hasOtherPets;
    private String preferredSpecies;
    private String preferredBreed;
    private Integer preferredAgeMin;
    private Integer preferredAgeMax;
    private String preferredGender;

    public UserDTO(String name, int age, int lifestyle, String experience, boolean hasKids, boolean hasOtherPets) {
        this.name = name;
        this.age = age;
        this.lifestyle = lifestyle;
        this.experience = experience;
        this.hasKids = hasKids;
        this.hasOtherPets = hasOtherPets;
    }
}
