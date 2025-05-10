package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class FitnessTrackerTest {
    FreeUser user = new FreeUser("testing");
    PremiumUser userr = new PremiumUser("tester");

    //FREE USER
    @Test
    public void testFreeUserLogWorkout() {
        user.logWorkout("Running", 15);
        Assertions.assertEquals(1, user.workoutHistory.size());
    }

    @Test
    public void testGoal() {
        user.setGoal("Goal");
        Assertions.assertEquals("Goal", user.goal);

        userr.setGoal("Goal 2");
        Assertions.assertEquals("Goal 2", userr.goal);
    }

    //PREMIUM USER
    @Test
    public void testPremiumUserReportAndTracking() {
        userr.setGoal("Burn 200 kcal");
        userr.logWorkout(new CardioWorkout("Jog", new Date(), 35)); //35 * 6.5 = 227.5
        Assertions.assertTrue(user.isOnTrackForGoal());
    }

    @Test
    public void testPremiumUserGenerateReport() {
        userr.addWorkout(new CardioWorkout("Jog", new Date(), 35));
        userr.addWorkout(new StrengthWorkout("Push Up", new Date(), 4, 10));
        userr.generateReport();
        Assertions.assertEquals(2, userr.workoutHistory.size());
    }

    @Test
    public void testCalories() {
        Workout one = new CardioWorkout("Bike", new Date(), 20);
        Workout two = new StrengthWorkout("Deadlift", new Date(), 3, 10);
        Assertions.assertEquals(150.0, one.calculateCaloriesBurned(), 0.1);
        Assertions.assertEquals(20.0, two.calculateCaloriesBurned(), 0.1);
    }

    @Test
    public void testDataManager() {
        DataManager dm = new DataManager();
        List<Workout> workouts = new ArrayList<>();
        Date today = new Date(2023, 1, 1);
        workouts.add(new CardioWorkout("Jog", new Date(), 35));
        workouts.add(new StrengthWorkout("Push Up", new Date(), 4, 10));

        String filename = "test_workouts.txt";
        dm.saveWorkouts(workouts, filename);
        List<Workout> load = dm.loadUser(filename);

        Assertions.assertEquals(2, load.size());
        Assertions.assertEquals("Jog", load.get(0).excerciseName);
        Assertions.assertEquals("Jog", load.get(1).excerciseName);

        new File(filename).delete();
    }

    @Test
    public void testExportReport() {
        PremiumUser user = new PremiumUser("tester");
        Date now = new Date(2023, 1, 1);
        user.addWorkout(new CardioWorkout("Jog", new Date(), 35));
        user.addWorkout(new StrengthWorkout("Push Up", new Date(), 4, 10));

        String filename = "export_test.csv";
        user.exportReport(filename);

        File file = new File(filename);
        Assertions.assertTrue(file.exists());
        Assertions.assertTrue(file.length() > 0);

        List<String> lines = new ArrayList<>();
        try (BufferedReader fr = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = fr.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals("Excercise, Date, Calories", lines.get(0));
        Assertions.assertTrue(lines.size() >= 3);
        Assertions.assertTrue(file.delete());
    }
}
