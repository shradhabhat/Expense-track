package com.practice.restful_web_services.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practice.restful_web_services.dto.PostDto;
import com.practice.restful_web_services.entity.Post;
import com.practice.restful_web_services.entity.User;

@Service
public interface PostService {
	public List<Post> findAll();
	public Post findOne(String id);
	public Post save(PostDto postDto);
	public void deletePost(String id);
	public List<Post> findUserPosts(String id);
	Post updatePost(PostDto postDto, String postId);
}
