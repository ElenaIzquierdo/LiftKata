import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class LiftTest {


    @Nested
    class RequestLift {
        private final Lift lift = new Lift(0, LiftStatus.NOT_MOVING);
        @Test
        void shouldRequestLiftCorrectly() {
            assertThat(lift.requestLift(2, "UP"), is(LiftStatus.ARRIVED));
        }

        @Test
        void shouldReturnStatusNotWorkingIfLiftIsNotWorking() {
            Lift brokenLift = new Lift(0, LiftStatus.NOT_WORKING);

            assertThat(brokenLift.requestLift(2, "UP"), is(LiftStatus.NOT_WORKING));
        }
    }

    @Nested
    class RequestFloor {
        private final Lift lift = new Lift(0, LiftStatus.NOT_MOVING);

        @Test
        void shouldGoToDestinationFloorIfLiftIsWorking() {
            LiftStatus finalLiftStatus = lift.requestFloor(2);

            assertThat(finalLiftStatus, is(LiftStatus.ARRIVED));
            assertThat(lift.getCurrentFloor(), is(2));
        }

        @Test
        void shouldNotMoveIfLiftIsNotWorking() {
            Lift brokenLift = new Lift(0, LiftStatus.NOT_WORKING);

            LiftStatus finalLiftStatus = brokenLift.requestFloor(2);

            assertThat(finalLiftStatus, is(LiftStatus.NOT_WORKING));
            assertThat(lift.getCurrentFloor(), is(0));
        }
    }
}