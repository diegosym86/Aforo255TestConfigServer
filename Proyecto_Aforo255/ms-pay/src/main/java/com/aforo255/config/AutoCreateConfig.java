package com.aforo255.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class AutoCreateConfig {
    @Bean
	public NewTopic depositEvent() {
		
		return TopicBuilder.name("transaction-events")
				.partitions(3)
				.replicas(1)
				.build();
		
	}
}
