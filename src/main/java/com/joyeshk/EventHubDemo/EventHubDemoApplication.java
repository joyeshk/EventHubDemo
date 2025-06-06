package com.joyeshk.EventHubDemo;

import com.azure.spring.messaging.eventhubs.core.EventHubsTemplate;
import com.azure.spring.messaging.implementation.annotation.EnableAzureMessaging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@EnableAzureMessaging
public class EventHubDemoApplication {


	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(EventHubDemoApplication.class,args);
	}



}
