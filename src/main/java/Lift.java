public class Lift {

    private int currentFloor;
    private final LiftStatus liftStatus;

    public Lift(int currentFloor, LiftStatus liftStatus){
        this.currentFloor = currentFloor;
        this.liftStatus = liftStatus;
    }
    public LiftStatus requestLift(int sourceFloor, String direction) {
        if(liftStatus == LiftStatus.NOT_WORKING) return liftStatus;

        currentFloor = sourceFloor;
        return LiftStatus.ARRIVED;
    }

    public LiftStatus requestFloor(int destinationFloor) {
        if(liftStatus == LiftStatus.NOT_WORKING) return liftStatus;

        currentFloor = destinationFloor;
        return LiftStatus.ARRIVED;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
}
