package com.example.demo.memento;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Game {
  private final Logger log = LoggerFactory.getLogger(this.getClass());
  private final GameMission gameMission;
  private GameMissionMemento memento;

  @Autowired
  public Game(GameMission gameMission) {
    this.gameMission = gameMission;
  }

  public void play() {
    log.info("Game Mission Started...");
    this.memento = new GameMissionMemento(gameMission);

    gameMission.setPercentageCompeted(50);
    log.info("Mission target complete... {}%", gameMission.getPercentageCompleted());
    log.info("Saving  the milestone...");
    this.memento = new GameMissionMemento(gameMission);

    gameMission.setPercentageCompeted(70);
    log.info("Mission target complete... {}%", gameMission.getPercentageCompleted());
    log.info("Saving  the milestone...");
    this.memento = new GameMissionMemento(gameMission);

    log.info("Mission failed...");
    log.info("Resuming from previous milestone ...");
    this.memento.resetMissionStatus();

    log.info("Mission resumed from milestone... {}%", gameMission.getPercentageCompleted());

    gameMission.setPercentageCompeted(90);
    log.info("Mission target complete... {}%", gameMission.getPercentageCompleted());
    log.info("Saving  the milestone...");
    this.memento = new GameMissionMemento(gameMission);

    gameMission.setPercentageCompeted(100);
    log.info("Mission target complete... {}%", gameMission.getPercentageCompleted());
  }
}
