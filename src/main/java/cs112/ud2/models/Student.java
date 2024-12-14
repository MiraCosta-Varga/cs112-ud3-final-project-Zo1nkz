package cs112.ud2.models;

import java.util.ArrayList;
//Represents one student

public class Student {

    // instance variables
    private String name, race;
    private int gradeLevel;
    private Grades mathGrades;
    private Grades englishGrades;

    // default variables
    public static final String DEF_NAME = "JOHN DOE", DEF_RACE = "CAUCASIAN";
    public static final int DEF_GRADELEVEL = 12;

    // Most common single races found in schools
    // Source: https://nces.ed.gov/programs/coe/pdf/2024/cge_508c.pdf
    public static final String[] raceList = { "White", "Hispanic", "Black", "Asian", "American Indian/Alaska Native",
            "Pacific Islander" };

    // Constructors
    public Student() {
        this.setAll(DEF_NAME, DEF_RACE, DEF_GRADELEVEL);
    }

    public Student(String name, String race, int gradeLevel, String MathScores, String EnglishScores) {
        this.setAll(name, race, gradeLevel);

        String[] mathScoresStr = MathScores.split(",");
        for(String scoreStr : mathScoresStr) {
            double mathScoreDouble = Double.parseDouble(scoreStr);
            addMathGrade(mathScoreDouble);
        }

        String[] englishScoresStr = EnglishScores.split(",");
        for(String scoreStr2 : englishScoresStr) {
            double englishScoreDouble = Double.parseDouble(scoreStr2);
            addEnglishGrade(englishScoreDouble);
        }
    }

    public Student(Student o) {
        if (o == null) {
            throw new IllegalArgumentException("Cannot copy null obect in Student copy constructor");
        } else {
            this.setAll(o.name, o.race, o.gradeLevel);
            for (double grade : o.mathGrades.getGrades()) {
                addMathGrade(grade);  // Add the same grades to the new MathGrades object
            }
            for (double grade : o.englishGrades.getGrades()) {
                addEnglishGrade(grade);  // Add the same grades to the new MathGrades object
            }
        }
    }

    // Setters
    public boolean setName(String name) {
        if (name != null && name.length() > 0) {
            this.name = name;
            return true;
        } else {
            return false;
        }
    }

    public boolean setRace(String race) {
        if (Student.isInArray(raceList, race)) {
            this.race = race;
            return true;
        } else {
            return false;
        }
    }

    public boolean setGradeLevel(int gradeLevel) {
        if (gradeLevel <= 12 && gradeLevel >= 9) {
            this.gradeLevel = gradeLevel;
            return true;
        } else {
            return false;
        }
    }

    public void addMathGrade(double grade){
        this.mathGrades.addScore(grade);
    }

    public void addEnglishGrade(double grade){
        this.englishGrades.addScore(grade);
    }

    public double getMathAverage() {
        return this.mathGrades.getAverage();
    }

    public double getEnglishAverage() {
        return this.englishGrades.getAverage();
    }

    public boolean setAll(String name, String race, int gradeLevel) {
        this.mathGrades = new MathGrades();
        this.englishGrades = new EnglishGrades();
        return this.setName(name) && this.setRace(race) && this.setGradeLevel(gradeLevel);

    }

    // Getters
    public String getName() {
        return this.name;
    }

    public String getRace() {
        return this.race;
    }

    public int getGradeLevel() {
        return this.gradeLevel;
    }

    // Equals & toString & other methods (that can potentially be used)
    @Override
    public String toString() {
        return this.name + " is " + this.race + " and they are grade level "
                + this.gradeLevel + "\nMath Grade: " + this.mathGrades.getAverage() + "\nTheir English grade is as follows: " + this.englishGrades.getAverage();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || (!(o instanceof Student))) {
            return false;
        }
        Student otherStudent = (Student) o;
        return this.name.equals(otherStudent.name) && this.race.equals(otherStudent.race)
                && this.gradeLevel == otherStudent.gradeLevel;
    }

    public static boolean isInArray(String[] values, String value) {
        if (values == null || value == null) {
            return false;
        }
        int location = 0;
        boolean isPresent = false;

        while (!isPresent && location < values.length) {
            isPresent = values[location].equals(value);
            location++;
        }

        return isPresent;
    }
}

