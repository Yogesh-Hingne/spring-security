package com.neosoft.spring_security_dem_app.service;

import com.neosoft.spring_security_dem_app.entity.UserCredential;
import com.neosoft.spring_security_dem_app.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public UserCredential saveUser(UserCredential userCredential) {
        userCredential.setPassword(passwordEncoder.encode(userCredential.getPassword()));
        return userRepo.save(userCredential);
    }
}
