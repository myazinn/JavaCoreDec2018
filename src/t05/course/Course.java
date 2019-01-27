package t05.course;

/**
 * Possible disciplines. If realScore true, score of the course should be real number (Integer otherwise).
 */
public enum Course {
    ENGLISH(false),
    HISTORY(false),
    PHYSICS(true),
    MATH(true),
    CHEMISTRY(true),
    RUSSIAN(false);

    private boolean realScore;

    Course(boolean realScore) {
        this.realScore = realScore;
    }

    public boolean isRealScore() {
        return realScore;
    }
}
