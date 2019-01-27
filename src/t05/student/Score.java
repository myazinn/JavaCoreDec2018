package t05.student;

/**
 * Allows to store values of different types in HashMap
 * @param <T> Integer or Double
 */
public class Score<T extends Number> implements Comparable<Score> {
    private T score;

    Score(T score) {
        this.score = score;
    }

    public T getScore() {
        return score;
    }

    public int compareTo(Score anotherScore) {
        return -Double.compare(score.doubleValue(), anotherScore.score.doubleValue());
    }

    public String toString() {
        return String.valueOf(score);
    }
}
