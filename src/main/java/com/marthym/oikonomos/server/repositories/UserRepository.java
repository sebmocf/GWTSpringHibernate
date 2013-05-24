package com.marthym.oikonomos.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marthym.oikonomos.shared.model.User;

public interface UserRepository extends JpaRepository<User, String> {}
