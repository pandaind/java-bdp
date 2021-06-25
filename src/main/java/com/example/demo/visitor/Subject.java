package com.example.demo.visitor;

public abstract class Subject {
  public abstract void acceptVisitingFacultyToTeach(VisitingFaculty visitingFaculty);

  public void teach() {
    System.out.println("IN-HOUSE Faculty teaching " + this.getClass().getSimpleName() + " subject");
  }
}

