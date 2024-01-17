import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class ReadFile {
    public static HashSet<Questions> read(){
        HashSet<Questions> questions = new HashSet<>();

        try (BufferedReader scanner = new BufferedReader(new FileReader("src/main/java/questions.txt"))) {
            String line;

            while ((line = scanner.readLine()) != null) {
                String[] parts = line.split("[\\-!]");
                HashSet<String> answers = new HashSet<>();
                HashSet<String> correctAnswers = new HashSet<>();
                String question = parts[0];
                for (int i = 1; i < 5; i++){
                    answers.add(parts[i]);
                }

                for (int i = 5; i < parts.length; i++){
                    correctAnswers.add(parts[i]);
                }
                Questions questionObject = new Questions(question, answers, correctAnswers.size(), correctAnswers);
                questions.add(questionObject);
            }
        } catch (IOException e) {
            System.out.println("Oops, something went wrong.");
        }

        return questions;
    }
}
