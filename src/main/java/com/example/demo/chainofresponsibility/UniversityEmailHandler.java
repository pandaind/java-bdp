package com.example.demo.chainofresponsibility;

public interface UniversityEmailHandler {
    void setNextEmailHandler(UniversityEmailHandler emailHandler);
    void processEmailHandler(String emailText);
    void handleEmail(String emailText);
}
