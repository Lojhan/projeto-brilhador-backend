package com.mail.sender;

import com.mail.sender.configuration.messaging.QueueConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SenderApplication {

	@Autowired
	QueueConsumer queueConsumer;

	public static void main(String[] args) {
		SpringApplication.run(SenderApplication.class, args);
	}

}
