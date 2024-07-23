package org.design;

public class ServiceRequest extends Request{
  public ServiceRequest(RequestOrigin origin, int currentFloor, int destinationFloor) {
    super(origin, currentFloor, destinationFloor);
    this.elevatorType = ElevatorType.SERVICE;
  }
}
