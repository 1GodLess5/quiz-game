import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        List<Quiz> quiz = ReadFile.read();

        welcomeMessage();
        String testTopic = mainMenu(quiz);
        System.out.println(testTopic);
//        while (!testTopic.equals("finish")){
//            Test.takeTest(questions, testTopic);
//            testTopic = mainMenu(questionSets);
//        }

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

    public static String mainMenu(List<Quiz> quizzes){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Question topics:");
        for (Quiz quiz : quizzes){
            System.out.println((quiz.getQuizOrder() + 1) + ") " + quiz.getQuizTopic());
        }
        System.out.println("5) Exit()");
        System.out.println("Please pick one topic: ");
        int choice;

        while (true){
            try {
                choice = scanner.nextInt();

                if (choice < 1 || choice > quizzes.size() + 1){
                    System.out.println("Oops, invalid input.");
                    continue;
                }
                break;
            } catch (Exception e){
                System.out.println("Oops, invalid input.");
                scanner.next();
            }
        }
        if (choice == quizzes.size() + 1){
            return "finish";
        }
        return quizzes.get(choice-1).getQuizTopic();
    }
}
