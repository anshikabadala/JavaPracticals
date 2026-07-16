import java.util.*;
public class RPSLS {
    enum Move {
        ROCK, PAPER, SCISSORS, LIZARD, SPOCK
    }

    public static int winner(Move player, Move computer) {

        if (player == computer) {
            return 0;
        }
        return switch (player) {

            case ROCK ->
                (computer == Move.SCISSORS || computer == Move.LIZARD) ? 1 : -1;

            case PAPER ->
                (computer == Move.ROCK || computer == Move.SPOCK) ? 1 : -1;

            case SCISSORS ->
                (computer == Move.PAPER || computer == Move.LIZARD) ? 1 : -1;

            case LIZARD ->
                (computer == Move.PAPER || computer == Move.SPOCK) ? 1 : -1;

            case SPOCK ->
                (computer == Move.ROCK || computer == Move.SCISSORS) ? 1 : -1;
        };
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int playerScore = 0;
        int computerScore = 0;

        System.out.println("===== Rock Paper Scissors Lizard Spock =====");
       for (int round = 1; round <= 5; round++) {
       System.out.println("\nRound " + round);
       System.out.print("Enter your move (ROCK, PAPER, SCISSORS, LIZARD, SPOCK): ");
        Move player = Move.valueOf(sc.next().toUpperCase());
        Move computer = Move.values()[random.nextInt(5)];
        System.out.println("Computer chose: " + computer);
        int result = winner(player, computer);
        if (result == 1) {
        System.out.println("You win this round!");
         playerScore++;
            }
            else if (result == -1) {
                System.out.println("Computer wins this round!");
                computerScore++;
            }
            else {
                System.out.println("This round is a tie.");
            }
        }

        System.out.println("\n===== Final Result =====");
        System.out.println("Your Score: " + playerScore);
        System.out.println("Computer Score: " + computerScore);

        if (playerScore > computerScore) {
            System.out.println("You win " + playerScore + "-" + computerScore);
        }
        else if (computerScore > playerScore) {
            System.out.println("Computer wins " + computerScore + "-" + playerScore);
        }
        else {
            System.out.println("Match Draw");
        }
        sc.close();
    }
}



