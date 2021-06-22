package com.example.demo.chainofresponsibility;

import org.springframework.stereotype.Component;

@Component
public class FinanceEmailHandler extends AbstractEmailHandler {
  @Override
  protected String[] keyWords() {
    return new String[]{"Money","Finance","FINANCE"};
  }

  @Override
  protected void processEmailFinal(String emailText) {
    System.out.println("The Finance Department processing the email");
  }
}
