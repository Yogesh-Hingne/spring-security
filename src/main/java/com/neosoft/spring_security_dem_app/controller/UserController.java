package com.neosoft.spring_security_dem_app.controller;

import com.neosoft.spring_security_dem_app.entity.User;
import com.neosoft.spring_security_dem_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User result = userService.saveUser(user);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<User> getUserByID(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

}
