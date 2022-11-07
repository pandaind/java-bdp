package com.example.demo.template;

public class OrangeJuice extends AbstractJuice {
  @Override
  public String getFruitName() {
    return "Orange";
  }

  @Override
  public void pickUpFruits() {
    System.out.println(getFruitName() + " is picked up for Juice preparation");
  }

  @Override
  public void addLiquid() {
    System.out.println("Add some water in Orange juice ");
  }

  public void decorateJuiceHook() {
    System.out.println("decorate with lime slice and straw ");
  }
}
