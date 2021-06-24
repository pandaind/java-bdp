package com.example.demo.strategy;

public class JumpCrossStrategy implements CrevasseCrossingStrategy {
  @Override
  public void crossCrevasse() {
    System.out.println("Move 10 steps back");
    System.out.println("Start running as fast as possible");
    System.out.println("Jump over the Crevasse");
    System.out.println("Stop and Anchor your self");
  }
}
