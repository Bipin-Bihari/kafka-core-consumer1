package com.course.kafka.consumer;

import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaKeyConsumer {
	private final Logger logger = LoggerFactory.getLogger(KafkaKeyConsumer.class);
	
	@KafkaListener(topics = "t-multi-partition", concurrency="2")
	public void consume(ConsumerRecord<String, String> consumerRecord) throws InterruptedException {
		logger.info("key : {}, Partition : {}, message : {}",consumerRecord.key(), consumerRecord.partition(), consumerRecord.value());
		TimeUnit.SECONDS.sleep(1);
	}

}
