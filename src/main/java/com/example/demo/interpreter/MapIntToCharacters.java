package com.example.demo.interpreter;

public class MapIntToCharacters implements Expression {
  private String tString;

  public MapIntToCharacters(String tString) {
    this.tString = tString;
  }

  @Override
  public void interpret(Conversion originalContent) {
    originalContent.convertToCharacters(tString);
  }
}
