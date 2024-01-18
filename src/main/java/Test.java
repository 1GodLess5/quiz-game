import java.util.*;

public class Test {
    public static void takeTest(HashSet<Questions> questions, String testTopic){
        Scanner scanner = new Scanner(System.in);
        int points = 0;
        int questionCount = 0;

        for (Questions question : questions){
            int singleChoiceAnswer;
            int multipleChoiceAnswer;

            if (question.getTopic().equals(testTopic)){
                questionCount++;
                // prints question
                System.out.println(question.getQuestion());
                // prints possible answers
                for (Map.Entry<Integer, String> answer : question.getAnswers().entrySet()){
                    System.out.println(answer.getKey() + ") " + answer.getValue());
                }

                if (question.getNumberOfCorrectAnswers() == 1){
                    System.out.println("This is single choice question.");
                    System.out.println("Please enter your answer (1 or 2 or 3 or 4): ");

                    while (true){
                        try {
                            singleChoiceAnswer = scanner.nextInt();

                            if (singleChoiceAnswer < 1 || singleChoiceAnswer > 4){
                                System.out.println("Oops, invalid answer.");
                                System.out.println("Please try again: ");
                                continue;
                            }else {
                                if (isCorrect(singleChoiceAnswer, question)){
                                    points++;
                                }

                            }
                            break;
                        } catch (Exception e){
                            System.out.println("Oops, invalid answer.");
                            System.out.println("Please try again: ");
                            scanner.next();
                        }
                    }
                } else{
                    System.out.println("This is multiple choice question.");
                    System.out.println("Please enter your answers not separated by anything (example: 123): ");
                    multipleChoiceAnswer = answerValidator(scanner);
                    if (isCorrect(multipleChoiceAnswer, question)){
                        points++;
                    }
                }
            }
        }
        System.out.println("You have got " + points + " points out of " + questionCount + " questions.");
        System.out.println();
        System.out.println();
    }

    private static boolean isCorrect(int userAnswer, Questions question){
        String userString = Integer.toString(userAnswer);
        char[] answerToCheck = userString.toCharArray();
        int points = 0;

        for (Map.Entry<Integer, String> entry : question.getAnswers().entrySet()){
            for (String correctAnswer : question.getCorrectAnswers()){
                if (correctAnswer.equals(entry.getValue())){
                    String answerString = Integer.toString(entry.getKey());
                    char[] answerChar = answerString.toCharArray();
                    for (int i = 0; i < answerToCheck.length; i++){
                        if (answerChar[0] == answerToCheck[i]){
                            points++;
                        }
                    }
                }
            }
        }

        if (points == question.getNumberOfCorrectAnswers()){
            System.out.println("Correct.");
            System.out.println();
            return true;
        }
        return false;
    }

    private static int answerValidator(Scanner scanner){
        int answer;

        while (true){
            try {
                answer = scanner.nextInt();
                // get answer in int, change it to string, change it to char array, sort it, change it to string
                String toCheck = Integer.toString(answer);
                char[] answerArray = toCheck.toCharArray();
                java.util.Arrays.sort(answerArray);
                String caseString = Arrays.toString(answerArray);

                if (caseString.equals("[1]") || caseString.equals("[1, 2]") || caseString.equals("[1, 2, 3]") || caseString.equals("[1, 2, 3, 4]")){
                    return answer;
                }else {
                    System.out.println("Oops, invalid answer.");
                    System.out.println("Please try again: ");
                }
            } catch (Exception e){
                System.out.println("Oops, invalid answer.");
                System.out.println("Please try again: ");
                scanner.next();
            }
        }
    }
}
