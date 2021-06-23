package com.example.demo.interpreter;

import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InterpreterDriver {
  private final Conversion grammar;
  public Expression theExpression = null;

  @Autowired
  public InterpreterDriver(Conversion grammar) {
    this.grammar = grammar;
  }

  public void interpret(String tString) {
    Scanner in = new Scanner(System.in);
    theExpression = new MapIntToCharacters(tString);
    theExpression.interpret(this.grammar);
  }
}
