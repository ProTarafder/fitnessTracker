package org.example;

import java.util.Calendar;
import java.util.Date;

public abstract class Workout implements Comparable<Workout> {
    protected String excerciseName;
    protected Date workoutDate;

    public Workout(String excerciseName, Date workoutDate) {
        if (excerciseName == null || excerciseName.isEmpty()) {
            throw new IllegalArgumentException("Exercise name cannot be null or empty");
        }
        if (workoutDate == null) {
            throw new IllegalArgumentException("Workout date cannot be null");
        }
        this.excerciseName = excerciseName;
        this.workoutDate = workoutDate;
    }

    public abstract void logWorkout(String session);

    public abstract double calculateCaloriesBurned();

    public abstract String getType();

    public Date getDate() {
        return workoutDate;
    }

    @Override
    public int compareTo(Workout o) {
        return Double.compare(this.calculateCaloriesBurned(), o.calculateCaloriesBurned());
    }

    @Override
    public String toString() {
        return excerciseName + ", " + getType() + ", " + workoutDate;
    }
}
