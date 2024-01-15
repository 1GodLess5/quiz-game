import java.util.HashSet;

public class Questions {
    private String question;
    private HashSet<String> answers = new HashSet<>();
    private int numberOfCorrectAnswers;
    private HashSet<String> correctAnswers = new HashSet<>();

    public Questions(String question, HashSet<String> answers, int numberOfCorrectAnswers, HashSet<String> correctAnswers){
        this.question = question;
        this.answers = answers;
        this.numberOfCorrectAnswers = numberOfCorrectAnswers;
        this.correctAnswers = correctAnswers;
    }

    public String getQuestion() {
        return this.question;
    }

    public HashSet<String> getAnswers() {
        return this.answers;
    }

    public int getNumberOfCorrectAnswers() {
        return this.numberOfCorrectAnswers;
    }

    public HashSet<String> getCorrectAnswers() {
        return this.correctAnswers;
    }
}
