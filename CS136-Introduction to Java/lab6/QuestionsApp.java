package lab6;


import java.util.Scanner;

public class QuestionsApp {

    /**
     * parameter score maintains the total questions parameter totalqs holds the
     * total questions answered correctly
     */
    public static int score = 0;
    public static int totalqs = 0;

    public static void main(String[] args) {

        Question first = new Question();
        first.setText("Who was the inventor of Java?");
        first.setAnswer("James Gosling");

        ChoiceQuestion second = new ChoiceQuestion();
        second.setText("In which country was the inventor of Java born?");
        second.addChoice("Australia", false);
        second.addChoice("Canada", true);
        second.addChoice("Denmark", false);
        second.addChoice("United States", false);

        NumericQuestion third = new NumericQuestion();
        third.setText("What is the value of PI to the nearest thousandth?");
        third.setAnswer(3.141);
        third.setrange(.001);

        NumericQuestion fourth = new NumericQuestion();
        fourth.setText("What is the value of the Euler's number to the nearest thousandth?");
        fourth.setAnswer(2.711);
        fourth.setrange(.001);

        FillInQuestion fifth = new FillInQuestion();
        fifth.setText("The inventor of Java was ____ ?");
        fifth.setAnswer("_James Gosling_");

        FillInQuestion sixth = new FillInQuestion();
        sixth.setText("The inventor of Pascal was ____?");
        sixth.setAnswer("_Niklaus Wirth_");

        AnyCorrectChoiceQuestion seventh = new AnyCorrectChoiceQuestion();
        seventh.setText("The inventor of Java lived in:");
        seventh.addChoice("Australia", false);
        seventh.addChoice("Canada", true);
        seventh.addChoice("Denmark", false);
        seventh.addChoice("United States", true);

        AnyCorrectChoiceQuestion eighth = new AnyCorrectChoiceQuestion();
        eighth.setText("The inventor of Pascal lived in:");
        eighth.addChoice("Australia", false);
        eighth.addChoice("Canada", true);
        eighth.addChoice("Denmark", false);
        eighth.addChoice("United States", true);
        eighth.addChoice("France", false);

        /**
         * We put print line spacers to seperate questions after we have
         * executed them
         */
        presentQuestion(first);
        System.out.println(" ");
        presentQuestion(second);
        System.out.println(" ");
        presentQuestion(third);
        System.out.println(" ");
        presentQuestion(fourth);
        System.out.println(" ");
        presentQuestion(fifth);
        System.out.println(" ");
        presentQuestion(sixth);
        System.out.println(" ");
        presentQuestion(seventh);
        System.out.println(" ");
        presentQuestion(eighth);
        System.out.println(" ");
        System.out.println("Total score is " + Integer.toString(score) + " out of " + Integer.toString(totalqs));
        System.out.println("Thank You!");
    }

    /**
     * Presents a question to the user and checks the response.
     *
     * @param q the question
     *
     * the if statement handles the total score calculation
     */
    public static void presentQuestion(Question q) {
        q.display();
        System.out.print("Your answer: ");
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        String response = in.nextLine();
        if (q.checkAnswer(response)) {
            System.out.println("Correct answer :)");
        } else {
            System.out.println("Wrong answer :(");
        }
        totalqs += 1;
        if ((q.checkAnswer(response)) == true) {
            score += 1;
        }
    }
}
