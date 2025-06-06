package com.joyeshk.EventHubDemo;

import com.azure.spring.messaging.eventhubs.core.EventHubsTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class EventProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventHubDemoApplication.class);
    private final EventHubsTemplate eventHubsTemplate;
    private final String eventHubName;


    public EventProducer(EventHubsTemplate eventHubsTemplate,
                         @Value("${spring.cloud.azure.eventhubs.event-hub-name}") String eventHubName) {
        this.eventHubsTemplate = eventHubsTemplate;
        this.eventHubName = eventHubName;
    }

    public void writeEvent(String event){
        LOGGER.info("Sending message to Hub...");

        eventHubsTemplate.send(eventHubName, MessageBuilder.withPayload(event).build());
    }
}
