package com.example.PetBridge.presentation;

import com.example.PetBridge.model.Animal;
import com.example.PetBridge.businesslayer.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/animals")
@RequiredArgsConstructor
@CrossOrigin
public class AnimalController {
    private final AnimalService animalService;

    @PostMapping
    public Animal createAnimal(@RequestBody Animal animal) {
        return animalService.save(animal);
    }
}
