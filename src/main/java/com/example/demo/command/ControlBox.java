package com.example.demo.command;

import org.springframework.stereotype.Component;

@Component
public class ControlBox {
  public static final int SLIDER_MIN = 0;
  public static final int SLIDER_MAX = 100;

  private boolean poweredOn;
  private int sliderValue;

  public ControlBox() {
    poweredOn = false; // default value
    sliderValue = 0; // default value
  }

  public int getSliderValue() {
    return sliderValue;
  }

  public boolean hasPower() {
    return poweredOn;
  }

  // Method to turn power on
  public void powerOn() {
    poweredOn = true;
  }

  // Method to turn power off
  public void powerOff() {
    poweredOn = false;
  }

  // Method to increase slider value
  public void sliderIncrease() {
    if (hasPower()) {
      if (getSliderValue() < SLIDER_MAX) {
        sliderValue++;
        System.out.println(sliderValue); // simulate sending value to digital display
      }
    }
  }

  // Method to decrease slider value
  public void sliderDecrease() {
    if (hasPower()) {
      if (getSliderValue() > SLIDER_MIN) {
        sliderValue--;
        System.out.println(sliderValue); // simulate sending value to digital display
      }
    }
  }
}
