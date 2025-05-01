package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Date;


public class FitnessTrackerTest {
    FreeUser user = new FreeUser("testing");
    PremiumUser userr = new PremiumUser("tester");

    @Test
    public void testFreeUserLogWorkout() {
        user.logWorkout("Running", 15);
        Assertions.assertEquals(1, user.workoutHistory.size());
    }

    @Test
    public void testGoal(){
        user.setGoal("Goal");
       Assertions.assertEquals("Goal", user.goal);

        userr.setGoal("Goal 2");
        Assertions.assertEquals("Goal 2", userr.goal);
    }

    @Test
    public void testPremiumUserReportAndTracking(){
        userr.setGoal("Burn 200 kcal");
        userr.logWorkout(new CardioWorkout("Jog", new Date(), 35)); //35 * 6.5 = 227.5
        Assertions.assertTrue(user.isOnTrackForGoal());
    }

    @Test
    public void testPremiumUserReport(){
        userr.logWorkout(new CardioWorkout("Jog", new Date(), 35));
        userr.logWorkout(new StrengthWorkout("Push Up", new Date(), 4, 10));
        userr.generateReport();
        Assertions.assertEquals(2, userr.workoutHistory.size());
    }
}
