package org.design;

public class Main {

  public static void main(String[] args) {
    ElevatorFactory factory = new ElevatorFactory();
    Controller controller = new Controller(factory);


    controller.sendPassengerUpRequests(new Request(RequestOrigin.OUTSIDE, 1, 5));
    controller.sendPassengerDownRequests(new Request(RequestOrigin.OUTSIDE, 3, 2));
    controller.sendPassengerUpRequests(new Request(RequestOrigin.OUTSIDE, 4, 6));
    controller.handlePassengerRequests();

    controller.sendPassengerUpRequests(new Request(RequestOrigin.OUTSIDE, 4, 9));
    controller.sendPassengerDownRequests(new Request(RequestOrigin.INSIDE, 12));
    controller.sendPassengerUpRequests(new Request(RequestOrigin.OUTSIDE, 34, 4));
    controller.sendPassengerDownRequests(new Request(RequestOrigin.OUTSIDE, 4, 5));
    controller.handlePassengerRequests();


    System.out.println("Now processing service requests");

    controller.sendServiceRequest(new ServiceRequest(RequestOrigin.INSIDE, 12, 5, 5));
    controller.sendServiceRequest(new ServiceRequest(RequestOrigin.OUTSIDE, 13, 2, 2));
    controller.sendServiceRequest(new ServiceRequest(RequestOrigin.INSIDE, 23, 15, 5));

    controller.handleServiceRequests();
  }
}