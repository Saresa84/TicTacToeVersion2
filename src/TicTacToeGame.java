import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame {
	// variables for spot location
	static int yLocation = 0;
	static int xLocation = 0;

	// String to get user moves
	static String userMove;
	// array for board
	static char[][] board = { { ' ', ' ', ' ', ' ' }, { ' ', ' ', ' ', ' ' }, { ' ', ' ', ' ', ' ' },
			{ ' ', ' ', ' ', ' ' } };
	// open Scanner
	static Scanner input = new Scanner(System.in);

	//variable for keepGoing
	static String keepGoing = "y";
	public static void main(String[] args) {

		// String for player turn
		String playerTurn;

		// tieCounter variable
		int tieCounter = 0;
		// title
		System.out.println("Welcome to Tic Tac Toe!" + "\n");
		while (keepGoing.equalsIgnoreCase("y")) {
			while (tieCounter < 8) {
				// get playerX move
				System.out.print("Enter the your move (X,Y): ");
				playerTurn = "playerX";
				userMove = input.nextLine();
				// convert user input to integer
				convertUserMove(userMove);
				// check if move inbounds
				getValidNumberInRangeX(1, 3);
				getValidNumberInRangeY(1, 3);
				// check to see if spot is available
				checkIfMoveOpen(board, input);
				// marks spot
				board[xLocation][yLocation] = 'X';
				// check for win
				checkForWin();
				if (checkForWin() == true && playerTurn.equalsIgnoreCase("playerX")) {
					System.out.println("Player X Won!!");
					System.out.println("Would you like to play agian Y/N?: ");
					keepGoing = input.nextLine();
					validateKeepGoingUserInput(keepGoing);
					resetBoard();
					break;
				}
				// prints board
				printsBoard(board);
				tieCounter++;
				// get playerO move
				System.out.print("Enter the your move (X,Y): ");
				userMove = input.nextLine();
				// switch player turn
				playerTurn = "playerO";
				if (playerTurn.equalsIgnoreCase("playerO")) {
					// convert user input to integer
					convertUserMove(userMove);
					// check if move inbounds
					getValidNumberInRangeX(1, 3);
					getValidNumberInRangeY(1, 3);
					// check to see if spot is available
					checkIfMoveOpen(board, input);
					// marks spot
					board[xLocation][yLocation] = 'O';
					// check for win
					checkForWin();
					if (checkForWin() == true && playerTurn.equalsIgnoreCase("playerO")) {
						System.out.println("Player O Won!!");
						System.out.println("Would you like to play agian Y/N?: ");
						keepGoing = input.nextLine();
						validateKeepGoingUserInput(keepGoing);
						resetBoard();
						playerTurn = "playerX";
						break;
					}
					// prints board
					printsBoard(board);
					tieCounter++;
				} // end if for playerO
			} // end tieCounte while statement
			if (tieCounter > 7) {
				tieCounter = 0;
				System.out.println("It's a Tie!!");
				System.out.println("Continue Y/N?: ");
				keepGoing = input.nextLine();
				validateKeepGoingUserInput(keepGoing);
			}
		} // end while statement for keepGoing
		System.out.println("Thanks for playing, Good Bye!!");
	}

	public static String validateKeepGoingUserInput(String keepGoing) {
		while (!keepGoing.equalsIgnoreCase("y") && !keepGoing.equalsIgnoreCase("n")) {
			System.out.println("You must enter either 'Y' or 'N'.");
			System.out.println("Continue Y/N?: ");
			keepGoing = input.nextLine();
		} // end if statement validating user input
		return keepGoing;
	}

	public static boolean checkForWin() {
		// check for win
		if (board[1][1] == board[1][2] && board[1][2] == board[1][3] && (board[1][1] == 'X' || board[1][1] == 'O'))
			return true;
		else if (board[2][1] == board[2][2] && board[2][2] == board[2][3] && (board[2][1] == 'X' || board[2][1] == 'O'))
			return true;
		else if (board[3][1] == board[3][2] && board[3][2] == board[3][3] && (board[3][1] == 'X' || board[3][1] == 'O'))
			return true;
		else if (board[1][1] == board[2][1] && board[2][1] == board[3][1] && (board[1][1] == 'X' || board[1][1] == 'O'))
			return true;
		else if (board[1][2] == board[2][2] && board[2][2] == board[3][2] && (board[1][2] == 'X' || board[1][2] == 'O'))
			return true;
		else if (board[1][3] == board[2][3] && board[2][3] == board[3][3] && (board[1][3] == 'X' || board[1][3] == 'O'))
			return true;
		else if (board[1][1] == board[2][2] && board[2][2] == board[3][3] && (board[1][1] == 'X' || board[1][1] == 'O'))
			return true;
		else if (board[1][3] == board[2][2] && board[2][2] == board[3][1] && (board[1][3] == 'X' || board[1][3] == 'O'))
			return true;
		else
			return false;
	}

	public static void printsBoard(char[][] board) {
		// prints board
		System.out.print(" " + board[1][1] + " |" + " " + board[1][2] + " |" + " " + board[1][3] + "\n");
		System.out.println("---|---|---");
		System.out.print(" " + board[2][1] + " |" + " " + board[2][2] + " |" + " " + board[2][3] + "\n");
		System.out.println("---|---|---");
		System.out.print(" " + board[3][1] + " |" + " " + board[3][2] + " |" + " " + board[3][3] + "\n");
		// end prints game board
	}

	public static void checkIfMoveOpen(char[][] board, Scanner input) {
		// check to see if spot is available
		while (board[xLocation][yLocation] == ('X') || board[xLocation][yLocation] == ('O')) {
			System.out.println("You must pick a spot that does not have a 'X' or 'O'.");
			System.out.print("Enter the your move (X,Y): ");
			userMove = input.nextLine();
			convertUserMove(userMove);
		} // end check to see if spot is available
	}

	public static int getValidNumberInRangeX(int min, int max) {
		int number = 0;
		while (xLocation < min || xLocation > max) {
			System.out.println("You must pick a spot that is on the board.");
			System.out.print("Enter the your move (X,Y): ");
			userMove = input.nextLine();
			convertUserMove(userMove);
			number = xLocation;
		}
		return number;
	}

	public static int getValidNumberInRangeY(int min, int max) {
		int number = 0;
		while (yLocation < min || yLocation > max) {
			System.out.println("You must pick a spot that is on the board.");
			System.out.print("Enter the your move (X,Y): ");
			userMove = input.nextLine();
			convertUserMove(userMove);
			number = yLocation;
		}
		return number;

	}

	public static void convertUserMove(String userMove) {
		// method to make input usable variables
		char xLocationTemp = userMove.charAt(0);
		char yLocationTemp = userMove.charAt(2);
		xLocation = Character.getNumericValue(xLocationTemp);
		// System.out.println(xLocation);
		yLocation = Character.getNumericValue(yLocationTemp);

	}

	public static void resetBoard() {
		for (char[] rows : board)
			Arrays.fill(rows, ' ');
	}
}
