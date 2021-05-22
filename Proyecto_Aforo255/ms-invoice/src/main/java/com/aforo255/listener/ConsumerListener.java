package com.aforo255.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.aforo255.service.TransactionEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Component
public class ConsumerListener {

	@Autowired
	private TransactionEvents _transactionEvents;
	private Logger log = LoggerFactory.getLogger(ConsumerListener.class);
	
	@KafkaListener(topics = {"transaction-events"})
	public void OnMessage(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, JsonProcessingException {
		log.info("*************** MICROSERVICE INVOICE *******************");
		log.info("ConsumerRecord : {}", consumerRecord.value());
		_transactionEvents.processTransactionEvent(consumerRecord);
	}
}
