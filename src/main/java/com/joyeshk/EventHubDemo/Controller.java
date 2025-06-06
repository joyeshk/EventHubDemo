package com.joyeshk.EventHubDemo;

import jakarta.websocket.server.PathParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventHubDemoApplication.class);

    final EventProducer eventProducer;

    public Controller(EventProducer eventProducer){
        this.eventProducer = eventProducer;
    }

    @GetMapping("/info")
    String getInfo(){
        return "server started!";
    }


    @GetMapping("/sendEvent")
    String sendEvent(@PathParam("event") String event){
        eventProducer.writeEvent("Sending event:"+event);
        LOGGER.info("sendEvent success.");
        return "Event Sent:"+event;
    }
}
