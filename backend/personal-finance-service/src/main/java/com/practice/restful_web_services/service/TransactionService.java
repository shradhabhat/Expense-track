package com.practice.restful_web_services.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practice.restful_web_services.dto.TransactionDto;
@Service
public interface TransactionService{
	public TransactionDto saveTransaction(TransactionDto transactionDto);
	public TransactionDto getTransaction(String id);
	public List<TransactionDto> getTransactionsByUser(String userId);
	public TransactionDto updateTransaction(TransactionDto transactionDto);
	public void deleteTransaction(String id);
}
