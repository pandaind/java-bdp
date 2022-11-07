package com.example.demo.visitor;

public class Maths extends Subject {
  @Override
  public void acceptVisitingFacultyToTeach(VisitingFaculty visitingFaculty) {
    visitingFaculty.teach(this);
  }
}
