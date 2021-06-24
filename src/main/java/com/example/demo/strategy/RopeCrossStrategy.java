package com.example.demo.strategy;

public class RopeCrossStrategy implements CrevasseCrossingStrategy {

  @Override
  public void crossCrevasse() {
    System.out.println("Use Kernmantle rope");
    System.out.println("Tie rope with Anchor and through it on other side");
    System.out.println("Fix carabiner and fix it in rope");
    System.out.println("Cross using rope and untie yourself");
  }
}
