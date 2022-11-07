package com.example.demo.strategy;

public class StrategyClient {
  public static void run(int distance) {
    System.out.println("Lets decide the strategy to cross mountain crevasse ");
    Context context = new Context();
    CrevasseCrossingStrategy crossingStrategy = context.getCrevasseCrossingStrategy(distance);
    System.out.println("Using Strategy : " + crossingStrategy.getClass().getSimpleName());
    crossingStrategy.crossCrevasse();
  }
}
