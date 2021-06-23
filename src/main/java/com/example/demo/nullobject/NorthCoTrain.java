package com.example.demo.nullobject;

public class NorthCoTrain implements TrainStatus {
  private boolean activated;

  @Override
  public void activate() {
    activated = true;
    System.out.println("Train Status Update: North Co Train Activated.");
  }

  @Override
  public void deactivate() {
    activated = false;
    System.out.println("Train Status Update: North Co Train Deactivated.");
  }

  @Override
  public boolean isActivated() {
    return false;
  }
}
