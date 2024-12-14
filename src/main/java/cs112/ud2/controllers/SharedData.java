package cs112.ud2.controllers;

import cs112.ud2.models.Student;
import cs112.ud2.models.Teacher;

import java.util.ArrayList;
import java.util.List;

public class SharedData {
    private static List<Student> studentList = new ArrayList<>();

    public static List<Student> getStudentList() {
        return studentList;
    }

    public static void addStudent(Student student) {
        studentList.add(student);
        System.out.println("SUCCESSFUL ADD");
    }


    private static List<Teacher> teacherList = new ArrayList<>();

    public static List<Teacher> getTeacherList() {
        return teacherList;
    }

    public static void addTeacher(Teacher teacher) {
        teacherList.add(teacher);
        System.out.println("SUCCESSFUL ADD");
    }
}
