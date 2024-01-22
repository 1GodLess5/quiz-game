import java.util.HashMap;
import java.util.HashSet;

public class Questions {
    private String topic;
    private String question;
    private HashMap<Integer, String> answers = new HashMap<>();
    private int numberOfCorrectAnswers;
    private HashSet<String> correctAnswers = new HashSet<>();

    public Questions(String topic, String question, HashMap<Integer, String> answers, int numberOfCorrectAnswers, HashSet<String> correctAnswers){
        this.topic = topic;
        this.question = question;
        this.answers = answers;
        this.numberOfCorrectAnswers = numberOfCorrectAnswers;
        this.correctAnswers = correctAnswers;
    }

    public String getTopic(){
        return this.topic;
    }

    public String getQuestion() {
        return this.question;
    }

    public HashMap<Integer, String> getAnswers() {
        return this.answers;
    }

    public int getNumberOfCorrectAnswers() {
        return this.numberOfCorrectAnswers;
    }

    public HashSet<String> getCorrectAnswers() {
        return this.correctAnswers;
    }
}
