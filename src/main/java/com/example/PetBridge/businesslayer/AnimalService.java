// Service layer for User entity operations
package com.example.PetBridge.businesslayer;

import com.example.PetBridge.model.Animal;
import com.example.PetBridge.model.User;
import com.example.PetBridge.persistance.AnimalRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnimalService {
    private final AnimalRepo animalRepository;

    public Animal save(Animal animal) {
        return animalRepository.save(animal);
    }

    public List<Animal> findAllAnimals() {
        return animalRepository.findAll();
    }

//TODO matching for Temperament!
    public List<Animal> matchAnimalsForActiveUser(User user, List<Animal> animals) {
        return animals.stream()
                .filter(a -> user.getPreferredSpecies() == null || a.getSpecies().equalsIgnoreCase(user.getPreferredSpecies()))
                .filter(a -> user.getPreferredBreed() == null || a.getBreed().equalsIgnoreCase(user.getPreferredBreed()))
                .filter(a -> a.getAge() >= user.getPreferredAgeMin() && a.getAge() <= user.getPreferredAgeMax())
                .filter(a -> user.getPreferredGender() == null || a.getGender().equalsIgnoreCase(user.getPreferredGender()))
                .filter(animal -> user.isHasKids() && animal.isGoodWithKids())
                .filter(animal -> user.isHasOtherPets() && animal.isGoodWithPets())
                .filter(animal -> (user.getLifestyle() >= 7 && user.getLifestyle() <= 10) && (animal.getActivity() >= 7 && animal.getActivity() <= 10))
                .collect(Collectors.toList());

    }


    public List<Animal> matchAnimalsForMiddleActiveUser(User user, List<Animal> animals) {
        return animals.stream()
                .filter(a -> user.getPreferredSpecies() == null || a.getSpecies().equalsIgnoreCase(user.getPreferredSpecies()))
                .filter(a -> user.getPreferredBreed() == null || a.getBreed().equalsIgnoreCase(user.getPreferredBreed()))
                .filter(a -> a.getAge() >= user.getPreferredAgeMin() && a.getAge() <= user.getPreferredAgeMax())
                .filter(a -> user.getPreferredGender() == null || a.getGender().equalsIgnoreCase(user.getPreferredGender()))
                .filter(animal -> user.isHasKids() && animal.isGoodWithKids())
                .filter(animal -> user.isHasOtherPets() && animal.isGoodWithPets())
                .filter(animal -> (user.getLifestyle() >= 4 && user.getLifestyle() <= 7) && (animal.getActivity() >= 4 && animal.getActivity() <= 7))
                .collect(Collectors.toList());

    }

    public List<Animal> matchAnimalsForInactiveUser(User user, List<Animal> animals) {
        return animals.stream()
                .filter(a -> user.getPreferredSpecies() == null || a.getSpecies().equalsIgnoreCase(user.getPreferredSpecies()))
                .filter(a -> user.getPreferredBreed() == null || a.getBreed().equalsIgnoreCase(user.getPreferredBreed()))
                .filter(a -> a.getAge() >= user.getPreferredAgeMin() && a.getAge() <= user.getPreferredAgeMax())
                .filter(a -> user.getPreferredGender() == null || a.getGender().equalsIgnoreCase(user.getPreferredGender()))
                .filter(animal -> user.isHasKids() && animal.isGoodWithKids())
                .filter(animal -> user.isHasOtherPets() && animal.isGoodWithPets())
                .filter(animal -> (user.getLifestyle() >= 1 && user.getLifestyle() <= 3) && (animal.getActivity() >= 1 && animal.getActivity() <= 3))
                .collect(Collectors.toList());

    }
//TODO matching for Temperament!

    // Helper method to determine if temperament matches user's lifestyle
    private boolean matchTemperament(String lifestyle, String temperament) {
        return switch (lifestyle) {
            case "active" -> temperament.equals("playful") || temperament.equals("protective");
            case "home" -> temperament.equals("calm");
            default -> true;
        };
    }
}
