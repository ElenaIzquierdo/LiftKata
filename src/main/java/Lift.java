public class Lift {

    private CurrentFloorMonitor currentFloorMonitor;

    public Lift(CurrentFloorMonitor currentFloorMonitor){
        this.currentFloorMonitor = currentFloorMonitor;
    }
    public LiftStatus requestLift(int sourceFloor, String direction) {
        LiftStatus liftStatus = currentFloorMonitor.getLiftStatus();
        if(liftStatus == LiftStatus.NOT_WORKING) return liftStatus;

        currentFloorMonitor.setCurrentFloor(sourceFloor);
        return LiftStatus.ARRIVED;
    }

    public LiftStatus requestFloor(int destinationFloor) {
        LiftStatus liftStatus = currentFloorMonitor.getLiftStatus();
        if(liftStatus == LiftStatus.NOT_WORKING) return liftStatus;

        currentFloorMonitor.setCurrentFloor(destinationFloor);
        return LiftStatus.ARRIVED;
    }

    public CurrentFloorMonitor getCurrentFloorMonitor() {
        return currentFloorMonitor;
    }
}
