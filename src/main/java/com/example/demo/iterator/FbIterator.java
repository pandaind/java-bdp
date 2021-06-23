package com.example.demo.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FbIterator {
  private final Facebook facebook;
  private Iterator<String> iterator;
  private String value;

  public FbIterator(Facebook facebook) {
    this.facebook = facebook;
  }

  public void first() {
    iterator = facebook.friendsList.iterator();
    next();
  }

  public void next() {
    try {
      value = iterator.next();
    } catch (NoSuchElementException e) {
      value = null;
    }
  }

  public boolean hasNext() {
    return value != null;
  }

  public String currentValue() {
    return value;
  }
}
