import java.util.Map;

public class Answer {
    private final String answerText;
    private final int answerOrder;
    private final boolean isCorrect;

    public Answer(String answerText, int answerOrder, boolean isCorrect) {
        this.answerText = answerText;
        this.answerOrder = answerOrder;
        this.isCorrect = isCorrect;
    }

    public String getAnswerText() {
        return answerText;
    }

    public int getAnswerOrder() {
        return answerOrder;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
