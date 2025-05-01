package org.example;

public interface Trackable {

    void generateReport();
    String generateMonthlyReport(int month, int year);
    void viewProgressReport();
    boolean isOnTrackForGoal();
}
