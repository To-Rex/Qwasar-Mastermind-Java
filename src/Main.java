import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       /* PROMPT>java my_mastermind -c "0123"
        Will you find the secret code?
        ---
                Round 0
                >1456
        Well placed pieces: 0
        Misplaced pieces: 1
                ---
                Round 1
                >tata
        Wrong input!
                >4132
        Well placed pieces: 1
        Misplaced pieces: 2
                ---
                Round 2
                >0123
        Congrats! You did it!*/

        Scanner scanner = new Scanner(System.in);
        //String secretCode = sc.nextLine();
        //random code generator 4 digits long with no repeating digits
        StringBuilder secretCode = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int digit = (int) (Math.random() * 10);
            while (secretCode.toString().contains(String.valueOf(digit))) {
                digit = (int) (Math.random() * 10);
            }
            secretCode.append(digit);
        }
        System.out.println("this code should not actually be visible to you! |-> "+secretCode+" <-|");
        System.out.println("-------------------------------------------------------------");

        int wellPlacedPieces = 0;
        int misplacedPieces = 0;
        int round = 0;
        String guess = "";
        boolean isCorrect = false;
        System.out.println("Will you find the secret code? 🤓🤓🤓");
        while (!isCorrect) {
            System.out.println("____");
            System.out.println("Round " + round);
            if (round == 11) {
                System.out.println("You lost! 😭😭😭");
                break;
            }
            guess = scanner.nextLine();
            if (guess.length() != 4) {
                System.out.println("code must be 4 digits!");
                continue;
            }

            if (!guess.matches("[0-9]+")) {
                System.out.println("must consist of numbers only");
                continue;
            }

            if (guess.length() != secretCode.length()) {
                System.out.println("Wrong input!");
                continue;
            }

            for (int i = 0; i < guess.length(); i++) {
                if (guess.charAt(i) == secretCode.charAt(i)) {
                    wellPlacedPieces++;
                } else if (secretCode.toString().contains(guess.charAt(i) + "")) {
                    misplacedPieces++;
                }
            }
            System.out.println("🤩 Well placed pieces : " + wellPlacedPieces);
            System.out.println("😱 Misplaced pieces: " + misplacedPieces);
            if (wellPlacedPieces == secretCode.length()) {
                System.out.println("Congrats! You did it!  🤩🤯😱🥳");
                isCorrect = true;
            }
            wellPlacedPieces = 0;
            misplacedPieces = 0;
            round++;
        }
    }
}