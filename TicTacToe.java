import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


public class TicTacToe {
	static Scanner in;
	static String[] board;
	static String turn;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		board = new String[9];
		turn = "X";
		String winner = null;
		populateEmptyBoard();
        System.out.println(  "\n" );
		System.out.println("\t\t\tWelcome to 2 Player Tic Tac Toe.");
		System.out.println("\t\t\t--------------------------------");
        try {
            System.out.println(  "\n" );
            System.out.println("RULES:");
            Thread.sleep(2000);
            System.out.println("To place your mark on board enter the box number");
            Thread.sleep(2000);
            System.out.println("For first box press 1 and it follows till 9");
            Thread.sleep(2000);
            System.out.println("like this:\n");
            
            Thread.sleep(2000);
		    printBoard();
            System.out.println(  "\n" );
		    System.out.println("player 1: X\tPlayer 2: O\n\tstarts after 5s......\n");
            Thread.sleep(5000);
            
            System.out.println("Player 1 will play first. Enter a slot number to place X in:");
            Thread.sleep(2000);
        } catch (Exception e) {
            // TODO: handle exception
        }
    
		while (winner == null) {
			int numInput;
			try {
				numInput = in.nextInt();
				if (!(numInput > 0 && numInput <= 9)) {
					System.out.println("Invalid input; re-enter slot number:");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input; re-enter slot number:");
				continue;
			}
			if (board[numInput-1].equals(String.valueOf(numInput))) {
				board[numInput-1] = turn;
				if (turn.equals("X")) {
					turn = "O";
				} else {
					turn = "X";
				}
                System.out.println(  "Nice move!" );
				printBoard();
				winner = checkWinner();
			} else {
				System.out.println("Slot already taken; re-enter slot number:");
				continue;
			}
		}
		if (winner.equalsIgnoreCase("draw")) {
			System.out.println("It's a draw! Thanks for playing.");
		} else {
			System.out.println("Congratulations! " + winner + " have won!\n\t Thanks for playing....");
		}
	}

	static String checkWinner() {
		for (int a = 0; a < 8; a++) {
			String line = null;
			switch (a) {
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}
			if (line.equals("XXX")) {
				return "Player 1";
			} else if (line.equals("OOO")) {
				return "Player 2";
			}
		}

		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(board).contains(String.valueOf(a+1))) {
				break;
			}
			else if (a == 8) return "draw";
		}
        
		System.out.println(turn + "'s turn; Where to enter " + turn + " ?");
        
		return null;
	}

	static void printBoard() {
		System.out.println("\t\t/---|---|---\\");
		System.out.println("\t\t| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("\t\t|-----------|");
		System.out.println("\t\t| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("\t\t|-----------|");
		System.out.println("\t\t| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
		System.out.println("\t\t/---|---|---\\");
	}

	static void populateEmptyBoard() {
		for (int a = 0; a < 9; a++) {
			board[a] = String.valueOf(a+1);
		}
	}
}
    
    

 