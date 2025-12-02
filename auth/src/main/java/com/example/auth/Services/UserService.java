package com.example.auth.Services;


import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import com.example.auth.Rositories.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    private  UserRepository userRepository;

 @Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    var userObj = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException(username));
    // return a Spring Security UserDetails
    return new User(userObj.getUsername(), userObj.getPassword(), new ArrayList<>());
}
}
