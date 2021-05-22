package com.aforo255.dao;

import org.springframework.data.repository.CrudRepository;

import com.aforo255.domain.Transaction;

public interface ITransactionDao extends CrudRepository<Transaction, Integer> {

}

