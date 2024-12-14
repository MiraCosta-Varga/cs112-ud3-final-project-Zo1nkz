package cs112.ud2.models;

import java.util.ArrayList;
import java.util.List;

public abstract class Grades {
    //instance variables
    protected ArrayList<Double> Mathscores;
    protected ArrayList<Double> Englishscores;

    //constructor for the scores list
    public Grades(){
        this.Mathscores = new ArrayList<>();
        this.Englishscores = new ArrayList<>();
    }

    //add a grade
    public abstract void addScore(double score);

    //get avg score
    public abstract double getAverage();

    public abstract List<Double> getGrades();

    @Override
    public String toString() {
        return "GPA: " + getAverage();
    }
}
