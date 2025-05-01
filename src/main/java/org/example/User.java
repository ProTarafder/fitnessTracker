package org.example;

/**
 * Abstract User class
 */
public abstract class User {
    protected String username;
    protected String goal;

    public User(String username) {
        this.username = username;
    }

    /**
     * Sets a fitness goal for user
     *
     * @param goal Goal description
     */
    public abstract void setGoal(String goal);

    /**
     * Display the progress report by user
     */
    public abstract void viewProgressReport();

    /**
     * Check if the user is on track
     *
     * @return true if on track, otherwise false
     */
    public abstract boolean isOnTrackForGoal();
}
