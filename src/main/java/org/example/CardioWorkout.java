package org.example;

import java.util.Date;

public class CardioWorkout extends Workout {
    private int durationMinutes;

    public CardioWorkout(String excerciseName, Date workoutDate, int durationMinutes) {
        super(excerciseName, workoutDate);
        if(durationMinutes < 0) throw new IllegalArgumentException("Duration must be positive");
        this.durationMinutes = durationMinutes;
    }

    @Override
    public void logWorkout(String session){
        System.out.println("Logged the cardio workout: " + session);
    }

    @Override
    public double calculateCaloriesBurned(){
        return durationMinutes * 6.5; //6.5 is currently a placeholder value
    }

    @Override
    public String getType() {
        return "Cardio Workout";
    }
}
