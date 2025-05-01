package org.example;

import java.util.Date;

public class StrengthWorkout extends Workout {
    private int sets;
    private int repsPerSet;

    public StrengthWorkout(String exerciseName, Date workoutDate, int sets, int repsPerSet) {
        super(exerciseName, workoutDate);
        if (sets < 0 || repsPerSet < 0) {
            throw new IllegalArgumentException("Sets and reps must be positive");
        }
        this.sets = sets;
        this.repsPerSet = repsPerSet;
    }

    @Override
    public void logWorkout(String session){
        System.out.println("Logged strength workout: " + session);
    }

    @Override
    public double calculateCaloriesBurned(){
        return sets * repsPerSet * 0.5; //0.5 is currently a placeholder value
    }

    @Override
    public String getType() {
        return "Strength Workout";
    }
}
