package com.example.PetBridge.persistance;

import com.example.PetBridge.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    List<User> findAll();


}
