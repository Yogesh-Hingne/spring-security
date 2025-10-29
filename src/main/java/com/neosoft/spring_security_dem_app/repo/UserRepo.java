package com.neosoft.spring_security_dem_app.repo;

import com.neosoft.spring_security_dem_app.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserCredential, Long> {
    Optional<UserCredential> findByUsername(String userName);

}
