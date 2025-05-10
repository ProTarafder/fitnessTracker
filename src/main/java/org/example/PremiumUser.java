package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class PremiumUser extends FreeUser implements Trackable {

    public PremiumUser(String username) {
        super(username);
    }

    @Override
    public void setGoal(String goal) {
        if (goal == null || goal.isEmpty()) {
            throw new IllegalArgumentException("Goal cannot be empty");
        }
        this.goal = goal;
        System.out.println(username + " set goal to " + goal);
    }

    @Override
    public void viewProgressReport() {
        System.out.println("Progress report for " + username);
        for (Workout w : workoutHistory) {
            System.out.println("- " + w.excerciseName + ", " + w.workoutDate.toString() + ", " + w.calculateCaloriesBurned() + " kcal");
        }
    }

    @Override
    public void generateReport() {
        System.out.println("Generating report for " + username);
        double totalCalories = workoutHistory.stream()
                .mapToDouble(Workout::calculateCaloriesBurned)
                .sum();
        System.out.println("Total calories burned: " + totalCalories);
        System.out.println("Total workouts" + workoutHistory.size());
    }

    @Override
    public String generateMonthlyReport(int month, int year) {
        double totalCalories = workoutHistory.stream()
                .filter(w -> {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(w.getDate());
                    return cal.get(Calendar.MONTH) + 1 == month && cal.get(Calendar.YEAR) == year;
                })
                .mapToDouble(Workout::calculateCaloriesBurned)
                .sum();
        return String.format("%s burn %.2f kcal in %02d/%d", username, totalCalories, year, month);
    }

    @Override
    public boolean isOnTrackForGoal() {
        System.out.println("Tracking goal progress for " + username);
        return true;
    }

    public void exportReport(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write("Excercise, Date, Calories");
            for (Workout w : workoutHistory) {
                System.out.println("- " + w.excerciseName + ", " + w.workoutDate.toString() + ", " + w.calculateCaloriesBurned());
            }
            System.out.println("Exported to " + filename);
        } catch (IOException e) {
            System.out.println("Error exporting " + filename);
            throw new RuntimeException(e);
        }

    }

    public void addWorkout(Workout workout) {
        if (workout == null || workout.workoutDate == null) {
            throw new IllegalArgumentException("Workout or date cannot be null");
        }
        workoutHistory.add(workout);
    }
}
