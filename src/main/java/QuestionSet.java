import java.util.ArrayList;

public class QuestionSet {
    private String set;

    public QuestionSet(String set) {
        this.set = set;
    }

    public String getSet() {
        return this.set;
    }

    public static ArrayList<QuestionSet> initiateSets(ArrayList<QuestionSet> questionSet, String newSet){
        int isInSet = 0;
        for (QuestionSet set : questionSet){
            if (set.getSet().equals(newSet)){
                isInSet++;
            }
        }

        if (isInSet == 0){
            QuestionSet questionSetObject = new QuestionSet(newSet);
            questionSet.add(questionSetObject);
        }

        return questionSet;
    }
}