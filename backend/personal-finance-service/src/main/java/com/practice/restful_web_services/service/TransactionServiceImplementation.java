package com.practice.restful_web_services.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.restful_web_services.dto.TransactionDto;
import com.practice.restful_web_services.entity.Category;
import com.practice.restful_web_services.entity.Transaction;
import com.practice.restful_web_services.exception.ApplicationException;
import com.practice.restful_web_services.repository.TransactionRepository;
@Service
public class TransactionServiceImplementation implements TransactionService {
	@Autowired
	TransactionRepository transactionRepository;
	    
	    public TransactionDto saveTransaction(TransactionDto transactionDto) {
	    	if(transactionDto.getCategory()==null) {
	    		transactionDto.setCategory(Category.OTHER);
	    	}
	        // Convert DTO to entity
	        Transaction transaction = convertToEntity(transactionDto);
	       
	        // Save the transaction; MongoDB will generate an ID if it is null
	        Transaction savedTransaction = transactionRepository.save(transaction);
	        
	        // Convert the saved entity back to DTO
	        return convertToDto(savedTransaction);
   }
	    
	    public List<TransactionDto> getTransactionsByUser(String userId) {
	        List<Transaction> transactions = transactionRepository.findTransactionByUserId(userId);
	        return transactions.stream()
	                           .map(this::convertToDto)
	                           .collect(Collectors.toList());
	    }
		
		@Override
		public TransactionDto getTransaction(String id) {
			Transaction transaction= transactionRepository.findById(id).orElseThrow(() -> new RuntimeException("transaction not found"));
			return convertToDto(transaction);
		}

		@Override
		public TransactionDto updateTransaction(TransactionDto transactionDto) {
			Transaction transaction= transactionRepository.findById(transactionDto.getId()).orElseThrow(() -> new RuntimeException("transaction not found"));
			 transaction= convertToEntity(transactionDto);
			 return convertToDto(transactionRepository.save(transaction));
		}

		@Override
		public void deleteTransaction(String id) {
			transactionRepository.findById(id).orElseThrow(()->new ApplicationException("transaction"));
			transactionRepository.deleteById(id);
		}
		
	    // Helper method: DTO to Entity conversion
	    private Transaction convertToEntity(TransactionDto dto) {
	        return Transaction.builder()
	                .id(dto.getId())             // Could be null for new transactions
	                .userId(dto.getUserId())
	                .category(dto.getCategory())
	                .amount(dto.getAmount())
	                .dateTime(dto.getDateTime())
	                .description(dto.getDescription())
	                .build();
	    }
	    
	    // Helper method: Entity to DTO conversion
	    private TransactionDto convertToDto(Transaction transaction) {
	        return TransactionDto.builder()
	                .id(transaction.getId())
	                .userId(transaction.getUserId())
	                .category(transaction.getCategory())
	                .amount(transaction.getAmount())
	                .dateTime(transaction.getDateTime())
	                .description(transaction.getDescription())
	                .build();
	    }

}	
