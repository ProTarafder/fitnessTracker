package org.example;

public interface Trackable {
    void generateReport();
    //TODO: Generate a detailed analytics report
    String generateMonthlyReport(int month, int year);
    //TODO: Summarize the workouts for each month
}
