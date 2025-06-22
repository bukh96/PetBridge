package com.example.PetBridge.presentation;

import com.example.PetBridge.model.Animal;
import com.example.PetBridge.model.User;
import com.example.PetBridge.businesslayer.AnimalService;
import com.example.PetBridge.businesslayer.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {
    private final UserService userService;
    private final AnimalService animalService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    // Get matched animals for a specific user ID
    @GetMapping("/{id}/match")
    public List <Animal> getMatches(@PathVariable Long id) {
        return userService.findById(id)
                .map(animalService::matchAnimals)
                .orElseThrow(() -> new RuntimeException("User not found"));
        
    }



}
