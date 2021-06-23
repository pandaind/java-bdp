package com.example.demo.observer;

public class NoticeBoard implements Observer {
  public static final int UNREAD_ALERT_LEVEL = 0;
  private String boardName;

  public NoticeBoard(String boardName) {
    this.boardName = boardName;
  }

  @Override
  public void update(String from, int messages) {
    if (messages > UNREAD_ALERT_LEVEL) {
      System.out.println(boardName + " You have " + messages + " unread messages from " + from);
    } else {
      System.out.println(boardName + "No unread messages found from " + from);
    }
  }
}
