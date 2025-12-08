package com.example.shaverma.domain.interractor;

import com.example.shaverma.domain.model.User;
import com.example.shaverma.domain.repo.UserRepo;
import org.springframework.stereotype.Service;


public class UserInterractor {
    // In a real application, you would inject a UserRepo here
    private final UserRepo userRepo;


    public UserInterractor(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User saveUser(User user){
         return userRepo.saveUser(user);
     }

     public void deleteUser(User user){
        userRepo.saveUser(user);
     }

     public User getUserByEmail(String email){
        return userRepo.getUserByEmail(email);
     }

     public User getUserById(Long id){
        return userRepo.getUserById(id);
     }

     public User updateUser(User user){
        return userRepo.updateUser(user);
     }


    public String greetUser(String name) {
        return "Hello, " + name + "!";
    }



}


