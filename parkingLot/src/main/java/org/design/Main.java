package org.design;

public class Main {

  public static void main(String[] args) {
    ParkingGarage parkingGarage = new ParkingGarage(1, 3);
    ParkingController parkingSystem = new ParkingController(parkingGarage, 5);

    Driver driver1 = new Driver(1, new Car());
    Driver driver2 = new Driver(2, new MidSizeCar());
    Driver driver3 = new Driver(3, new Trunk());

    System.out.println(parkingSystem.parkVehicle(driver1));    // true
    System.out.println(parkingSystem.parkVehicle(driver2));    // true
    System.out.println(parkingSystem.parkVehicle(driver3));    // false

    System.out.println(parkingSystem.removeVehicle(driver1));  // true
    System.out.println(parkingSystem.removeVehicle(driver2));  // true

    System.out.println(parkingSystem.removeVehicle(driver3));  // false

    System.out.println(parkingSystem.parkVehicle(driver3));    // true
  }
}