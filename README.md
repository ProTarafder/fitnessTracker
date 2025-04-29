## fitnessTracker
Protiti Tarafder 
6236037
Data Structures and Object Oriented Programming

## 1.Scenario
**Fitness Tracker System** is an application where users could monitor their workouts, nutrition and fitness goals. They can log anything from excercises, calorie intake (meals), set up fitness goals, and view their progress. It is used to manage their fitness routine and health. There is also an advanced user, the premium user, where they have access to more advanced analysis (monthly reports and
goal comparisons).

## 2-3.Functionalities & Expected Output

Based on the type of user you are (premium user or free user), the amount of services will change.

**1.Free User**

i.Track workout (sets, reps and duration)

ii.Track meals (calories)

iii.Set personal fitness goals

iv.Limited view of accomplished workout (when logged)



**2.Premium User (Has all the FreeUser services and:)**

i.Monthly reports (summary of burned calories and tracked amount of times they worked out)

ii.Goal comparisons (tracks if the user is meeting their goal using percentage e.g. "You are 30% toward your goal of burning 1000 kcal this month")

iii.Breakdown of what type of workout has been accomplished (cardio, strength, etc.)

iv.Export their reports(CSV or text)


**3.Admin** (not an actual class though, just implementation to make sure there is an option to upgrade a user)

i.Ugrade the user to premium

ii.Manage user's data


This project will demonstrate:

1. OOP:
   
   -class hiercarchy: User, Workout
   
   -Polymorphism
   
   -Interface: Trackable
   
2. Data structures:
   
   -List for history
   
   -Map for reports
   
   -Comparator/Comparable for sorting
   
3. File I/O: For saving reports

4. Exception Handling: Avoid invalid data (example: negative calories)
   
5. Stream and Lambda Processing: For workout trends (Type of workout+calories burned summary) (Premium User)
    
6. JUnit Testing


## 4.Class Hiearchy

**User** (Abstract)

-FreeUser

-PremiumUser (implements Trackable)

**Workout** (Abstract)

-CardioWorkout

-StrengthWorkout

## 5.Interface

**Trackable**

-generateReport(): Detailed performance analytics

-generateMonthlyReport(month, year) : Calories and workout summaries

-For PremiumUser

## 6.Polymorphism
**Method Overriding**

-calculateCaloriesBurned() : different implementation in CardioWorkout and StrengthWorkout


**Method Overloading**

-logWorkout(String name) and logWorkout(String name, int duration)

## 7.Text I/O

Class **Data Manager**

Save user profile to user.csv and report logs to workouts.txt


## 8.Comparable and Comparator

Workout implements Comparable<Workout> -> sort burned calories

WorkoutDateComparator implements Comparator<Workout> -> sort by date of workout


## 9.Implementation Plan for Del. 2 (50%)

i.Fully Implement classes: User, FreeUser, PremiumUser, Workout and its  associated methods as well as Interface Trackable

ii.Partial implementation of Comparator and Comparable, class CardioWorkout and StrengthWorkout and DataManager as well as the user interaction interface in main method

iii. Have the logic of the partially implemented classes and methods written (in main have the implementation of the working Free+Premium User logging)


