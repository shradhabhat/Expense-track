package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.practice.dto.AuthRequest;
import com.practice.dto.ResponseDto;
import com.practice.entity.UserCredential;
import com.practice.repository.UserCredentialRepository;
import com.practice.service.IdentityAuthService;

@RestController
@RequestMapping("/auth")
public class IdentityAuthController {
  
    @Autowired
    private UserCredentialRepository userRepo;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IdentityAuthService service;
    @PostMapping("/register")
    public UserCredential addNewUser(@RequestBody UserCredential user) {
        return service.saveUser(user);
    }

    @PostMapping("/login")
    public ResponseDto getToken(@RequestBody AuthRequest authRequest) {
    	System.out.println("yes .."+authRequest.getUsername()+"  "+authRequest.getPassword());
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
      
        if (authenticate.isAuthenticated()) {
        	String token=  	service.generateToken(authRequest.getUsername());
        	UserCredential user=
        	userRepo.findByUsername(authRequest.getUsername()).get();
        	ResponseDto resDto=new ResponseDto();
        	resDto.setToken(token);
        	resDto.setRole(user.getRole());
        	return resDto;
        } else {
            throw new RuntimeException("invalid access");
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        service.validateToken(token);
        return "Token is valid";
    }
//    @GetMapping("/test")
//    public String test() {
//    return "Test route accessed!";
//   }
    
}

