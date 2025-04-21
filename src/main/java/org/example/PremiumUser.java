package org.example;
import java.util.ArrayList;
import java.util.List;

public class PremiumUser extends User implements Trackable{
    private List<Workout> workoutHistory = new ArrayList<>();

    public PremiumUser(String username) {
        super(username);
    }

    public void addWorkout(Workout workout) {
        //TODO: Add to history
    }

    @Override
    public void setGoal(String goal) {
        //TODO: Save premium user goal
    }

    @Override
    public void viewProgressReport(){
        //TODO: Display detailed progress
    }

    @Override
    public void generateReport(){
        //TODO: Implement detailed report
    }

    @Override
    public String generateMonthlyReport(int month, int year) {
        //TODO: Calculate the calories burned and return it
        return null;
    }

    @Override
    public boolean isOnTrackForGoal(){
        //TODO: Compare user progress with goal
        return false;
    }
}
