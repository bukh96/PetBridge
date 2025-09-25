package com.example.PetBridge.businesslayer;

import com.example.PetBridge.dto.UserDTO;
import com.example.PetBridge.model.User;
import com.example.PetBridge.persistance.UserRepo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepository;


    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(@Valid UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setAge(user.getAge());
        user.setHousing(userDTO.getHousing());
        user.setLifestyle(userDTO.getLifestyle());
        user.setEmail(userDTO.getEmail());
        user.setHasKids(userDTO.isHasKids());
        user.setPreferredBreed(userDTO.getPreferredBreed());
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User update(Long id, @Valid UserDTO dto) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setAge(dto.getAge());
        user.setHousing(dto.getHousing());
        user.setPreferredBreed(dto.getPreferredBreed());
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
