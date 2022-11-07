package com.example.demo.visitor;

public class Aviation extends Subject {

  @Override
  public void acceptVisitingFacultyToTeach(VisitingFaculty visitingFaculty) {
    visitingFaculty.teach(this);
  }
}
