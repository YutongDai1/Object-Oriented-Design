package org.design;

public class ParkingGarage {
  private ParkingFloor[] parkingFloors;

  public ParkingGarage(int floorCount, int spotsPerFloor) {
    this.parkingFloors = new ParkingFloor[floorCount];
    for (int i = 0; i < floorCount; i++) {
      this.parkingFloors[i] = new ParkingFloor(spotsPerFloor);
    }
  }

  public boolean parkVehicle(Vehicle vehicle) {
    for (ParkingFloor floor : parkingFloors) {
      if (floor.parkVehicle(vehicle)) {
        return true;
      }
    }
    return false;
  }

  public boolean removeVehicle(Vehicle vehicle) {
    for (ParkingFloor floor : parkingFloors) {
      if (floor.removeVehicle(vehicle)) {
        return true;
      }
    }
    return false;
  }
}
