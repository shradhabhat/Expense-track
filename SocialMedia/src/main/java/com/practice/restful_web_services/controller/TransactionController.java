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

import com.practice.restful_web_services.dto.TransactionDto;
import com.practice.restful_web_services.dto.UserDto;
import com.practice.restful_web_services.entity.User;
import com.practice.restful_web_services.service.TransactionService;
import com.practice.restful_web_services.service.UserService;


@RestController
@RequestMapping("/transaction")
public class TransactionController {
	@Autowired
	private TransactionService service;

	public TransactionController(TransactionService service) {
		this.service = service;
	}
	@PostMapping
	public TransactionDto createTransaction(@RequestBody TransactionDto transactionDto,@RequestHeader("loggedInUser") String id) {
		transactionDto.setUserId(id);
		TransactionDto savedTransactionDto =service.saveTransaction(transactionDto);
		return savedTransactionDto;
	}
	

	@GetMapping("/getcurrent")
	public List<TransactionDto> getTransactionsByUserId(@RequestHeader("loggedInUser") String id){
		return service.getTransactionsByUser(id);
	}
	
	@GetMapping("/getbyid/{id}")
	public TransactionDto getTransaction(@PathVariable String id) {
		return service.getTransaction(id);
	}
	

	@DeleteMapping("/{id}")
	public void  deleteTransaction(@PathVariable String id) {
		service.deleteTransaction(id);
	}
	@PutMapping("/updatetransaction")
	public TransactionDto updateTransaction(@RequestBody TransactionDto transactionDto) {
		return service.updateTransaction(transactionDto);
	}
}
