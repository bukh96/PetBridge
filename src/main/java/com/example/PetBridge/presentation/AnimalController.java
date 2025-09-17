package com.example.PetBridge.presentation;

import com.example.PetBridge.businesslayer.UserService;
import com.example.PetBridge.dto.AnimalDTO;
import com.example.PetBridge.model.Animal;
import com.example.PetBridge.businesslayer.AnimalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/animals")
@RequiredArgsConstructor
@CrossOrigin
@Tag(name = "Animals", description = "Animal management and registration")
public class AnimalController {
    private final AnimalService animalService;
    private final UserService userService;

    @Operation(summary = "Create new animal", description = "Adds a new animal to the system with compatibility attributes")
    @PostMapping
    public Animal createAnimal(@RequestBody Animal animalDTO) {
        return animalService.save(animalDTO);
    }


    @GetMapping
    public ResponseEntity<List<Animal>> getAllAnimals() {
        if (animalService.findAllAnimals().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(animalService.findAllAnimals());
        }
    }

    @GetMapping("/{id}/match")
    public List<AnimalDTO> getMatches(@PathVariable Long id) {
        return userService.findById(id)
                .map(user -> animalService.findMatchingAnimalsForUser(user))
                .map(animals -> animals.stream().map(AnimalDTO::fromEntity).toList())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

}
