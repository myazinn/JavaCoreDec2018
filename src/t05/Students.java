package t05;

import t05.course.Course;
import t05.student.Student;

/**
 * Nothing special. Just creates some students for the demonstration.
 */
class Students {
    private Student[] students = new Student[4];

    Students(){
        create();
        fill();
    }

    Student[] getStudents() {
        return students;
    }

    private void create() {
        students[0] = new Student("David");
        students[1] = new Student("Mike");
        students[2] = new Student("Ann");
        students[3] = new Student("Rebecca");
    }

    private void fill() {
        students[0].addCourse(Course.ENGLISH, 3);
        students[0].addCourse(Course.RUSSIAN, 3);
        students[0].addCourse(Course.MATH, 4.5);

        students[1].addCourse(Course.MATH, 4.9);
        students[1].addCourse(Course.HISTORY, 5);
        students[1].addCourse(Course.RUSSIAN, 4);
        students[1].addCourse(Course.ENGLISH, 2);

        students[2].addCourse(Course.PHYSICS, 4.9);
        students[2].addCourse(Course.RUSSIAN, 5);
        students[2].addCourse(Course.CHEMISTRY, 4.9);

        students[3].addCourse(Course.MATH, 2.5);
        students[3].addCourse(Course.HISTORY, 4);
        students[3].addCourse(Course.PHYSICS, 2.8);
        students[3].addCourse(Course.CHEMISTRY, 3.1);
    }
}
