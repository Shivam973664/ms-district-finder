package com.districtFinder.demo.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.districtFinder.demo.constant.ApplicationConstant;

@Service
public class KafkaService {
	
//	private Logger logger = new Logger
	private Logger logger= Logger.getLogger(KafkaService.class.getName());

	@KafkaListener(groupId = ApplicationConstant.GROUP_ID,topics = {ApplicationConstant.FIRST_TOPIC_NAME})
	public void locationChanged(String value) {
		logger.log( Level.INFO," **********" + value);
	}

}
