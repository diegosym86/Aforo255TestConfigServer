package com.aforo255.service;

import org.springframework.stereotype.Service;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.aforo255.entity.Invoice;
import com.aforo255.entity.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TransactionEvents {
	@Autowired
	private IInvoiceService invoiceService ; 
	private Logger log = LoggerFactory.getLogger(TransactionEvents.class);
	@Autowired
	private ObjectMapper objectMapper ; 
	
	public void processTransactionEvent(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, JsonProcessingException {
		double newAmount= 0 ; 
		Invoice invoice = new Invoice();
		Transaction event = objectMapper.readValue(consumerRecord.value(), Transaction.class);
		invoice = invoiceService.findById(event.getInvoiceId());
		newAmount = invoice.getAmount()-event.getAmount();
		invoice.setState(newAmount <= 0 ? 1 : 0);
		invoice.setAmount(newAmount);
		log.info("Actulizando N° factura ***"+event.getInvoiceId());
		invoiceService.save(invoice);
	}
	
}
