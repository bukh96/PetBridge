package com.example.PetBridge.dto;


import com.example.PetBridge.model.Animal;

public class AnimalDTO {

    private Long id;
    private String name;
    private String species;
    private int age;
    private String photoUrl;
    private String gender;
    private String breed;
    private String temperament; // e.g., calm, playful, protective
    private int activity;
    private boolean sterilization;
    private boolean goodWithKids;
    private boolean goodWithPets;
    private String housing;
    

    public AnimalDTO() {
    }


    public AnimalDTO(Long id, String name, String species, int age, String breed, String temperament, String photoUrl, int activity, String gender, boolean sterilization, boolean goodWithKids, boolean goodWithPets, String housing) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.age = age;
        this.gender = gender;
        this.photoUrl = photoUrl;
        this.activity = activity;
        this.sterilization = sterilization;
        this.goodWithKids = goodWithKids;
        this.goodWithPets = goodWithPets;
        this.housing = housing;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getGender() {
        return gender;
    }

    public void setGender() {
        this.gender = gender;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed() {
        this.breed = breed;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament() {
        this.temperament = temperament;
    }

    public boolean isGoodWithKids() {
        return goodWithKids;
    }

    public void setGoodWithKids(boolean goodWithKids) {
        this.goodWithKids = goodWithKids;
    }

    public boolean isGoodWithPets() {
        return goodWithPets;
    }

    public void setGoodWithPets(boolean goodWithPets) {
        this.goodWithPets = goodWithPets;
    }

    public int getActivity() {
        return activity;
    }

    public void setActivity(int activity) {
        this.activity = activity;
    }

    public boolean isSterilization() {
        return sterilization;
    }

    public void setSterilization(boolean sterilization) {
        this.sterilization = sterilization;
    }
    public String getHousing() {
        return housing;
    }

    public void setHousing(String housing) {
        this.housing = housing;
    }

    public static AnimalDTO fromEntity(Animal animal) {
        return new AnimalDTO(
                animal.getId(),
                animal.getName(),
                animal.getSpecies(),
                animal.getAge(),
                animal.getBreed(),
                animal.getTemperament(),
                animal.getPhotoUrl(),
                animal.getActivity(),
                animal.getGender(),
                animal.isGoodWithKids(),
                animal.isGoodWithPets(),
                animal.isSterilization(),
                animal.getHousing()
        );
    }

}
