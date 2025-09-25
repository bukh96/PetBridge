package com.example.PetBridge.dto;

import com.example.PetBridge.model.User;

public class UserDTO {
    private Long id;
    private String name;
    private int age;
    private int lifestyle; // e.g., active, home, mixed (to do scale in UI "how much you active from 1 to 10 where 1-3 inactive, 4-7 mixed, 7-10 active)
    private String experience; // e.g., had (has) pets? beginner, intermediate, expert
    private boolean hasKids;
    private String housing;
    private boolean hasOtherPets;
    private String preferredSpecies;
    private String preferredBreed;
    private Integer preferredAgeMin;
    private Integer preferredAgeMax;
    private String preferredGender;
    private String email;

    public UserDTO() {
    }


    public UserDTO(Long id, String name, int age, int lifestyle, String experience, boolean hasKids, String housing, boolean hasOtherPets, String preferredGender, Integer preferredAgeMin, Integer preferredAgeMax, String preferredSpecies, String email, String preferredBreed) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.lifestyle = lifestyle;
        this.experience = experience;
        this.hasKids = hasKids;
        this.housing = housing;
        this.hasOtherPets = hasOtherPets;
        this.preferredGender = preferredGender;
        this.preferredAgeMin = preferredAgeMin;
        this.preferredAgeMax = preferredAgeMax;
        this.preferredSpecies = preferredSpecies;
        this.email = email;
        this.preferredBreed = preferredBreed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPreferredGender() {
        return preferredGender;
    }

    public void setPreferredGender(String preferredGender) {
        this.preferredGender = preferredGender;
    }

    public Integer getPreferredAgeMax() {
        return preferredAgeMax;
    }

    public void setPreferredAgeMax(Integer preferredAgeMax) {
        this.preferredAgeMax = preferredAgeMax;
    }

    public Integer getPreferredAgeMin() {
        return preferredAgeMin;
    }

    public void setPreferredAgeMin(Integer preferredAgeMin) {
        this.preferredAgeMin = preferredAgeMin;
    }


    public String getPreferredSpecies() {
        return preferredSpecies;
    }

    public void setPreferredSpecies(String preferredSpecies) {
        this.preferredSpecies = preferredSpecies;
    }

    public boolean isHasOtherPets() {
        return hasOtherPets;
    }

    public void setHasOtherPets(boolean hasOtherPets) {
        this.hasOtherPets = hasOtherPets;
    }

    public String getHousing() {
        return housing;
    }

    public void setHousing(String housing) {
        this.housing = housing;
    }

    public boolean isHasKids() {
        return hasKids;
    }

    public void setHasKids(boolean hasKids) {
        this.hasKids = hasKids;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public int getLifestyle() {
        return lifestyle;
    }

    public void setLifestyle(int lifestyle) {
        this.lifestyle = lifestyle;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreferredBreed() {
        return preferredBreed;
    }

    public void setPreferredBreed(String preferredBreed) {
        this.preferredBreed = preferredBreed;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static UserDTO fromEntity(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getAge(),
                user.getLifestyle(),
                user.getExperience(),
                user.isHasKids(),
                user.getHousing(),
                user.isHasOtherPets(),
                user.getPreferredGender(),
                user.getPreferredAgeMin(),
                user.getPreferredAgeMax(),
                user.getPreferredSpecies(),
                user.getEmail(),
                user.getPreferredBreed()
        );
    }



}
