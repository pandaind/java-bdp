package com.example.demo.chainofresponsibility;

import org.springframework.stereotype.Component;

@Component
public class AdvisingEmailHandler extends AbstractEmailHandler {
    @Override
    protected String[] keyWords() {
        return new String[]{"Advise","Help","Find","Contact"};
    }

    @Override
    protected void processEmailFinal(String emailText) {
        System.out.println("The Advise Department processing the email");
    }
}
