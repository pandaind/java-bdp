package com.example.demo.memento;

import org.springframework.stereotype.Component;

@Component
public class GameMission {
  private int percentageCompleted;
  int previousPercentageCompleted;

  public GameMission() {
    percentageCompleted = 0;
    previousPercentageCompleted = 0;
  }

  // mutator
  public void setPercentageCompeted(int percentage) {
    previousPercentageCompleted = percentageCompleted;
    percentageCompleted = percentage;
  }

  // accessor
  public int getPercentageCompleted() {
    return percentageCompleted;
  }
}
