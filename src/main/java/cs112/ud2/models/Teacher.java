package cs112.ud2.models;

public class Teacher {

    // instance variables
    private String name, race, subject;
    private int salary;
    private String[] courses;

    // default variables
    public static final String DEF_NAME = "JOHN DOE", DEF_RACE = "CAUCASIAN", DEF_SUBJECT = "LINEAR ALGEBRA";
    public static final int DEF_SALARY = 72000;

    // Most common single races found in schools
    // Source: https://nces.ed.gov/programs/coe/pdf/2024/cge_508c.pdf
    public static final String[] raceList = { "White", "Hispanic", "Black", "Asian", "American Indian/Alaska Native",
            "Pacific Islander" };

    // Constructors
    public Teacher() {
        this.setAll(DEF_NAME, DEF_RACE, DEF_SUBJECT, DEF_SALARY);
    }

    public Teacher(String name, String race, String subject, int salary, String coursesList) {
        this.setAll(name, race, subject, salary);
        this.courses = coursesList.split(",");

    }

    public Teacher(Teacher o) {
        if (o == null) {
            throw new IllegalArgumentException("Cannot copy null obect in Student copy constructor");
        } else {
            this.setAll(o.name,o.race,o.subject,o.salary);
            this.courses = o.courses != null ? o.courses.clone() : new String[0];
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

    public boolean setSubject(String subject) {
        if (subject != null && subject.length() > 0) {
            this.subject = subject;
            return true;
        } else {
            return false;
        }
    }

    public boolean setSalary(int salary) throws InvalidSalaryException {
        if (salary < 0) {
            throw new InvalidSalaryException("Salary cannot be negative: " + salary);
        } else {
            this.salary = salary;
            return true;
        }
    }

    public boolean setCourses(String[] courses) {
        if(courses != null){
            this.courses = courses;
            return true;
        }
        return false;
    }

    public boolean setAll(String name, String race, String subject, int salary) {
        boolean result = this.setName(name) && this.setRace(race) && this.setSubject(subject);
        try {
            result = result && this.setSalary(salary);
        } catch (InvalidSalaryException e) {
            System.out.println("Failed to set salary: " + e.getMessage());
            result = false; // Indicate failure in case of exception
        }
        return result;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public String getRace() {
        return this.race;
    }

    public int getSalary(){
        return this.salary;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getCourses() {
        // Convert the courses array to a comma-separated string
        return String.join(", ", this.courses);
    }


    // Equals & toString & other methods (that can potentially be used)
    @Override
    public String toString() {
        StringBuilder coursesList = new StringBuilder();
        for(String course : courses){
            coursesList.append(course).append(", ");
        }
        return this.name + " is " + this.race + " and their primary subject is " + this.subject + "\n" +
                "Courses taught: " + coursesList.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || (!(o instanceof Teacher))) {
            return false;
        }
        Teacher otherTeacher = (Teacher) o;
        return this.name.equals(otherTeacher.name) && this.race.equals(otherTeacher.race)
                && this.subject.equals(otherTeacher.subject);
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
