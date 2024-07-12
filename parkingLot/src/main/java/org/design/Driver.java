package org.design;

public class Driver {
  private Vehicle vehicle;
  private double paymentDue;

  private int id;
  public Driver(int id, Vehicle vehicle) {
    this.id = id;
    this.vehicle = vehicle;
    this.paymentDue = 0;
  }
  public void charge(double due) {
    this.paymentDue += due;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public double getPaymentDue() {
    return paymentDue;
  }

  public int getId() {
    return id;
  }
}
