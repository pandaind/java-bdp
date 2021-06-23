package com.example.demo.nullobject;

public class TrainStatusFactory {
  public static TrainStatus getTrain(String name) {
    TrainStatus status = new NullObjectTrain();

    if (name.equalsIgnoreCase("EastCo")) {
      status = new EastCoTrain();

    } else if (name.equalsIgnoreCase("WestCo")) {
      status = new WestCoTrain();

    } else if (name.equalsIgnoreCase("NorthCo")) {
      status = new NorthCoTrain();

    } else if (name.equalsIgnoreCase("SouthCo")) {
      status = new SouthCoTrain();
    }

    return status;
  }
}
