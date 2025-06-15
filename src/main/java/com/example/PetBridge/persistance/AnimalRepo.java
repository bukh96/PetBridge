package com.example.PetBridge.persistance;

import com.example.PetBridge.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepo extends JpaRepository <Animal, Long> {
}
