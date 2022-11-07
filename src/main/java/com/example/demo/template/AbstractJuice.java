package com.example.demo.template;

public abstract class AbstractJuice {
  public final void prepare() {
    pickUpFruits();
    washFruits();
    pileFruits();
    cutFruits();
    addLiquid();
    operateJuicer();
    decorateJuiceHook();
  }

  public abstract String getFruitName();

  public abstract void pickUpFruits();

  public abstract void addLiquid();

  public void washFruits() {
    System.out.println("Washing the fruit ... " + getFruitName());
  }

  public void pileFruits() {
    System.out.println("piling the fruit  ... " + getFruitName());
  }

  public void cutFruits() {
    System.out.println("cutting the fruit  ... " + getFruitName());
  }

  public void operateJuicer() {
    System.out.println("... operate juicer Ghur Ghur Ghur  ... ");
  }

  public void decorateJuiceHook() {
    System.out.println("add few dry fruits on top ");
  }
}
