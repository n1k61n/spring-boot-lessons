package com.example.shaverma.conf;

import com.example.shaverma.domain.model.User;
import com.example.shaverma.presentation.service.UserController;
import org.springframework.boot.CommandLineRunner;

public class ApplicationStartupRunner implements CommandLineRunner {


    private final UserController userController;

    public ApplicationStartupRunner(UserController userController) {
        this.userController = userController;
    }

    @Override
    public void run(String... args) throws Exception {
        userController.createUser(new User());
        userController.deleteUser(new User());
    }
}
