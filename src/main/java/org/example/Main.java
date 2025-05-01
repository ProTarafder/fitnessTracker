package org.example;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        FreeUser user1 = new FreeUser("pro");
        PremiumUser user2 = new PremiumUser("bob");

        user1.setGoal("Burn 200 kcal");
        user1.logWorkout(new CardioWorkout("Jogging", new Date(),20));
        user1.logWorkout("Biking", 25);

        user2.setGoal("Burn 1500 kcal by next month");
        user2.logWorkout(new StrengthWorkout("Bench Press", new Date(),3,12));
        user2.logWorkout("StairMaster", 35);

        System.out.println("\n FREE USER");
        user1.viewProgressReport();
        user1.isOnTrackForGoal();
        System.out.println("Logged workouts:");
        user1.workoutHistory.forEach(w -> System.out.println(w));

        System.out.println("\n PREMIUM USER");
        user2.viewProgressReport();
        System.out.println(user2.generateMonthlyReport(05, 2026));
        user2.isOnTrackForGoal();
        user2.generateReport();
    }
}