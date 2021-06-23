package com.example.demo.nullobject;

public class NullObjectTrain implements TrainStatus {

  @Override
  public void activate() {
    // empty
  }

  @Override
  public void deactivate() {
    // empty
  }

  @Override
  public boolean isActivated() {
    return false;
  }
}
