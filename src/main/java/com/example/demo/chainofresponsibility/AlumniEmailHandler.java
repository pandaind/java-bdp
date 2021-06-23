package com.example.demo.chainofresponsibility;

import org.springframework.stereotype.Component;

@Component
public class AlumniEmailHandler extends AbstractEmailHandler {
  @Override
  protected String[] keyWords() {
    return new String[] {"Alumni", "Batch", "Previous"};
  }

  @Override
  protected void processEmailFinal(String emailText) {
    System.out.println("The Alumni Department processing the email");
  }
}
