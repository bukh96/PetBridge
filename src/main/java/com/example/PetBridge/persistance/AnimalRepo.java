package com.example.PetBridge.persistance;

import com.example.PetBridge.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepo extends JpaRepository<Animal, Long> {

    List<Animal> findAll();
}
