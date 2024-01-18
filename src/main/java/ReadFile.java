import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class ReadFile {
    public static HashSet<Questions> read(){
        HashSet<Questions> questions = new HashSet<>();

        try (BufferedReader scanner = new BufferedReader(new FileReader("src/main/java/questions.txt"))) {
            String line;

            while ((line = scanner.readLine()) != null) {
                String[] parts = line.split("[-!]");
                HashMap<Integer, String> answers = new HashMap<>();
                LinkedHashSet<String> correctAnswers = new LinkedHashSet<>();

                String questionTopic = parts[0];
                String question = parts[1];

                for (int i = 2; i < 6; i++){
                    answers.put(i - 1, parts[i]);
                }
                for (int i = 6; i < parts.length; i++){
                    correctAnswers.add(parts[i]);
                }

                Questions questionObject = new Questions(questionTopic, question, answers, correctAnswers.size(), correctAnswers);
                questions.add(questionObject);
            }
        } catch (IOException e) {
            System.out.println("Oops, something went wrong.");
        }

        return questions;
    }
}
