package com.practice.restful_web_services.dto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.practice.restful_web_services.entity.Post;
import com.practice.restful_web_services.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String id;
    private String name;
    private String email;
    private String password;
    private LocalDate birthDate;
    private LocalDate joinedDate;
    private String role;
    
}
