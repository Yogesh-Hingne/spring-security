package com.neosoft.spring_security_dem_app.repo;

import com.neosoft.spring_security_dem_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String userName);

}
