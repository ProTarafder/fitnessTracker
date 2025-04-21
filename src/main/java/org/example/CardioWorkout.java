package org.example;

import java.util.Date;

public class CardioWorkout extends Workout {
    private int durationMinutes;

    public CardioWorkout(String excerciseName, Date workoutDate, int durationMinutes) {
        super(excerciseName, workoutDate);
        this.durationMinutes = durationMinutes;
    }

    @Override
    public void logWorkout(String session){
        //TODO: Log cardio
    }

    @Override
    public double calculateCaloriesBurned(){
        //TODO: Estimate calories burned for cardio
        return 0;
    }
}
