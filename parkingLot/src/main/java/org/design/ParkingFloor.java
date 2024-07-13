package org.design;

import java.util.HashMap;

public class ParkingFloor {
  private int[] spots;
  private HashMap<Vehicle, int[]> vehicleMap;

  public ParkingFloor(int spotCount) {
    this.spots = new int[spotCount];
    this.vehicleMap = new HashMap<Vehicle, int[]>();
  }

  public boolean parkVehicle(Vehicle vehicle) {
    int size = vehicle.getSpotSize();
    int l = 0, r = 0;
    while (r < spots.length) {
      if (this.spots[r] != 0) {
        l = r + 1;
      }
      if (r - l + 1 == size) {
        for (int i = l; i <= r; i++) {
          spots[i] = 1;
        }
        vehicleMap.put(vehicle, new int[]{l, r});
        return true;
      }
      r += 1;
    }
    return false;
  }
  public boolean removeVehicle(Vehicle vehicle) {
    if (!vehicleMap.containsKey(vehicle)) {
      return false;
    }
    int[] startEnd = this.vehicleMap.get(vehicle);
    int start = startEnd[0], end = startEnd[1];
    for (int i = start; i <= end; i++) {
      this.spots[i] = 0;
    }
    this.vehicleMap.remove(vehicle);
    return true;
  }

  public int[] getSpots() {
    return spots;
  }
  public int[] getVehicleSpots(Vehicle vehicle) {
    return this.vehicleMap.get(vehicle);
  }

}
