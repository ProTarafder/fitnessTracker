package org.example;

public class FreeUser extends User {
    public FreeUser(String username) {
        super(username);
    }

    @Override
    public void setGoal(String goal) {
        //TODO: Save user's goal (Free)
    }

    @Override
    public void viewProgressReport(){
        //TODO: Limiting the access of reports
    }

    @Override
    public boolean isOnTrackForGoal(){
        //TODO: Restrict this feature for user
        return false;
    }
}
