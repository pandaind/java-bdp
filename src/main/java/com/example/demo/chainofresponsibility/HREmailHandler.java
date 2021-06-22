package com.example.demo.chainofresponsibility;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class HREmailHandler extends AbstractEmailHandler {
  @Override
  protected String[] keyWords() {
    return new String[]{"Hr,hr,HR"};
  }

  @Override
  protected void processEmailFinal(String emailText) {
    System.out.println("The HR Department processing the email");
  }
}
