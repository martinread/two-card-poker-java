import java.util.Scanner;

public class GetUserInput {

    public int getNumberOfPlayers(int MIN_PLAYERS, int MAX_PLAYERS) {

        System.out.print("Select the number of players (2-6): ");

        while (true) {
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();
            try {
                int userNumInput = Integer.parseInt(userInput);
                if (userNumInput >= MIN_PLAYERS && userNumInput <= MAX_PLAYERS) {
                    return userNumInput;
                } else {
                    System.out.println("Invalid input. Please enter 2-6 players: ");
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public int getNumberOfRounds() {

        System.out.print("How many rounds would you like to play?: ");

        while (true) {
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();
            try {
                return Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
}
