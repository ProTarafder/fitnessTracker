package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataManager {

    public void saveWorkouts(List<Workout> workouts, String filename) {
        if (workouts == null || workouts.isEmpty()) {
            System.out.println("No workouts were found in the given filename");
            return;
        }

        try (FileWriter writer = new FileWriter(filename)) {
            for (Workout workout : workouts) {
                writer.write(workout.toString());
                writer.append("\n");
            }
            System.out.println("Saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error while saving workouts");
            throw new RuntimeException(e);
        }
    }

    public List<Workout> loadUser(String filename) {
        List<Workout> workouts = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("report.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(",");
                if (split.length >= 3) {
                    String name = split[0];
                    String type = split[1];
                    Date date = new Date(split[2]);

                    if (type.equals("Cardio".equalsIgnoreCase(type))) {
                        workouts.add(new CardioWorkout(name, date, 30)); //Default 30 mins
                    } else if (type.equals("Strength".equalsIgnoreCase(type))) {
                        workouts.add(new StrengthWorkout(name, date, 3, 12)); //Default sets and reps
                    }
                }
            }
            System.out.println("Loaded from file");
        } catch (
                FileNotFoundException e) {
            System.out.println("File not found");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error reading report file");
            throw new RuntimeException(e);
        }
        return workouts;
    }
}
