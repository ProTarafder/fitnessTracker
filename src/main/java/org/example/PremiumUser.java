package org.example;
import java.io.IOException;
import java.util.Calendar;

public class PremiumUser extends FreeUser implements Trackable{

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
    public void viewProgressReport(){
        System.out.println("Progress report for " + username);
        for (Workout w : workoutHistory) {
            System.out.println("- " + w.excerciseName + ", " + w.calculateCaloriesBurned() + " kcal");
        }
        System.out.println("Total calories burned: " + totalCalories);
    }

    @Override
    public void generateReport(){
        double totalCalories = workoutHistory.stream()
                .mapToDouble(Workout::calculateCaloriesBurned)
                .sum();
        System.out.println("Total calories burned: " + totalCalories);
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
    public boolean isOnTrackForGoal(){
        System.out.println("Tracking goal progress for " + username);
        return true;
    }

    public void exportReport() throws IOException {
        //placeholder for file writing later on
    }
}
