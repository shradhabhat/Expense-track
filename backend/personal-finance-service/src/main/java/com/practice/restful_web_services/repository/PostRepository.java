package com.practice.restful_web_services.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.practice.restful_web_services.entity.Post;

import java.util.List;
@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	@Query("{'user.id':?0}")
    List<Post> findPostsByUserId(String id);
}
