package com.example.demo.observer.events;

import java.io.File;

/**
 * EmailNotificationListner
 */
public class EmailNotificationListner implements EventListner{
    private String email;

    public EmailNotificationListner(String email) {
        this.email = email;
    }

    public void update(String eventType, File file) {
        System.out.println("Email to " + email + ": Someone has performed " + eventType + " operation with the following file: " + file.getName());
    };
}