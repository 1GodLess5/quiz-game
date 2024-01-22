import java.util.*;

public class Question {
    private final String question;
    private List<Answer> answers = new ArrayList<>();
    private final Set<String> correctAnswers = new HashSet<>();
    private boolean isSingleChoice;


    public Question(String topic, String question, List<Answer> answers){
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
