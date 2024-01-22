import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadFile {
    private final static String fileName = "src/main/java/questions.txt";

    public static List<Quiz> read() {
        List<Quiz> quizzes = new ArrayList<>();
        int quizOrder = 0;

        try (BufferedReader scanner = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = scanner.readLine()) != null) {
                String[] parts = line.split("[-!]");
                String questionTopic = parts[0];
                String question = parts[1];

                List<Answer> answers = new ArrayList<>();

                for (int i = 2; i < 6; i++) {
                    String answerText = parts[i];
                    boolean isCorrect = false;

                    for (int j = 6; j < parts.length; j++) {
                        if (parts[j].equals(answerText)) {
                            isCorrect = true;
                            break;
                        }
                    }

                    Answer answer = new Answer(answerText, i - 1, isCorrect);
                    answers.add(answer);
                }

                Question questionObject = new Question(question, new ArrayList<>(answers));
                answers.clear();

                if (quizzes.isEmpty() || quizzes.get(quizzes.size() - 1).getQuestions().size() == 5) {
                    Quiz quiz = new Quiz(questionTopic, new ArrayList<>(Collections.singletonList(questionObject)), quizOrder);
                    quizzes.add(quiz);
                    quizOrder++;
                } else {
                    quizzes.get(quizzes.size() - 1).getQuestions().add(questionObject);
                }
            }
        } catch (IOException e) {
            System.out.println("Oops, something went wrong.");
        }

        return quizzes;
    }
}
