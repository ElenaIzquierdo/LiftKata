public class CurrentFloorMonitor {

    private int currentFloor;
    private LiftStatus liftStatus;

    public CurrentFloorMonitor(int currentFloor, LiftStatus liftStatus) {
        this.currentFloor = currentFloor;
        this.liftStatus = liftStatus;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public LiftStatus getLiftStatus() {
        return liftStatus;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void setLiftStatus(LiftStatus liftStatus) {
        this.liftStatus = liftStatus;
    }
}
