package com.example.PetBridge.presentation;

import com.example.PetBridge.dto.UserDTO;
import com.example.PetBridge.model.Animal;
import com.example.PetBridge.model.User;
import com.example.PetBridge.businesslayer.AnimalService;
import com.example.PetBridge.businesslayer.UserService;
import com.example.PetBridge.persistance.UserRepo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin
@Tag(name = "Users", description = "Operations related to user profiles and matching")
public class UserController {
    private final UserService userService;
    private final AnimalService animalService;
    private final UserRepo userRepo;

    @Operation(summary = "Create new user", description = "Registers a new user with lifestyle, age, experience, etc.")
    @PostMapping("/users")
    public UserDTO createUser(@RequestBody @Valid UserDTO dto) {
        User savedUser = userService.createUser(dto);
        return UserDTO.fromEntity(savedUser);
    }

    @GetMapping
    public List<UserDTO> getAll() {
        return userService.findAll().stream().map(UserDTO::fromEntity).toList();
    }

    @GetMapping("/{id}")
    public UserDTO getById (@PathVariable Long id) {
        return userService.findById(id).map(UserDTO::fromEntity)
                .orElseThrow(()-> new RuntimeException("User not found"));
    }

    @PutMapping("/{id}")
    public UserDTO update(@PathVariable Long id, @RequestBody @Valid UserDTO dto) {
        return UserDTO.fromEntity(userService.update(id,dto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }


    // Get matched animals for a specific user ID
    @Operation(summary = "Find matching animals for user", description = "Finds all animals compatible with user preferences")
    @GetMapping("/{id}/match")
    public List <Animal> getMatches(@PathVariable Long id) {
        return userService.findById(id)
                .map(user -> animalService.findMatchingAnimalsForUser(user))
                .orElseThrow(() -> new RuntimeException("User not found"));

    }



}
