package com.neosoft.spring_security_dem_app.controller;

import com.neosoft.spring_security_dem_app.entity.UserCredential;
import com.neosoft.spring_security_dem_app.service.CustomUserDetailsService;
import com.neosoft.spring_security_dem_app.service.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    private CustomUserDetailsService userService;
    @Autowired
    private RegisterUserService registerUserService;

    public void setUserService(CustomUserDetailsService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity<UserCredential> saveUserCredential(@RequestBody UserCredential userCredential) {
        registerUserService.saveUserCredential(userCredential);
        return ResponseEntity.ok(userCredential);
    }
}
