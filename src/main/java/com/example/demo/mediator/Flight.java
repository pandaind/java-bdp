package com.example.demo.mediator;

public class Flight {
  FlightStatus status;
  ATC atcMediator;
  public String name;

  public Flight(ATC atcMediator, String flightName) {
    status = FlightStatus.IN_Q;
    name = flightName;
    this.atcMediator = atcMediator;
  }

  public void grantLandingPermission() {
    atcMediator.grantLandingPermission(this);
  }

  public void landFlight() {
    atcMediator.landFlight(this);
  }
}
