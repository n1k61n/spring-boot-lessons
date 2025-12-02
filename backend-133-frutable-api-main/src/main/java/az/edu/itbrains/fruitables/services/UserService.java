package az.edu.itbrains.fruitables.services;

import az.edu.itbrains.fruitables.dtos.auth.RegisterDto;
import az.edu.itbrains.fruitables.dtos.auth.UserLoggedDto;
import az.edu.itbrains.fruitables.models.User;

public interface UserService {

    void register(RegisterDto registerDto);
    User findByLoggedUser(String email);
    User findUserById(Long userId);
    User findUserByEmail(String email);
    UserLoggedDto getLoggedUserInfo(String email);
}
