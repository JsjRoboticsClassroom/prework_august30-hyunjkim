package nyc.c4q;

public class Main {

    public static void main(String[] args) {
        Hangman hangman = new Hangman();
        boolean notDone = true;
        while (notDone) {
            while (hangman.getMisses() < 5) {
                hangman.printCurrentWord();
                hangman.promptPlayer("Enter a letter: ");
                hangman.readLetter();
                hangman.checkLetter();
                if (hangman.guessedSuccessfully()) {
                    break;
                }
                System.out.println(Drawing.get(hangman.getMisses()));
                System.out.println("Misses -> " + hangman.getMisses());
            }
            if (hangman.guessedSuccessfully()) {
                System.out.println("Success");
            } else {
                System.out.println("The answer was " + hangman.getSecretWord());
            }

            hangman.promptPlayer("Do you want to play again?");
            hangman.readLetter();
            //String userAnswer = hangman.readLetter();
            //userAnswer.equalsIgnoreCase(getInput);
            String userAnswer = hangman.readLetter();
            userAnswer = userAnswer.toLowerCase();
            boolean isValidInput = true;

            do {
                if ((userAnswer == "yes") || (userAnswer == "y")) {
                    isValidInput = true;
                } else if ((userAnswer == "no") || (userAnswer == "n")) {
                    isValidInput = false;
                } else {
                    hangman.promptPlayer("try again");
                }
            } while (isValidInput == false);
        }
    }
}
