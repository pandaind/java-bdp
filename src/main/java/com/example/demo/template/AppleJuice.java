package com.example.demo.template;

public class AppleJuice extends AbstractJuice {
  @Override
  public String getFruitName() {
    return "Apple";
  }

  @Override
  public void pickUpFruits() {
    System.out.println(getFruitName() + " is picked up for Juice preparation");
  }

  @Override
  public void addLiquid() {
    System.out.println("Add some milk in Apple juice ");
  }

  public void decorateJuiceHook() {
    System.out.println("decorate with chocolate and straw ");
  }
}
