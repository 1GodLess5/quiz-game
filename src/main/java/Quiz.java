import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private final String quizTopic;
    private List<Question> questions;
    private final int quizOrder;

    public Quiz(String quizTopic, List<Question> questions, int quizOrder) {
        this.quizTopic = quizTopic;
        this.questions = questions;
        this.quizOrder = quizOrder;
    }

    public String getQuizTopic() {
        return quizTopic;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public int getQuizOrder() {
        return quizOrder;
    }
}
