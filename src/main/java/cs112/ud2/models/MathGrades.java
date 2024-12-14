package cs112.ud2.models;

import java.util.List;

public class MathGrades extends Grades{
    public MathGrades() {
        super();
    }

    public void addScore(double score) {
        if (score >= 0 && score <= 100) {
            Mathscores.add(score);
        } else {
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }
    }

    public double getAverage(){
        double sum = 0;
        for (double grade : Mathscores) {
            sum += grade;
        }
        return Mathscores.size() > 0 ? sum / Mathscores.size() : 0;
    }

    public List<Double> getGrades(){
        return Mathscores;
    }

    @Override
    public String toString() {
        return "This student's performance in math is reflected by an average of " + getAverage() + ".";
    }
}
