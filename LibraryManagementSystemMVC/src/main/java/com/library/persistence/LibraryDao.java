package com.library.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.entity.Transaction;

@Repository
public interface LibraryDao extends JpaRepository<Transaction, Integer> {
	
	List<Transaction> searchTransactionByEmployeeId(int employeeId);
	
	Transaction searchTransactionByOrderId(int orderId);

}
