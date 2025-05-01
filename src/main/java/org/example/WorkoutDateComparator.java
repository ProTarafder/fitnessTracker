package org.example;

import java.util.Comparator;

public class WorkoutDateComparator implements Comparator<Workout> {
    @Override
    public int compare(Workout o1, Workout o2) {
        return o1.workoutDate.compareTo(o2.workoutDate);
    }
}
