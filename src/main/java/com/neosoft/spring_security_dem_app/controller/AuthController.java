package com.neosoft.spring_security_dem_app.controller;

import com.neosoft.spring_security_dem_app.entity.UserCredential;
import com.neosoft.spring_security_dem_app.service.CustomUserDetailsService;
import com.neosoft.spring_security_dem_app.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody UserCredential userCredential) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userCredential.getUsername(),userCredential.getPassword()));
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(userCredential.getUsername());

      String token=  jwtUtil.generateToken(userDetails);
      Map<String, String> map = new HashMap<>();
      map.put("token", token);
      return ResponseEntity.ok(map);
    }
}
