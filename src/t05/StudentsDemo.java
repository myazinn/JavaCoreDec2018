package t05;

import t05.course.Course;
import t05.student.Student;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentsDemo {
    public static void main(String[] args) {
        Student[] students = new Students().getStudents();

        for (Student student: students) {
            System.out.println(student.getName() + "'s courses and scores");
            student.showScores();
            System.out.println();
        }

        Course course = Course.MATH;
        System.out.println("Students that on " + course.toString().toLowerCase() + " course");
        Arrays.stream(onCourse(course, students)).forEach(student -> System.out.println(student.getName()));
    }

    private static Student[] onCourse(Course course, Student[] students) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.onCourse(course)) {
                result.add(student);
            }
        }
        return result.toArray(Student[]::new);
    }
}
