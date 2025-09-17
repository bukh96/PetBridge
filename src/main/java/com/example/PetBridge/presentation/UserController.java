package com.example.PetBridge.presentation;

import com.example.PetBridge.model.Animal;
import com.example.PetBridge.model.User;
import com.example.PetBridge.businesslayer.AnimalService;
import com.example.PetBridge.businesslayer.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

    @Operation(summary = "Create new user", description = "Registers a new user with lifestyle, age, experience, etc.")
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.save(user);
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
