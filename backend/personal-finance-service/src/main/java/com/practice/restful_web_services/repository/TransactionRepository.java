package com.practice.restful_web_services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.practice.restful_web_services.entity.Transaction;
@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
	@Query("{'userId':?0}")
	List<Transaction> findTransactionByUserId(String userId);

}
