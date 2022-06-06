package lab6;


import java.util.ArrayList;

public class AnyCorrectChoiceQuestion extends ChoiceQuestion {

    private String answer;
    private ArrayList<String> choices;

    /**
     * Constructs a choice question with no choices.
     */
    public AnyCorrectChoiceQuestion() {
        choices = new ArrayList<>();
        answer = "";
    }
    
    /**
     * inside of get answer it returns the current answer with a return
     * @return 
     */
    
    public String getanswer() {
        return answer;
    }
    
    /**
     * setanswer takes a string and sets it as the new answer
     * @param str is the new answer
     */
    
    @Override
    public void setAnswer(String str) {
        answer = str;
    }
    
    /**
     * add choice handles multiple answers
     * @param choice is the possible answer
     * @param correct is a boolean statement that tells me if it is true or not
     */
    
    @Override
    public void addChoice(String choice, boolean correct) {
        choices.add(choice);
        if (correct) {
            // Convert choices.size() to string
            String choiceString = getanswer() + choices.size();
            setAnswer(choiceString);
        }
    }

    @Override
    public boolean checkAnswer(String response) {
        return answer.contains(response);
    }

    @Override
    public void display() {
        super.display();
        for (int i = 0; i < choices.size(); i++) {
            int choiceNumber = i + 1;
            System.out.println(choiceNumber + ": " + choices.get(i));
        }
        System.out.println("Note, there may be several correct answers.");
    }
}
