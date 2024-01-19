import java.util.Scanner;

public class RPS {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);

		System.out.println("Welcome to Rock Paper Scissors Lizard Spock!\n\nHere are the rules and information:");
		System.out.println("In each round, you will have to input either \"rock\", \"paper\", \"scissors\", \"lizard\", or  \"spock\" (not case-sensitive).\nThe computer will do the same.");
		System.out.println("\n- Rock beats scissors and lizard\n- Paper beats rock and spock\n- Scissors beats paper and lizard\n- Lizard beats spock and paper\n- Spock beats scissors and rock");
		System.out.println("\nThere will be three rounds. Whoever has the most wins after all three rounds will win.\n");

		System.out.println("Enter a difficulty rating:\n1: Normal\n2: Medium\n3: Hard\n4: Impossible");
		int diff = reader.nextInt();
		reader.nextLine();

		System.out.println();

		if (diff < 1 || diff > 4) {
			System.out.println("Invalid difficulty option.");
			return;
		}

		int userWins = 0;
		int computerWins = 0;
		int[] winsArray = {};

		for (int i = 1; i <= 3; i++) {
			System.out.println("Round " + i);
			System.out.print("Enter a RPS throw: ");

			String userThrow = reader.nextLine().toLowerCase();

			switch (userThrow) {
				case "rock":
					winsArray = rock(userWins, computerWins, diff);

					userWins = winsArray[0];
					computerWins = winsArray[1];

					break;
				case "paper":
					winsArray = paper(userWins, computerWins, diff);

					userWins = winsArray[0];
					computerWins = winsArray[1];

					break;
				case "scissors":
					winsArray = scissors(userWins, computerWins, diff);

					userWins = winsArray[0];
					computerWins = winsArray[1];

					break;
				case "lizard":
					winsArray = lizard(userWins, computerWins, diff);

					userWins = winsArray[0];
					computerWins = winsArray[1];

					break;
				case "spock":
					winsArray = spock(userWins, computerWins, diff);

					userWins = winsArray[0];
					computerWins = winsArray[1];

					break;
				default:
					System.out.println("Not an option.");
					return;
			}

			System.out.println();
		}

		if (userWins > computerWins) {
			System.out.println("Result: You win!");
			winArt();
		} else if (userWins < computerWins) {
			System.out.println("Result: Computer wins!");
			loseArt();
		} else {
			System.out.println("Result: Tie!");
			tieArt();
		}
	}

	public static int[] rock(int userWins, int computerWins, int diff) {
		rockArt();

		int computerNumber = 0;
		int chance;

		switch (diff) {
			case 1: // does not cheat
				computerNumber = (int)(Math.random() * 5) + 1; // 1 Rock, 2 Paper, 3 Scissors, 4 Lizard, 5 Spock
				break;
			case 2: // 20% chance of cheating
				chance = (int)(Math.random() * 10) + 1;

				if (chance < 3) computerNumber = 2;
				else computerNumber = (int)(Math.random() * 5) + 1;

				break;
			case 3: // 50% chance of cheating
				chance = (int)(Math.random() * 10) + 1;

				if (chance < 6) computerNumber = 2;
				else computerNumber = (int)(Math.random() * 5) + 1;

				break;
			case 4: // always cheats
				computerNumber = 2;
				break;
		}

		switch (computerNumber) {
			case 1:
				System.out.println("Computer selects: Rock");
				rockArt();

				System.out.println("Tie!");

				break;
			case 2:
				System.out.println("Computer selects: Paper");
				paperArt();

				System.out.println("Computer wins!");
				computerWins++;

				break;
			case 3:
				System.out.println("Computer selects: Scissors");
				scissorArt();

				System.out.println("You win!");
				userWins++;

				break;
			case 4:
				System.out.println("Computer selects: Lizard");
				lizardArt();

				System.out.println("You win!");
				userWins++;

				break;
			case 5:
				System.out.println("Computer selects: Spock");
				spockArt();

				System.out.println("Computer wins!");
				computerWins++;

				break;
		}

		int[] wins = { userWins, computerWins };
		return wins;
	}

	public static int[] paper(int userWins, int computerWins, int diff) {
		paperArt();

		int computerNumber = 0;
		int chance;

		switch (diff) {
			case 1:
				computerNumber = (int)(Math.random() * 5) + 1;
				break;
			case 2:
				chance = (int)(Math.random() * 10) + 1;

				if (chance < 3) computerNumber = 3;
				else computerNumber = (int)(Math.random() * 5) + 1;

				break;
			case 3:
				chance = (int)(Math.random() * 10) + 1;

				if (chance < 6) computerNumber = 3;
				else computerNumber = (int)(Math.random() * 5) + 1;

				break;
			case 4:
				computerNumber = 3;
				break;
		}

		switch (computerNumber) {
			case 1:
				System.out.println("Computer selects: Rock");
				rockArt();

				System.out.println("You win!");
				userWins++;

				break;
			case 2:
				System.out.println("Computer selects: Paper");
				paperArt();

				System.out.println("Tie!");

				break;
			case 3:
				System.out.println("Computer selects: Scissors");
				scissorArt();

				System.out.println("Computer wins!");
				computerWins++;

				break;
			case 4:
				System.out.println("Computer selects: Lizard");
				lizardArt();

				System.out.println("Computer wins!");
				computerWins++;

				break;
			case 5:
				System.out.println("Computer selects: Spock");
				spockArt();

				System.out.println("You win!");
				userWins++;

				break;
		}

		int[] wins = { userWins, computerWins };
		return wins;
	}

	public static int[] scissors(int userWins, int computerWins, int diff) {
		scissorArt();

		int computerNumber = 0;
		int chance;

		switch (diff) {
			case 1:
				computerNumber = (int)(Math.random() * 5) + 1;
				break;
			case 2:
				chance = (int)(Math.random() * 10) + 1;

				if (chance < 3) computerNumber = 1;
				else computerNumber = (int)(Math.random() * 5) + 1;

				break;
			case 3:
				chance = (int)(Math.random() * 10) + 1;

				if (chance < 6) computerNumber = 1;
				else computerNumber = (int)(Math.random() * 5) + 1;

				break;
			case 4:
				computerNumber = 1;
				break;
		}

		switch (computerNumber) {
			case 1:
				System.out.println("Computer selects: Rock");
				rockArt();

				System.out.println("Computer wins!");
				computerWins++;

				break;
			case 2:
				System.out.println("Computer selects: Paper");
				paperArt();

				System.out.println("You win!");
				userWins++;

				break;
			case 3:
				System.out.println("Computer selects: Scissors");
				scissorArt();

				System.out.println("Tie!");

				break;
			case 4:
				System.out.println("Computer selects: Lizard");
				lizardArt();

				System.out.println("You win!");
				userWins++;

				break;
			case 5:
				System.out.println("Computer selects: Spock");
				spockArt();

				System.out.println("Computer wins!");
				computerWins++;

				break;
		}

		int[] wins = { userWins, computerWins };
		return wins;
	}

	public static int[] lizard(int userWins, int computerWins, int diff) {
		lizardArt();

		int computerNumber = 0;
		int chance;

		switch (diff) {
			case 1:
				computerNumber = (int)(Math.random() * 5) + 1;
				break;
			case 2:
				chance = (int)(Math.random() * 10) + 1;

				if (chance < 3) computerNumber = 1;
				else computerNumber = (int)(Math.random() * 5) + 1;

				break;
			case 3:
				chance = (int)(Math.random() * 10) + 1;

				if (chance < 6) computerNumber = 1;
				else computerNumber = (int)(Math.random() * 5) + 1;

				break;
			case 4:
				computerNumber = 1;
				break;
		}

		switch (computerNumber) {
			case 1:
				System.out.println("Computer selects: Rock");
				rockArt();

				System.out.println("Computer wins!");
				computerWins++;

				break;
			case 2:
				System.out.println("Computer selects: Paper");
				paperArt();

				System.out.println("You win!");
				userWins++;

				break;
			case 3:
				System.out.println("Computer selects: Scissors");
				scissorArt();

				System.out.println("Computer wins!");
				computerWins++;

				break;
			case 4:
				System.out.println("Computer selects: Lizard");
				lizardArt();

				System.out.println("Tie!");

				break;
			case 5:
				System.out.println("Computer selects: Spock");
				spockArt();

				System.out.println("You win!");
				userWins++;

				break;
		}

		int[] wins = { userWins, computerWins };
		return wins;
	}

	public static int[] spock(int userWins, int computerWins, int diff) {
		spockArt();

		int computerNumber = 0;
		int chance;

		switch (diff) {
			case 1:
				computerNumber = (int)(Math.random() * 5) + 1;
				break;
			case 2:
				chance = (int)(Math.random() * 10) + 1;

				if (chance < 3) computerNumber = 2;
				else computerNumber = (int)(Math.random() * 5) + 1;

				break;
			case 3:
				chance = (int)(Math.random() * 10) + 1;

				if (chance < 6) computerNumber = 2;
				else computerNumber = (int)(Math.random() * 5) + 1;

				break;
			case 4:
				computerNumber = 2;
				break;
		}

		switch (computerNumber) {
			case 1:
				System.out.println("Computer selects: Rock");
				rockArt();

				System.out.println("You win!");
				userWins++;

				break;
			case 2:
				System.out.println("Computer selects: Paper");
				paperArt();

				System.out.println("Computer wins!");
				computerWins++;

				break;
			case 3:
				System.out.println("Computer selects: Scissors");
				scissorArt();

				System.out.println("You win!");
				userWins++;

				break;
			case 4:
				System.out.println("Computer selects: Lizard");
				lizardArt();

				System.out.println("Computer wins!");
				computerWins++;

				break;
			case 5:
				System.out.println("Computer selects: Spock");
				spockArt();

				System.out.println("Tie!");

				break;
		}

		int[] wins = { userWins, computerWins };
		return wins;
	}

	public static void rockArt() {
		System.out.println("      ______");
		System.out.println("     /\t    \\");
		System.out.println("    /\t     \\");
		System.out.println("    |\t     |");
		System.out.println("    \\\t     /");
		System.out.println("     \\______/");
	}

	public static void paperArt() {
		System.out.println("      ______");
		System.out.println("     |______|");
		System.out.println("     |______|");
		System.out.println("     |______|");
		System.out.println("     |______|");
		System.out.println("     |______|");
	}

	public static void scissorArt() {
		System.out.println("   _\t   ,/\'");
		System.out.println("  (_).  ,/\'");
		System.out.println("   _  ::");
		System.out.println("  (_)\'  `\\.");
		System.out.println("\t   `\\.");
	}

	public static void lizardArt() {
		System.out.println("\t\t       )/_");
		System.out.println("\t     _.--..---\"-,--c_");
		System.out.println("\t\\L..\'\t\t._O__)_");
		System.out.println(",-.\t_.+  _  \\..--( /");
		System.out.println("  `\\.-\'\'__.-' \\ (     \\_ ");
		System.out.println("    `\'\'\'       `\\__   /\\");
		System.out.println("\t\t\')");
	}

	public static void spockArt() {
		System.out.println("    .-.  _");
		System.out.println("    | | / )");
		System.out.println("    | |/ /");
		System.out.println("   _|__ /_");
		System.out.println("  / __)-\' )");
		System.out.println("  \\  `(.-\')");
		System.out.println("   > ._>-\'");
		System.out.println("  / \\/");
	}

	public static void winArt() {
		System.out.println("\t     ___________");
		System.out.println("\t    \'._==_==_=_.\'");
		System.out.println("\t    .-\\:      /-.");
		System.out.println("\t   | (|:.     |) |");
		System.out.println("\t    \'-|:.     |-\'");
		System.out.println("\t      \\::.    /");
		System.out.println("\t       \'::. .\'");
		System.out.println("\t\t ) (");
		System.out.println("\t       _.\' \'._");
		System.out.println("\t      `\"\"\"\"\"\"\"`");
		System.out.println("\t         ) (");
	}

	public static void loseArt() {
		System.out.println("   _____          __  __ ______      ______      ________ _____  ");
		System.out.println("  / ____|   /\\   |  \\/  |  ____|    / __ \\ \\    / /  ____|  __ \\ ");
		System.out.println(" | |  __   /  \\  | \\  / | |__      | |  | \\ \\  / /| |__  | |__) |");
		System.out.println(" | | |_ | / /\\ \\ | |\\/| |  __|     | |  | |\\ \\/ / |  __| |  _  / ");
		System.out.println(" | |__| |/ ____ \\| |  | | |____    | |__| | \\  /  | |____| | \\ \\ ");
		System.out.println("  \\_____/_/    \\_\\_|  |_|______|    \\____/   \\/   |______|_|  \\_\\");
	}

	public static void tieArt() {
		System.out.println("  _______ _____ ______ _ ");
		System.out.println(" |__   __|_   _|  ____| |");
		System.out.println("    | |    | | | |__  | |");
		System.out.println("    | |    | | |  __| | |");
		System.out.println("    | |   _| |_| |____|_|");
		System.out.println("    |_|  |_____|______(_)");
	}
}