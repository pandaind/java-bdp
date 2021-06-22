package com.example.demo;

import com.example.demo.chainofresponsibility.UniversityEmailHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaBdpApplication implements CommandLineRunner {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private UniversityEmailHandler emailHandler;

  public static void main(String[] args) {
    SpringApplication.run(JavaBdpApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    // chain of responsibility
    emailHandler.handleEmail("Money sent 1000 dollar");
    emailHandler.handleEmail("");
    emailHandler.handleEmail("I am from Batch 2012");
  }
}
