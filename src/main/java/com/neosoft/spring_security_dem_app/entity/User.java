package com.neosoft.spring_security_dem_app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER_TABLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private int mobileNumber;
    private String username;
    private String password;
    private String email;
    private String city;
    private String gender;
}
