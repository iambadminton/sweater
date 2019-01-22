package com.example.sweater.repository;

import com.example.sweater.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Sanya on 22.01.2019.
 */
public interface UserRepo extends JpaRepository<User, Long > {
    public User findByUsername(String username);
}
