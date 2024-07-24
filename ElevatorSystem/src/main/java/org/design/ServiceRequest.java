package org.design;

public class ServiceRequest extends Request{
  private double weight;
  public ServiceRequest(RequestOrigin origin, int currentFloor, int destinationFloor, int weight) {
    super(origin, currentFloor, destinationFloor);
    this.elevatorType = ElevatorType.SERVICE;
    this.weight = weight;
  }

  public double getWeight() {
    return weight;
  }
}
