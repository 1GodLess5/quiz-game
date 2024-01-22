import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadFile {
    private final static String fileName = "src/main/java/questions.txt";

    public static List<Quiz> read(){
        List<Quiz> quizzes = new ArrayList<>();
        String oldTopic = "General Knowledge";
        int quizOrder = 0;

        try (BufferedReader scanner = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = scanner.readLine()) != null) {
                String[] parts = line.split("[-!]");

                List<Question> questions = new ArrayList<>();
                List<Answer> answers = new ArrayList<>();

                String questionTopic = parts[0];
                String question = parts[1];

                for (int i = 2; i < 6; i++){
                    boolean isCorrect = false;
                    String answerText = parts[i];

                    for (int j = 6; j < parts.length; j++){
                        if (parts[j].equals(answerText)){
                            isCorrect = true;
                        }
                    }

                    Answer answer = new Answer(answerText, i - 2, isCorrect);
                    answers.add(answer);
                }
                Question questionObject = new Question(question, answers);
                questions.add(questionObject);

                if (!oldTopic.equals(questionTopic)){
                    Quiz quiz = new Quiz(oldTopic, questions, quizOrder);
                    quizzes.add(quiz);
                    oldTopic = questionTopic;
                    quizOrder++;
                }
            }
        } catch (IOException e) {
            System.out.println("Oops, something went wrong.");
        }

        return quizzes;
    }
}
