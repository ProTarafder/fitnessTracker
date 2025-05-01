package org.example;

public interface Trackable {
    /**
     *
     */
    void generateReport();

    /**
     *
     * @param month
     * @param year
     * @return
     */
    String generateMonthlyReport(int month, int year);

    /**
     *
     */
    void viewProgressReport();

    /**
     *
     * @return
     */
    boolean isOnTrackForGoal();
}
