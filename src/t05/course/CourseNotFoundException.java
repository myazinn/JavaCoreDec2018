package t05.course;


/**
 * That exception throws if someone tries to get student score on a course that student does not attend.
 */
public class CourseNotFoundException extends Exception {

    private String course;

    public CourseNotFoundException(Course course) {
        this.course = course.toString().toLowerCase();
    }

    @Override
    public String toString() {
        return "That student does not attend " + course + " course";
    }
}
