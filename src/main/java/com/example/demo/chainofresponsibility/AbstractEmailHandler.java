package com.example.demo.chainofresponsibility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractEmailHandler implements UniversityEmailHandler {
  private UniversityEmailHandler theNextHandlerInTheChain;

  @Autowired private AcademicEmailHandler academic;
  @Autowired private AlumniEmailHandler alumni;
  @Autowired private AdvisingEmailHandler advising;
  @Autowired private FinanceEmailHandler finance;
  @Autowired private HREmailHandler hr;
  @Autowired private AdminEmailHandler admin;
  @Autowired private FrontDeskEmailHandler frontDesk;

  @Override
  public void setNextEmailHandler(UniversityEmailHandler emailHandler) {
    theNextHandlerInTheChain = emailHandler;
  }

  @Override
  public void processEmailHandler(String emailText) {
    // starting value
    boolean keyWordFound = false;

    // check for a matching keyword in emailText
    if (keyWords().length == 0) {
      keyWordFound = true;
    } else {
      for (String oneKeyword : keyWords()) {
        if (emailText.contains(oneKeyword)) {
          keyWordFound = true; // change value if match is found
          break; // leave loop if match is found
        }
      }
    }

    // Check to see if email can be processed by the current email handler based on keyword
    // match

    if (keyWordFound) {
      processEmailFinal(emailText);
    } else {
      // Pass along the chain if the email is not processed by the current email handler
      theNextHandlerInTheChain.processEmailHandler(emailText);
    }
  }

  public void handleEmail(String emailText) {
    UniversityEmailHandler emailHandler = setupEmailHandlerChain();
    // this line will start the chain
    emailHandler.processEmailHandler(emailText);
  }

  private UniversityEmailHandler setupEmailHandlerChain() {
    // setup chain direction
    academic.setNextEmailHandler(alumni);
    alumni.setNextEmailHandler(advising);
    advising.setNextEmailHandler(finance);
    finance.setNextEmailHandler(hr);
    hr.setNextEmailHandler(admin);
    admin.setNextEmailHandler(frontDesk);
    // we do not need to set the next email handler after admin
    // because it is the end of the chain of responsibility
    return academic;
  }

  protected abstract String[] keyWords();

  protected abstract void processEmailFinal(String emailText);
}
