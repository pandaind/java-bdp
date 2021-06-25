package com.example.demo.visitor;

public class AnyOtherProfessor implements VisitingFaculty {

    @Override
    public void teach(Aviation aviation) {
        System.out.println("Visiting Faculty teaching Aviation subject");
    }

    @Override
    public void teach(Computer computer) {
        System.out.println("Visiting Faculty teaching Computer subject");
    }

    @Override
    public void teach(Maths maths) {
        System.out.println("Visiting Faculty teaching Maths subject");
    }
}
