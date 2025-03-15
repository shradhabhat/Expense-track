package com.practice.restful_web_services.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practice.restful_web_services.dto.UserDto;
import com.practice.restful_web_services.entity.User;

@Service
public interface UserService {
	List<User> findAll() ;
	User findOne(String id);
	User save(User user);
	void deleteUser(String id);
	User updateUser(UserDto userDto,String userId);
}
