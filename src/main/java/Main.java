import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        HashSet<Questions> questions = ReadFile.read();
        ArrayList<QuestionSet> questionSets = new ArrayList<>();
        for (Questions question : questions){
            QuestionSet.initiateSets(questionSets, question.getTopic());
        }

        welcomeMessage();
        String testTopic = mainMenu(questionSets);
        while (!testTopic.equals("finish")){
            Test.takeTest(questions, testTopic);
            testTopic = mainMenu(questionSets);
        }

        System.out.println("Thank you for playing my Quiz Game! ");
    }

    public static void welcomeMessage() {
        System.out.println("Welcome to the Quiz Game!");
        System.out.println("Get ready to test your knowledge and have some fun.");
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

    public static String mainMenu(ArrayList<QuestionSet> questionSets){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Question topics:");
        for (int i = 0; i < questionSets.size(); i++){
            System.out.println((i + 1) + ") " + questionSets.get(i).getSet());
        }
        System.out.println("5) Exit()");
        System.out.println("Please pick one topic: ");
        int choice;

        while (true){
            try {
                choice = scanner.nextInt();

                if (choice < 1 || choice > questionSets.size() + 1){
                    System.out.println("Oops, invalid input.");
                    continue;
                }
                break;
            } catch (Exception e){
                System.out.println("Oops, invalid input.");
                scanner.next();
            }
        }
        if (choice == questionSets.size() + 1){
            return "finish";
        }
        return questionSets.get(choice-1).getSet();
    }
}
