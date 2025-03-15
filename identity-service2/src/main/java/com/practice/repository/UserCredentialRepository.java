package com.practice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.practice.entity.UserCredential;

@Repository
public interface UserCredentialRepository extends MongoRepository<UserCredential, String> {
    Optional<UserCredential> findByUsername(String username);
}
