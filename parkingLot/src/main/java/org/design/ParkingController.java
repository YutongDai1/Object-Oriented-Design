package org.design;

import java.util.Calendar;
import java.util.HashMap;

public class ParkingController {
  private ParkingGarage parkingGarage;
  private HashMap<Integer, Integer> timeParked;
  private int hourlyRate;

  public ParkingController(ParkingGarage parkingGarage, int hourlyRate) {
    this.parkingGarage = parkingGarage;
    this.hourlyRate = hourlyRate;
    timeParked = new HashMap<Integer, Integer>();
  }

  public boolean parkVehicle(Driver driver) {
    int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    boolean isParked = parkingGarage.parkVehicle(driver.getVehicle());
    if (isParked) {
      timeParked.put(driver.getId(), currentHour);
    }
    return isParked;
  }

  public boolean removeVehicle(Driver driver) {
    if (!timeParked.containsKey(driver.getId())) {
      return false;
    }
    int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    int time = (int) Math.ceil(currentHour - this.timeParked.get(driver.getId()));
    driver.charge(time * this.hourlyRate);
    timeParked.remove(driver.getId());
    return parkingGarage.removeVehicle(driver.getVehicle());
  }
}
