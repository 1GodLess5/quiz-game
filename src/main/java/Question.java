import java.util.*;

public class Question {
    private String question;
    private List<Answer> answers;
    private final Set<String> correctAnswers = new HashSet<>();


    public Question(String question, List<Answer> answers){
        this.question = question;
        this.answers = answers;
    }

    public String getQuestion() {
        return this.question;
    }

    public List<Answer> getAnswers() {
        return this.answers;
    }

    public boolean isSingleChoice() {
        int count = 0;
        for (Answer answer : this.answers){
            if (answer.isCorrect()){
                count++;
            }
        }
        return count == 1;
    }

    public Set<String> getCorrectAnswers() {
        for (Answer answer : this.answers){
            if (answer.isCorrect()){
                this.correctAnswers.add(answer.getAnswerText());
            }
        }
        return this.correctAnswers;
    }
}
