package com.example.demo.chainofresponsibility;

import org.springframework.stereotype.Component;

@Component
public class AdminEmailHandler extends AbstractEmailHandler {
  @Override
  protected String[] keyWords() {
    return new String[] {"Admin,admin"};
  }

  @Override
  protected void processEmailFinal(String emailText) {
    System.out.println("The Admin Department processing the email");
  }
}
