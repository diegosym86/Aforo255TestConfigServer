package com.aforo255.service;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aforo255.dao.ITransactionDao;
import com.aforo255.domain.Transaction;

@Service
public class TransactionServiceImpl implements ITransactionService {

	@Autowired
	private ITransactionDao _transactionDao;

	@Override
	@Transactional
	public Transaction save(Transaction transaction) {
		// TODO Auto-generated method stub
		return _transactionDao.save(transaction);
	}

}