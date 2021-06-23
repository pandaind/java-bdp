package com.example.demo.nullobject;

public class EastCoTrain implements TrainStatus {
  private boolean activated;

  @Override
  public void activate() {
    activated = true;
    System.out.println("Train Status Update: East Co Train Activated.");
  }

  @Override
  public void deactivate() {
    activated = false;
    System.out.println("Train Status Update: East Co Train Deactivated.");
  }

  @Override
  public boolean isActivated() {
    return activated;
  }
}
