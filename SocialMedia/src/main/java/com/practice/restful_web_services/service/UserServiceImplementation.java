package com.practice.restful_web_services.service;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.practice.restful_web_services.dto.UserDto;
import com.practice.restful_web_services.entity.User;
import com.practice.restful_web_services.exception.ApplicationException;
import com.practice.restful_web_services.repository.UserRepository;

//@Component
@Service
public class UserServiceImplementation implements UserService{
	@Autowired
	public UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findOne(String id) {
		return userRepository.findById(id).orElseThrow(()->new ApplicationException("User Not Found"));
	}
	public User save(User user) {
		userRepository.save(user);
		return user;
	}
	public void deleteUser(String id) {

		userRepository.findById(id).orElseThrow(()->new ApplicationException("User Not Found"));
		userRepository.deleteById(id);
	}

	@Override
	public User updateUser(UserDto userDto, String userId) {
		User existingUser=userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
		existingUser.setBirthDate(userDto.getBirthDate());
	    existingUser.setEmail(userDto.getEmail());
	    existingUser.setName(userDto.getName());
	    existingUser.setPassword(userDto.getPassword());
		return userRepository.save(existingUser);
		
	}
	

}
