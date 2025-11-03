package com.neosoft.spring_security_dem_app.service;

import com.neosoft.spring_security_dem_app.entity.User;
import com.neosoft.spring_security_dem_app.entity.UserCredential;

public interface UserService {
    User saveUser(User user);

    User getUserById(Long id);
}
