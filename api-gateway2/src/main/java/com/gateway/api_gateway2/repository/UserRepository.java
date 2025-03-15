package com.gateway.api_gateway2.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gateway.api_gateway2.entity.UserCredential;

@Repository
public interface UserRepository extends MongoRepository<UserCredential,String>{

	Optional<UserCredential> findByUsername(String username);
}