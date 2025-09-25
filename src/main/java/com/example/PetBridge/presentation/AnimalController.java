package com.example.PetBridge.presentation;

import com.example.PetBridge.businesslayer.UserService;
import com.example.PetBridge.dto.AnimalDTO;
import com.example.PetBridge.model.Animal;
import com.example.PetBridge.businesslayer.AnimalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
    public AnimalDTO create(@RequestBody  @Valid AnimalDTO animalDTO) {
        return AnimalDTO.fromEntity(animalService.create(animalDTO));
    }


    @GetMapping
    public List<AnimalDTO> getAll() {
        return animalService.findAll().stream().map(AnimalDTO::fromEntity).toList();
    }

    @GetMapping("/{id}")
    public AnimalDTO getById(@PathVariable Long id) {
        return animalService.findById(id).map(AnimalDTO::fromEntity)
                .orElseThrow(() -> new RuntimeException("Animal not found"));
    }

    @PutMapping("/{id}")
    public AnimalDTO update(@PathVariable Long id, @RequestBody @Valid AnimalDTO dto) {
        return AnimalDTO.fromEntity(animalService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        animalService.delete(id);
    }

    @GetMapping("/{id}/match")
    public List<AnimalDTO> getMatches(@PathVariable Long id) {
        return userService.findById(id)
                .map(user -> animalService.findMatchingAnimalsForUser(user))
                .map(animals -> animals.stream().map(AnimalDTO::fromEntity).toList())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

}
