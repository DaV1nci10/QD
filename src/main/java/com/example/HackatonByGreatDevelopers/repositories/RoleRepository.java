package com.example.HackatonByGreatDevelopers.repositories;

import com.example.HackatonByGreatDevelopers.entity.Role;
import com.example.HackatonByGreatDevelopers.entity.enums.EnumRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long > {

    Optional<Role> findByName(EnumRole name);
}
