package lab6;


public class FillInQuestion extends Question {

    private String answer;

    /**
     * \
     *
     * @param str holds the set answer for the question in setanswer()
     */
    @Override
    public void setAnswer(String str) {
        answer = str;
    }

    /**
     *
     * @param response is the users input from check answer
     * @return returns true or false biased on if the response is in the answer
     */
    @Override
    public boolean checkAnswer(String response) {
        return answer.contains(response);
    }
}
