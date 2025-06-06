package com.joyeshk.EventHubDemo;

import com.azure.spring.messaging.eventhubs.implementation.core.annotation.EventHubsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@org.springframework.stereotype.Service
public class Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventHubDemoApplication.class);
    private static final String EVENT_HUB_NAME = "angry-crane-125";
    private static final String CONSUMER_GROUP = "$DEFAULT";

    @EventHubsListener(destination = EVENT_HUB_NAME, group = CONSUMER_GROUP)
    public void handleMessageFromEventHub(String message) {
        LOGGER.info("New message received:"+message);
    }
}
