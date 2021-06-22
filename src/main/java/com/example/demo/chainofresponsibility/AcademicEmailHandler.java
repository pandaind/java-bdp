package com.example.demo.chainofresponsibility;

import org.springframework.stereotype.Component;

@Component
public class AcademicEmailHandler extends AbstractEmailHandler {
  @Override
  protected String[] keyWords() {
    return new String[] {"academic"};
  }

  @Override
  protected void processEmailFinal(String emailText) {
    System.out.println("The Academic Department processing the email");
  }
}
