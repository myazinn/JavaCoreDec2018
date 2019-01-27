package t05.student;

import org.junit.jupiter.api.Test;
import t05.course.Course;
import t05.course.CourseNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student david = new Student("David");

    @Test
    void addAndGetTest() {
        david.addCourse(Course.CHEMISTRY, 4);
        david.addCourse(Course.ENGLISH, 4);
        david.addCourse(Course.HISTORY, 3.4);

        try {
            assertEquals(3, david.getScore(Course.HISTORY).getScore());
            assertEquals(4, david.getScore(Course.ENGLISH).getScore());
            assertEquals(4.0, david.getScore(Course.CHEMISTRY).getScore());
        } catch (CourseNotFoundException exc) {
            System.out.println(exc);
        }
    }
}