package com.example.demo.visitor;

public class Computer extends Subject {

    @Override
    public void acceptVisitingFacultyToTeach(VisitingFaculty visitingFaculty) {
        visitingFaculty.teach(this);
    }
}
