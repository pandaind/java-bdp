package com.example.demo.observer.events;

import java.io.File;

/**
 * EventListner
 */
public interface EventListner {
    void update(String eventType, File file);
}