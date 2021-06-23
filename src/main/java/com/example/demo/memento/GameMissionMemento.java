package com.example.demo.memento;

public class GameMissionMemento {
  private final GameMission gameMission;
  private final int copyOfCurrentCompletionProgress;
  private final int copyOfPreviousCompletionProgress;

  public GameMissionMemento(GameMission gameMission) {
    this.gameMission = gameMission;
    copyOfCurrentCompletionProgress = gameMission.getPercentageCompleted();
    copyOfPreviousCompletionProgress = gameMission.previousPercentageCompleted;
  }

  public void resetMissionStatus() {
    gameMission.setPercentageCompeted(copyOfCurrentCompletionProgress);
    gameMission.previousPercentageCompleted = copyOfPreviousCompletionProgress;
  }
}
