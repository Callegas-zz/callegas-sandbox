package com.callegasdev.springreactor.controller;

import com.callegasdev.springreactor.domain.NotificationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.bus.Event;
import reactor.bus.EventBus;

@Controller
public class NotificationController {

    @Autowired
    private EventBus eventBus;

    @GetMapping("/startNotification/{totalNotifications}")
    public void startNotification(@PathVariable Integer totalNotifications) {
        for (int i = 0; i < totalNotifications; i++) {
            NotificationData notificationData = new NotificationData();
            notificationData.setId(i);

            eventBus.notify("notificationConsumer", Event.wrap(notificationData));

            System.out.println("Notification " + i + ": notification task submitted successfully");
        }
    }
}