package com.example.demo.observer.events;

import java.io.File;

/**
 * LogOpenListner
 */
public class LogOpenListner implements EventListner{

    private File log;

    public LogOpenListner(String fileName) {
        this.log = new File(fileName);
    }
    

    public void update(String eventType, File file) {
        System.out.println("Save to log " + log + ": Someone has performed " + eventType + " operation with the following file: " + file.getName());
    };
}