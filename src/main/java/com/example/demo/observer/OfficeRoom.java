package com.example.demo.observer;

import java.util.ArrayList;
import java.util.List;

public class OfficeRoom implements Observable {
  List<Observer> observers = new ArrayList<>();
  private int unreadMessages;

  public OfficeRoom() {
    unreadMessages = 0;
  }

  public void setUnreadMessages(int messages) {
    unreadMessages = messages;
    notifyObservers();
  }

  private int getUnreadMessages() {
    return unreadMessages;
  }

  @Override
  public void addObserver(Observer observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyObservers() {
    observers.forEach(observer -> observer.update("Office Room", getUnreadMessages()));
  }
}
