package com.example.demo.template;

public class MixJuice extends AbstractJuice {
  @Override
  public String getFruitName() {
    return "Vegetable";
  }

  @Override
  public void pickUpFruits() {
    System.out.println(getFruitName() + " are picked up for Juice preparation");
  }

  @Override
  public void addLiquid() {
    System.out.println("Add some water in Mix juice ");
  }

  public void decorateJuiceHook() {
    System.out.println("decorate with lime, ice, honey and straw ");
  }
}
