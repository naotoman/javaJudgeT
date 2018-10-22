package judge;

public final class Status {

    public static final Status WRONG_ANSWER = new Status();

    private double score = 0.0;

    public static Status score(double score) {
        Status s = new Status();
        s.score = score;
        return s;
    }

    double getScore() {
        return score;
    }
}
