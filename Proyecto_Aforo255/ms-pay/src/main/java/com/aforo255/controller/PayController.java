package com.aforo255.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.aforo255.domain.Transaction;

import com.aforo255.producer.PayEventProducer;
import com.aforo255.service.ITransactionService;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {
	@Autowired
	private ITransactionService service;
	@Autowired
	PayEventProducer eventProducer;
	private Logger log = LoggerFactory.getLogger(PayController.class);
	@PostMapping("/v1/payevent")
	public ResponseEntity<Transaction> postDepositEvent(@RequestBody Transaction transaction) throws JsonProcessingException {
		log.info("antes de transql");
		Transaction transql = service.save(transaction);
		log.info("despues de transql");
		log.info("antes de sendPayEvent");
		eventProducer.sendDepositEvent(transql);
		log.info("despues de sendPayEvent");
		return ResponseEntity.status(HttpStatus.CREATED).body(transql);
	}
	
	
}