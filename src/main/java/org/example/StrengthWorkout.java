package org.example;

import java.util.Date;

public class StrengthWorkout extends Workout {
    private int sets;
    private int repsPerSet;

    public StrengthWorkout(String excerciseName, Date workoutDate, int sets, int repsPerSet) {
        super(excerciseName, workoutDate);
        this.sets = sets;
        this.repsPerSet = repsPerSet;
    }

    @Override
    public void logWorkout(String session){
        //TODO: Log strength session
    }

    @Override
    public double calculateCaloriesBurned(){
        //TODO: Calculate calories burned during workout
        return 0;
    }
}
