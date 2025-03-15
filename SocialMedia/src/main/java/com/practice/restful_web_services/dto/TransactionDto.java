package com.practice.restful_web_services.dto;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import com.practice.restful_web_services.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDto {
    @Id
    private String id;
    private String userId;
    private Category category;
    private double amount;
    private String description;
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private LocalDateTime dateTime;
}
