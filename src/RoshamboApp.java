
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RoshamboApp {
	public static void main(String[] args) {

		Player[] players = new Player[4];
		Scanner scnr = new Scanner(System.in);
		players[0] = new RandomPlayer("Jack");
		players[1] = new RockPlayer("Brad");
		players[2] = new RandomPlayer("Jill");
		players[3] = new RockPlayer("Rob");
		boolean contloop = true;
		String winsList = "";

		System.out.println("Hello, what is your name?");
		String playerName = scnr.nextLine();

		System.out.println(playerName + ", who would you like to face?");
		String opponentName = (Arrays.toString(players));
		opponentName = opponentName.replace(opponentName.charAt(0), ' ')
				.replace(opponentName.charAt(opponentName.indexOf("]")), ' ')
				.replaceAll(",", "\n");
		System.out.println(opponentName);
		String opponent = scnr.nextLine();
		
			while (contloop == true) {
				
			
			String opponentsRo = getOpponent(players, opponent).toString();

			System.out.println("Rock");
			System.out.println("Paper");
			System.out.println("Scissors");
			System.out.println("Shoot: (Please enter rock, paper, or scissors)");

			String playerPlay = scnr.nextLine();
			System.out.println("Your opponent played, " + opponentsRo);
			winsList = whoWins(playerPlay, opponentsRo, winsList);
			contloop = yesOrNo(scnr, "Would you like to play again?");
		}
		winsList(winsList);
		System.out.println("Thanks for playing, goodbye.");

	}

	public static Roshambo getOpponent(Player[] players, String opponent) {

		for (Player player : players) {
			if (player.toString().equals(opponent)) {
				return player.generateRoshambo();
			}
		}
		return Roshambo.PAPER;
	}

	public static String whoWins(String playerPlay, String opponentPlay, String winsList) {
		if (stringValidator(playerPlay)) {
			if (playerPlay.equalsIgnoreCase(opponentPlay)) {
				System.out.println("It's a tie.");
				return winsList.concat("t");
			} else if (playerPlay.equalsIgnoreCase("rock")) {
				if (opponentPlay.equals("Paper")) {
					System.out.println("You lost.");
					return winsList.concat("l");
				} else {
					System.out.println("Congrats, you won.");
					return winsList.concat("w");
				}
			} else if (playerPlay.equalsIgnoreCase("paper")) {
				if (opponentPlay.equals("Scissors")) {
					System.out.println("You lost.");
					return winsList.concat("l");
				} else {
					System.out.println("Congrats, you won.");
					return winsList.concat("w");
				}
			} else {
				if (opponentPlay.equals("Rock")) {
					System.out.println("You lost.");
					return winsList.concat("l");
				} else {
					System.out.println("Congrats, you won.");
					return winsList.concat("w");
				}
			}
		}

		return winsList;
	}

	public static boolean stringValidator(String prompt) {
		if (prompt.equalsIgnoreCase("paper")) {
			return true;
		} else if (prompt.equalsIgnoreCase("rock")) {
			return true;
		} else if (prompt.equalsIgnoreCase("scissors")) {
			return true;
		} else {
			System.out.print("You did not use rock, paper, or scissors.");
			return false;
		}
	}

	public static boolean yesOrNo(Scanner scnr, String prompt) {

		String input;
		boolean isValid = false;

		do {
			input = getString(scnr, prompt);

			if (input.toLowerCase().startsWith("y")) {
				return true;
			} else {
				System.out.println("Are you sure?");
				input = getString(scnr, "");
				if (input.toLowerCase().startsWith("y")) {
					isValid = true;
				}
			}

		} while (!isValid);

		return false;

	}

	public static String getString(Scanner scnr, String prompt) {

		System.out.print(prompt);
		return scnr.nextLine();
	}

	public static void winsList(String winsList) {

		System.out.println("Now for the results.");
		System.out.println();

		for (int i = 0; i < winsList.length(); i++) {
			if (winsList.charAt(i) == 'w') {
				System.out.println("Game " + (i + 1) + ": Win");
			} else if (winsList.charAt(i) == 'l') {
				System.out.println("Game " + (i + 1) + ": Loss");
			} else if (winsList.charAt(i) == 't') {
				System.out.println("Game " + (i + 1) + ": Tie");
			} else {
				System.out.println("I may have made a mistake.");
			}
		}
	}

}
