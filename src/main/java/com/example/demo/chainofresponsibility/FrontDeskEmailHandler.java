package com.example.demo.chainofresponsibility;

import org.springframework.stereotype.Component;

@Component
public class FrontDeskEmailHandler extends AbstractEmailHandler {
    @Override
    protected String[] keyWords() {
        return new String[]{};
    }

    @Override
    protected void processEmailFinal(String emailText) {
        System.out.println("Hello ! How can i help you ?");
    }
}
