package org.design;

public abstract class Elevator {
  protected int currentFloor;
  protected State state;
  protected boolean emergencyStatus = false;
  private DoorState doorState = DoorState.CLOSED;

  protected enum DoorState {
    OPEN,
    CLOSED
  }

  public Elevator(int currentFloor, boolean emergencyStatus) {
    this.currentFloor = currentFloor;
    this.state = State.IDLE;
    this.emergencyStatus = emergencyStatus;
  }


  protected void openDoors() {
    doorState = DoorState.OPEN;
    System.out.println("Doors are OPEN on floor " + currentFloor);
  }

  protected void closeDoors() {
    doorState = DoorState.CLOSED;
    System.out.println("Doors are CLOSED");
  }

  protected void waitForSeconds(int seconds) {
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  protected abstract void operate();

  public abstract void processEmergency();


  public int getCurrentFloor() {
    return currentFloor;
  }

  public void setCurrentFloor(int currentFloor) {
    this.currentFloor = currentFloor;
  }

  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }

  public boolean isEmergencyStatus() {
    return emergencyStatus;
  }

  public void setEmergencyStatus(boolean emergencyStatus) {
    this.emergencyStatus = emergencyStatus;
  }

  public DoorState getDoorState() {
    return doorState;
  }

  public void setDoorState(DoorState doorState) {
    this.doorState = doorState;
  }
}
