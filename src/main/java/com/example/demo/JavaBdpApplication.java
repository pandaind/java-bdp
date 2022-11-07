package com.example.demo;

import com.example.demo.chainofresponsibility.UniversityEmailHandler;
import com.example.demo.command.ControlBox;
import com.example.demo.interpreter.InterpreterDriver;
import com.example.demo.iterator.Facebook;
import com.example.demo.iterator.FbIterator;
import com.example.demo.mediator.ATC;
import com.example.demo.mediator.Flight;
import com.example.demo.memento.Game;
import com.example.demo.nullobject.TrainStatus;
import com.example.demo.nullobject.TrainStatusFactory;
import com.example.demo.observer.NoticeBoard;
import com.example.demo.observer.OfficeRoom;
import com.example.demo.state.StateClient;
import com.example.demo.strategy.StrategyClient;
import com.example.demo.template.AbstractJuice;
import com.example.demo.template.AppleJuice;
import com.example.demo.template.MixJuice;
import com.example.demo.template.OrangeJuice;
import com.example.demo.visitor.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaBdpApplication implements CommandLineRunner {

  private final Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired private UniversityEmailHandler emailHandler;
  @Autowired private ControlBox controlBox;
  @Autowired private InterpreterDriver interpreter;
  @Autowired private Facebook facebook;
  @Autowired private Game game;

  public static void main(String[] args) {
    SpringApplication.run(JavaBdpApplication.class, args);
  }

  @Override
  public void run(String... args) {

    log.info("********** chain of responsibility ***********");
    emailHandler.handleEmail("Money sent 1000 dollar");
    emailHandler.handleEmail("");
    emailHandler.handleEmail("I am from Batch 2012");

    log.info("********** command ***********");
    controlBox.powerOn();
    controlBox.sliderIncrease();
    controlBox.sliderIncrease();
    controlBox.sliderDecrease();
    controlBox.powerOff();

    log.info("********** interpreter ***********");
    interpreter.interpret("45678334533");

    log.info("********** iterator ***********");
    FbIterator fbIterator = facebook.getIterator();
    for (fbIterator.first(); fbIterator.hasNext(); fbIterator.next()) {
      log.info("{}", fbIterator.currentValue());
    }

    log.info("********** mediator ***********");
    ATC blrAtc = new ATC();
    Flight indigo = new Flight(blrAtc, "INDIGO Airlines");
    Flight ia = new Flight(blrAtc, "Indian Airlines");
    Flight ai = new Flight(blrAtc, "Air India");
    Flight aa = new Flight(blrAtc, "Air Asia");
    blrAtc.grantLandingPermission(indigo);
    blrAtc.grantLandingPermission(ia);
    blrAtc.landFlight(indigo);
    blrAtc.landFlight(ia);
    blrAtc.grantLandingPermission(ia);
    blrAtc.landFlight(ia);

    log.info("********** memento ***********");
    game.play();

    log.info("********** null object ***********");
    List.of("EastCo", "SouthCo", "NorthCo", "WestCo", "International")
        .forEach(
            train -> {
              TrainStatus status = TrainStatusFactory.getTrain(train);
              status.activate();
              status.deactivate();
            });

    log.info("********** observer ***********");
    NoticeBoard classRoom = new NoticeBoard("Class Room");
    NoticeBoard playground = new NoticeBoard("Play Ground");
    OfficeRoom officeRoom = new OfficeRoom();

    officeRoom.addObserver(classRoom);
    officeRoom.addObserver(playground);
    officeRoom.setUnreadMessages(12);

    officeRoom.removeObserver(playground);
    officeRoom.setUnreadMessages(6);

    log.info("********** state ***********");
    StateClient.run();

    log.info("********** strategy ***********");
    StrategyClient.run(5);

    log.info("********** template ***********");
    AbstractJuice juice = new MixJuice();
    juice.prepare();
    juice = new AppleJuice();
    juice.prepare();
    juice = new OrangeJuice();
    juice.prepare();

    log.info("********** visitor ***********");
    Subject subject = new Maths();
    subject.teach(); // normal subject .. so teach

    subject = new Aviation();
    VisitingFaculty visitor = new ProfX();
    subject.acceptVisitingFacultyToTeach(visitor); // advance subject so delegate
  }
}
