import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args){
        HashSet<Questions> questions = ReadFile.read();
        ArrayList<QuestionSet> questionSets = new ArrayList<>();

        for (Questions question : questions){
            QuestionSet.initiateSets(questionSets, question.getTopic());
        }
        welcomeMessage();

        Test.takeTest(questions, "World History");
    }

    public static void welcomeMessage() {
        System.out.println("Welcome to the Quiz Game!");
        System.out.println(" Get ready to test your knowledge and have some fun.");
        System.out.println("Good luck, and let the quiz adventure begin!");
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            System.out.println("Oopsie.");
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }

//    public static String mainMenu(ArrayList<QuestionSet> questionSets){
//
//    }
}
