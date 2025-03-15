package com.practice.restful_web_services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.practice.restful_web_services.entity.User;
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    
}
