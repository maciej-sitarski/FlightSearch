package com.sitarski.maciej.flightsearch.dao;

import com.sitarski.maciej.flightsearch.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);

}