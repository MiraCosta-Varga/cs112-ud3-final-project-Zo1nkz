package cs112.ud2.models;

import java.util.List;

public class EnglishGrades extends Grades {
    public EnglishGrades() {
        super();
    }

    public void addScore(double score) {
        if (score >= 0 && score <= 100) {
            Englishscores.add(score);
        } else {
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }
    }

    public double getAverage(){
        double sum = 0;
        for (double grade : Englishscores) {
            sum += grade;
        }
        return Englishscores.size() > 0 ? sum / Englishscores.size() : 0;
    }

    public List<Double> getGrades(){
        return Englishscores;
    }

    @Override
    public String toString() {
        return "This student's performance in English is reflected by an average of " + getAverage() + ".";
    }
}
