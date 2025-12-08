package com.example.shaverma.conf;

import com.example.shaverma.data.repoImpls.collectionFrw.UserRepoImpl;
import com.example.shaverma.domain.repo.UserRepo;
import com.example.shaverma.presentation.service.UserController;
import com.example.shaverma.presentation.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShawarmaConfig {
    @Bean
    public UserRepo userRepo(){
        return new UserRepoImpl();
    }

    @Bean
    public UserService userService(){
        return new UserService();
    }

//    @Bean
//    public UserService userService(UserRepo userRepo){
//        return new UserService(userRepo);
//    }

    @Bean
    public UserController userController(){
        return new UserController(userService());
    }

    @Bean
    public CommandLineRunner commandLineRunner(){
        return new ApplicationStartupRunner(userController());
    }
}
