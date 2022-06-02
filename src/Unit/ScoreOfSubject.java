package Unit;

public class ScoreOfSubject {

    private Subject subject;
    private float score;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "ScoreOfSubject{" +
                "subject=" + subject +
                ", score=" + score +
                '}';
    }

    public ScoreOfSubject(Subject subject, float score) {
        this.subject = subject;
        this.score = score;
    }


}
