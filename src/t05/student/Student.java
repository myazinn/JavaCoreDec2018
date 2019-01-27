package t05.student;

import t05.course.Course;
import t05.course.CourseNotFoundException;

import java.util.HashMap;
import java.util.Map;

/**
 * Describes students
 */
public class Student {
    private String name;
    private Map<Course, Score> courses = new HashMap<>();

    public Student(String studentName){
        name = studentName;
    }

    public String getName() {
        return name;
    }

    /**
     * Allows to add a course with a certain score. Converts score to an appropriate type to avoid errors.
     * @param course Student course (MATH, PHYSICS, etc)
     * @param score Student score for this course
     * @param <T> Integer or Double, depends on a certain course
     */
    public <T extends Number> void addCourse(Course course, T score) {
       if (course.isRealScore()) {
            courses.put(course, new Score<>(score.doubleValue()));
        } else {
            courses.put(course, new Score<>(score.intValue()));
        }
    }

    /**
     * Allows to get student score for certain course
     * @param course Student course (MATH, PHYSICS, etc)
     * @return Score for the course
     * (should be unpacked using getScore() with returning type depending on a course)
     * @throws CourseNotFoundException throws if someone tries to get student score
     * on a course that student does not attend
     */
    public Score getScore (Course course) throws CourseNotFoundException {
        if (courses.containsKey(course)) {
            return courses.get(course);
        } else {
            throw new CourseNotFoundException(course);
        }
    }

    /**
     * Check if student attend to certain course
     * @param course Student course (MATH, PHYSICS, etc)
     * @return True if attend, false otherwise.
     */
    public boolean onCourse(Course course) {
        return courses.containsKey(course);
    }

    /**
     * shows all scores for all courses sorted by scores in decreasing order
     */
    public void showScores() {
        Map<Course, Score> sortedCourses = MapSort.decreaseOrder(courses);

        sortedCourses.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
