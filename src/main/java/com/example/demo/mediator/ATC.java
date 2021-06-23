package com.example.demo.mediator;

public class ATC {
  Flight approachingFlight;

  public void grantLandingPermission(Flight flight) {
    if (this.approachingFlight == null) {
      this.approachingFlight = flight;
      flight.status = FlightStatus.IN_APPROACH;
      System.out.printf(
          "\nLanding Permission Granted to %s , START APPROACHING .... ", flight.name);
    } else {
      if (!this.approachingFlight.name.equalsIgnoreCase(flight.name)) {
        System.out.printf(
            "\nLanding Permission Not Granted to %s as other flight (%s) has blocked the run way",
            flight.name, this.approachingFlight.name);
      } else {
        System.out.printf(" %S you already have the permission - ", flight.name);
      }
    }
  }

  public void landFlight(Flight flight) {
    if (flight.status.equals(FlightStatus.IN_APPROACH)) {
      System.out.printf("\nCongratulation for safe Landing %s . . . ", flight.name);
      flight.status = FlightStatus.LANDED;
      this.approachingFlight = null;
    } else if (flight.status.equals(FlightStatus.IN_Q)) {
      System.out.printf("\nGrand permission before landing - WARNING to %s ", flight.name);
    } else {
      System.out.printf("\nFlight %s is already grounded  ", flight.name);
    }
  }
}
