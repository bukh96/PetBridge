// Service layer for User entity operations
package com.example.PetBridge.businesslayer;

import com.example.PetBridge.dto.AnimalDTO;
import com.example.PetBridge.model.Animal;
import com.example.PetBridge.model.User;
import com.example.PetBridge.persistance.AnimalRepo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnimalService {
    private final AnimalRepo animalRepository;
    private final User user;


    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    public Animal create(AnimalDTO dto) {
        Animal animal = new Animal();
        animal.setName(dto.getName());
        animal.setAge(dto.getAge());
        animal.setGender(dto.getGender());
        animal.setBreed(dto.getBreed());
        animal.setActivity(dto.getActivity());
        animal.setGoodWithKids(dto.isGoodWithKids());
        animal.setSpecies(dto.getSpecies());
        animal.setGoodWithPets(dto.isGoodWithPets());
        animal.setPhotoUrl(dto.getPhotoUrl());
        animal.setTemperament(dto.getTemperament());
        animal.setSterilization(dto.isSterilization());
        animal.setHousing(dto.getHousing());
        return animalRepository.save(animal);

    }

    public List<Animal> findMatchingAnimalsForUser(User user) {return animalRepository.findByUserId(this.user.getId());}


    public List<Animal> matchAnimalsForActiveUser(User user, List<Animal> animalDTOS) {
        return animalDTOS.stream()
                .filter(a -> user.getPreferredSpecies() == null || a.getSpecies().equalsIgnoreCase(user.getPreferredSpecies()))
                .filter(a -> user.getPreferredBreed() == null || a.getBreed().equalsIgnoreCase(user.getPreferredBreed()))
                .filter(a -> a.getAge() >= user.getPreferredAgeMin() && a.getAge() <= user.getPreferredAgeMax())
                .filter(a -> user.getPreferredGender() == null || a.getGender().equalsIgnoreCase(user.getPreferredGender()))
                .filter(animal -> user.isHasKids() && animal.isGoodWithKids())
                .filter(animal -> user.isHasOtherPets() && animal.isGoodWithPets())
                .filter(animal -> (user.getLifestyle() >= 7 && user.getLifestyle() <= 10) && (animal.getActivity() >= 7 && animal.getActivity() <= 10))
                .collect(Collectors.toList());

    }


    public List<Animal> matchAnimalsForMiddleActiveUser(User user, List<Animal> animalDTOS) {
        return animalDTOS.stream()
                .filter(a -> user.getPreferredSpecies() == null || a.getSpecies().equalsIgnoreCase(user.getPreferredSpecies()))
                .filter(a -> user.getPreferredBreed() == null || a.getBreed().equalsIgnoreCase(user.getPreferredBreed()))
                .filter(a -> a.getAge() >= user.getPreferredAgeMin() && a.getAge() <= user.getPreferredAgeMax())
                .filter(a -> user.getPreferredGender() == null || a.getGender().equalsIgnoreCase(user.getPreferredGender()))
                .filter(animal -> user.isHasKids() && animal.isGoodWithKids())
                .filter(animal -> user.isHasOtherPets() && animal.isGoodWithPets())
                .filter(animal -> (user.getLifestyle() >= 4 && user.getLifestyle() <= 7) && (animal.getActivity() >= 4 && animal.getActivity() <= 7))
                .collect(Collectors.toList());

    }

    public List<Animal> matchAnimalsForInactiveUser(User user, List<Animal> animalDTOS) {
        return animalDTOS.stream()
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


    public  Optional<Animal> findById(Long id) {
        return animalRepository.findById(id);
    }

    public Animal update(Long id, @Valid AnimalDTO dto) {
        Animal animal = animalRepository.findById(id).orElseThrow(() -> new RuntimeException("Animal not found"));
        animal.setName(dto.getName());
        animal.setAge(dto.getAge());
        animal.setGender(dto.getGender());
        animal.setBreed(dto.getBreed());
        animal.setActivity(dto.getActivity());
        animal.setGoodWithKids(dto.isGoodWithKids());
        animal.setSpecies(dto.getSpecies());
        animal.setGoodWithPets(dto.isGoodWithPets());
        animal.setPhotoUrl(dto.getPhotoUrl());
        animal.setTemperament(dto.getTemperament());
        animal.setSterilization(dto.isSterilization());
        animal.setHousing(dto.getHousing());
        return animalRepository.save(animal);
    }

    public void delete(Long id) {
        animalRepository.deleteById(id);
    }
}
