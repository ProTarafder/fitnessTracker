package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FreeUser extends User {
    protected List<Workout> workoutHistory = new ArrayList<>();
    protected double totalCalories = 0.0;

    public FreeUser(String username) {
        super(username);
    }

    @Override
    public void setGoal(String goal) {
        this.goal = goal;
        System.out.println(username + "'s goal set to " + goal);
    }

    @Override
    public void viewProgressReport() {
        System.out.println(username + "'s progress report");
        System.out.println("Total Calories: " + totalCalories);
        System.out.println("Amount of Logged Workouts: " + workoutHistory.size());
        System.out.println("Advanced progress report is a Premium User feature.");
    }

    @Override
    public boolean isOnTrackForGoal() {
        System.out.println("Goal tracking is a Premium User feature.");
        return false;
    }

    public void logWorkout(Workout workout) {
        if (workout == null) throw new IllegalArgumentException("Workout cannot be null");
        workoutHistory.add(workout);
        totalCalories += workout.calculateCaloriesBurned();
    }

    public void logWorkout(String name) {
        logWorkout(new CardioWorkout(name, new Date(), 30));
    }

    public void logWorkout(String name, int duration) {
        logWorkout(new CardioWorkout(name, new Date(), duration));
    }

    public List<Workout> getWorkoutHistory() {
        return workoutHistory;
    }

    public double getTotalCalories() {
        return totalCalories;
    }
}
