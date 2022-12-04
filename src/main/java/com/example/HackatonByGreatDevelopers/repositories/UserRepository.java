package com.example.HackatonByGreatDevelopers.repositories;
import com.example.HackatonByGreatDevelopers.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//exists - проверяет, существует ли сущность с данным первичным ключом

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    User findAllById(Long id);




}
