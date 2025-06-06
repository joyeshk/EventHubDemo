package com.joyeshk.EventHubDemo;

import com.azure.spring.messaging.eventhubs.implementation.core.annotation.EventHubsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@org.springframework.stereotype.Service
public class Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventHubDemoApplication.class);


    private static final String CONSUMER_GROUP = "$DEFAULT";


    @EventHubsListener(destination = "${spring.cloud.azure.eventhubs.event-hub-name}", group = CONSUMER_GROUP)
    public void handleMessageFromEventHub(String message) {
        LOGGER.info("New message received:"+message);
    }
}
