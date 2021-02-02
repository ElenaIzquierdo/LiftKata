import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class LiftTest {


    @Nested
    class RequestLift {
        private final CurrentFloorMonitor currentFloorMonitor = new CurrentFloorMonitor(0, LiftStatus.NOT_MOVING);
        private final Lift lift = new Lift(currentFloorMonitor);
        @Test
        void shouldRequestLiftCorrectly() {
            assertThat(lift.requestLift(2, "UP"), is(LiftStatus.ARRIVED));
        }

        @Test
        void shouldReturnStatusNotWorkingIfLiftIsNotWorking() {
            CurrentFloorMonitor currentFloorMonitor = new CurrentFloorMonitor(0, LiftStatus.NOT_WORKING);
            Lift brokenLift = new Lift(currentFloorMonitor);

            assertThat(brokenLift.requestLift(2, "UP"), is(LiftStatus.NOT_WORKING));
        }
    }

    @Nested
    class RequestFloor {
        private final CurrentFloorMonitor currentFloorMonitor = new CurrentFloorMonitor(0, LiftStatus.NOT_MOVING);
        private final Lift lift = new Lift(currentFloorMonitor);

        @Test
        void shouldGoToDestinationFloorIfLiftIsWorking() {
            LiftStatus finalLiftStatus = lift.requestFloor(2);

            assertThat(finalLiftStatus, is(LiftStatus.ARRIVED));
            assertThat(lift.getCurrentFloorMonitor().getCurrentFloor(), is(2));
        }

        @Test
        void shouldNotMoveIfLiftIsNotWorking() {
            CurrentFloorMonitor currentFloorMonitor = new CurrentFloorMonitor(0, LiftStatus.NOT_WORKING);
            Lift brokenLift = new Lift(currentFloorMonitor);

            LiftStatus finalLiftStatus = brokenLift.requestFloor(2);

            assertThat(finalLiftStatus, is(LiftStatus.NOT_WORKING));
            assertThat(brokenLift.getCurrentFloorMonitor().getCurrentFloor(), is(0));
        }
    }
}