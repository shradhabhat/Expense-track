package com.practice.restful_web_services.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.practice.restful_web_services.entity.Category;
import com.practice.restful_web_services.entity.CategoryEntity;

public interface CategoryRepository extends MongoRepository<CategoryEntity, String> {

}

