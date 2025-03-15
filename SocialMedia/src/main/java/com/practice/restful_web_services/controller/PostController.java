package com.practice.restful_web_services.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.restful_web_services.dto.PostDto;
import com.practice.restful_web_services.dto.UserDto;
import com.practice.restful_web_services.entity.Post;
import com.practice.restful_web_services.entity.User;
import com.practice.restful_web_services.service.PostService;


@RestController
@RequestMapping("/posts")
public class PostController {
	@Autowired
	private PostService service;
	
	public PostController(PostService service) {
		this.service = service;
	}
	//POST /
	@PostMapping("/addpost")
	public Post createPost(@RequestBody PostDto postDto, @RequestHeader("loggedInUser") String id) {
		postDto.setUserId(id);
		postDto.setCreatedDate(LocalDateTime.now());
		return service.save(postDto);
	}
	// GET /posts
	@GetMapping("/getallposts")
	public List<Post> retrieveAllPosts() {
		return service.findAll();
	}
	@GetMapping("/getcurrentuserposts")
	public List<Post> retrieveCurrentUserPost(@RequestHeader("loggedInUser") String userId) {
		return service.findUserPosts(userId);
	}
	// GET /post
	@GetMapping("/getByPostId/{id}")
	public Post retrievePost(@PathVariable String id) {
		return service.findOne(id);
	}
	
	@GetMapping("/getByUserId/{userId}")
	public List<Post> retrieveUserPost(@PathVariable String userId) {
		return service.findUserPosts(userId);
	}
	
	@DeleteMapping("/{postId}")
	public void deletePost(@PathVariable String postId) {
		service.deletePost(postId);
	}
    @PutMapping("/updatepost/{postId}")
    public Post updateUser( @RequestBody PostDto postDto,@PathVariable String postId) {
        
        return service.updatePost(postDto,postId);
    }
	
}
