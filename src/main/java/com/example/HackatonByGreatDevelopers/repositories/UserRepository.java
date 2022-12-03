package com.example.HackatonByGreatDevelopers.repositories;
import com.example.HackatonByGreatDevelopers.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//exists - проверяет, существует ли сущность с данным первичным ключом

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

}
