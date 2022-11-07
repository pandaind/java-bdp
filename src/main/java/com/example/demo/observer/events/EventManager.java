package com.example.demo.observer.events;

import java.io.File;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * EventManager
 */
public class EventManager {

    Map<String, List<EventListner>>  listners = new HashMap<>();

    public EventManager(String... operations){
        for (String operation : operations) {
            this.listners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, EventListner eventListener){
        List<EventListner> subs = this.listners.get(eventType);
        subs.add(eventListener);
    }

    public void unSubscriber(String eventType, EventListner eventListener){
        List<EventListner> subs = this.listners.get(eventType);
        subs.remove(eventListener);
    }

    public void notify(String eventType, File file){
        List<EventListner> subs = this.listners.get(eventType);
        for (EventListner sub : subs) {
            sub.update(eventType, file);
        }
    }
}