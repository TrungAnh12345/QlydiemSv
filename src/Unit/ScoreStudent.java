package Unit;

import Runsystem.Main;

import java.io.Serializable;
import java.util.Arrays;

public class ScoreStudent implements Serializable {


    private Student student;
   private ScoreOfSubject [] scoreOfSubjects;

    public Student getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return "ScoreStudent{" +
                "student=" + student +
                ", scoreOfSubjects=" + Arrays.toString(scoreOfSubjects) +
                '}';
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ScoreOfSubject[] getScoreOfSubjects() {
        return scoreOfSubjects;
    }

    public void setScoreOfSubjects(ScoreOfSubject[] scoreOfSubjects) {
        this.scoreOfSubjects = scoreOfSubjects;
    }

    public ScoreStudent() {
    }

    public ScoreStudent(Student student, ScoreOfSubject[] scoreOfSubjects) {
        this.student = student;
        this.scoreOfSubjects = scoreOfSubjects;
    }
 // totalscore =
    public float totalScore(){
        float score = 0;
        float totalScore = 0;
        float totalDhvt = 0;
        for (int i = 0; i < scoreOfSubjects.length; i++){
            if(Main.scoreStudents[i] == null){
                continue;
            }
            score = (float)scoreOfSubjects[i].getScore() * scoreOfSubjects[i].getSubject().getDvht();
            totalDhvt += (float)scoreOfSubjects[i].getSubject().getDvht();
            totalScore += score ;
        }
        return (float)totalScore / totalDhvt;
    }
}
