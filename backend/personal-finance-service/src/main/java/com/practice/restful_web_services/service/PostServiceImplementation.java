package com.practice.restful_web_services.service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.restful_web_services.dto.PostDto;
import com.practice.restful_web_services.dto.UserDto;
import com.practice.restful_web_services.entity.Post;
import com.practice.restful_web_services.entity.User;
import com.practice.restful_web_services.exception.ApplicationException;
import com.practice.restful_web_services.repository.PostRepository;
import com.practice.restful_web_services.repository.UserRepository;
@Component
public class PostServiceImplementation implements PostService{
	@Autowired
	public PostRepository postRepository;
	@Autowired
	public UserRepository userRepository;
	
	public List<Post> findAll() {
		return postRepository.findAll();
	}
	
	public Post findOne(String id) {
		return postRepository.findById(id).orElseThrow(()->new ApplicationException("Post Not Found"));
	}
	
	public Post save(PostDto postdto) {

		User user= userRepository.findById(postdto.getUserId()).orElseThrow(()->new ApplicationException("User Not Found"));
		Post post=new Post();
		post.setCreatedDate(postdto.getCreatedDate());
		post.setUser(user);
		post.setContent(postdto.getContent());
		post.setMediaUrl(postdto.getMediaUrl());
		postRepository.save(post);
		return post;
	}

	public void deletePost(String id) {
		postRepository.findById(id).orElseThrow(()->new ApplicationException("User Not Found"));
		postRepository.deleteById(id);
		
	}

	public List<Post> findUserPosts(String id) {
		if(userRepository.findById(id) == null){
			 throw new ApplicationException("User Not Found");
			}
		return postRepository.findPostsByUserId(id);
		
	}
	@Override
	public Post updatePost(PostDto postDto, String postId) {
		Post existingPost=postRepository.findById(postId).orElseThrow(() -> new RuntimeException("User not found"));
		existingPost.setContent(postDto.getContent());
		existingPost.setMediaUrl(postDto.getMediaUrl());
		return postRepository.save(existingPost);
		
	}
	

}
