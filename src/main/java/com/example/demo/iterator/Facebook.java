package com.example.demo.iterator;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class Facebook {
  protected List<String> friendsList = new ArrayList<>();

  public Facebook() {
    friendsList.add("A");
    friendsList.add("B");
    friendsList.add("C");
    friendsList.add("D");
    friendsList.add("E");
    friendsList.add("F");
  }

  public FbIterator getIterator() {
    return new FbIterator(this);
  }
}
