package com.demo.projectmanagmentsystem.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.projectmanagmentsystem.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

	Optional<User> findById(Long id);
}

