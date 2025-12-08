package com.example.shaverma.domain.repo;

import com.example.shaverma.domain.model.User;

public interface UserRepo {
    User saveUser(User user);
    void deleteUser(User user);
    User getUserByEmail(String email);
    User getUserById(Long id);
    User updateUser(User user);

}

