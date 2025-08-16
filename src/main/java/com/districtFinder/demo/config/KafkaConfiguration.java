package com.districtFinder.demo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfiguration {

//	@Bean
//	public NewTopic topic() {
//		return TopicBuilder
//				.name("location-update-topic")
////				.partitions(0) /// we can add partitions by default it will pick default values
////				.replicas(0)
//				.build();
//	}
	

}
