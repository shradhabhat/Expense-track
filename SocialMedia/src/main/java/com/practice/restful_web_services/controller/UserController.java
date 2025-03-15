package com.practice.restful_web_services.controller;

import java.time.LocalDate;
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

import com.practice.restful_web_services.dto.UserDto;
import com.practice.restful_web_services.entity.User;
import com.practice.restful_web_services.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService service;

	public UserController(UserService service) {
		this.service = service;
	}
	// GET /users
	@GetMapping
	
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}
	@GetMapping("/getcurrent")
	public User retrieveCurrentUser(@RequestHeader("loggedInUser") String id) {
		return service.findOne(id);
	}
	// GET /users
	@GetMapping("/getbyid/{id}")
	public User retrieveUserById(@PathVariable String id) {
		return service.findOne(id);
	}
	//POST /users
	@PostMapping
	public User createUser(@RequestBody User user,@RequestHeader("loggedInUser") String id) {
		user.setId(id);
		user.setJoinedDate(LocalDate.now());
		service.save(user);
		return user;
	}
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable String id) {
		service.deleteUser(id);
	}
    @PutMapping("/updateuser")
    public User updateUser( @RequestBody UserDto userDto,@RequestHeader("loggedInUser") String id) {
        
        return service.updateUser(userDto,id);
    }

}
