// Service layer for User entity operations
package com.example.PetBridge.businesslayer;

import com.example.PetBridge.model.Animal;
import com.example.PetBridge.model.User;
import com.example.PetBridge.persistance.AnimalRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnimalService {
    private final AnimalRepo animalRepository;

    public Animal save(Animal animal) {
        return animalRepository.save(animal);
    }

    // Match animals to user's preferences
    public List<Animal> matchAnimals(User user) {
        return animalRepository.findAll().stream()
                .filter(a -> a.isGoodWithKids() == user.isHasKids())
                .filter(a -> a.isGoodWithPets() == user.isHasOtherPets())
                .filter(a -> matchTemperament(user.getLifestyle(), a.getTemperament()))
                .collect(Collectors.toList());
    }

    // Helper method to determine if temperament matches user's lifestyle
    private boolean matchTemperament(String lifestyle, String temperament) {
        return switch (lifestyle) {
            case "active" -> temperament.equals("playful") || temperament.equals("protective");
            case "home" -> temperament.equals("calm");
            default -> true;
        };
    }
}
