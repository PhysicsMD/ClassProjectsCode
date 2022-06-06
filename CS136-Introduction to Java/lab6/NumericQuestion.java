package lab6;


public class NumericQuestion extends Question {

    /**
     * @param range holds the variance in possible answers
     * @param answer holds the actual answer
     */
    private double range;
    private double answer;

    NumericQuestion() {
        range = 0.0;
        answer = 0.0;
    }

    /**
     *
     * @param input in setanswer sets the answer for the specific question
     */
    public void setAnswer(double input) {
        answer = input;
    }

    /**
     *
     * @param ranges in setrange sets the variance tolerance
     */
    public void setrange(double ranges) {
        range = ranges;
    }

    /**
     *
     * @param response holds the user input answer and trys to check if it is a
     * possible value
     * @return returns true or false according to the answer
     */
    @Override
    public boolean checkAnswer(String response) {
        try {
            return ((Double.valueOf(response) >= (answer - range)) && (Double.valueOf(response) <= (answer + range)));
        } catch (NumberFormatException e) {
            System.out.println("Not an integer");
            return false;
        }
    }
}
