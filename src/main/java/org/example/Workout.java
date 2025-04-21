package org.example;

import java.util.Date;

public abstract class Workout implements Comparable<Workout>{
    protected String excerciseName;
    protected Date workoutDate;

    public Workout(String excerciseName, Date workoutDate) {
        this.excerciseName = excerciseName;
        this.workoutDate = workoutDate;
    }

    public abstract void logWorkout(String session);
    //TODO: Log the session
    public abstract double calculateCaloriesBurned();
    //TODO: Calculate calories

    @Override
    public int compareTo(Workout o) {
        return Double.compare(this.calculateCaloriesBurned(), o.calculateCaloriesBurned());
    }
}
