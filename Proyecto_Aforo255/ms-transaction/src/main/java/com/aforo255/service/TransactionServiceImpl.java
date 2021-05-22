package com.aforo255.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aforo255.entity.Transaction;
import com.aforo255.repository.TransactionRepository;
@Service
public class TransactionServiceImpl implements ITransactionService {

	@Autowired
	TransactionRepository _repository;
	
	@Override
	public Transaction save(Transaction transaction) {
		// TODO Auto-generated method stub
		return _repository.save(transaction);
	}

	@Override
	public Iterable<Transaction> findByInvoiceId(Integer invoiceId) {
		// TODO Auto-generated method stub
		return _repository.findByInvoiceId(invoiceId);
	}

	@Override
	public Iterable<Transaction> findAll() {
		// TODO Auto-generated method stub
		return _repository.findAll();
	}

}
