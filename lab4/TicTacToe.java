import java.io.IOException;
import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) throws IOException {
		Scanner reader = new Scanner(System.in);
		char[][] board = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };

		printBoard(board);
		int validMoves = 0;
		boolean gameEnded = false;
		int player = 0;
		while(!gameEnded) {
			System.out.print("Player "+(player+1)+" enter row number:");
			int row = reader.nextInt();
			System.out.print("Player "+(player+1)+" enter column number:");
			int col = reader.nextInt();
			if(isValid(row,col) && board[row - 1][col - 1] ==  ' ') {
				board[row - 1][col - 1] = player == 0 ? 'X' : 'O';
				printBoard(board);
				player = ++player % 2;
				validMoves++;
			}else {
				System.out.println("Wrong coordinates!!");
			}

			gameEnded = validMoves == 9 || checkboard(board,row-1,col-1);
		}


		reader.close();
	}

	public static boolean checkboard(char[][] board,int row , int col) {
		char symbol = board[row][col];
		boolean win = true;
		for(int i=0; i < 3;i++){
			if (board[row][i] != symbol){
				win = false;
				break;
			}
		}
		if(win){
			return true;
		}
		win = true;
		for(int i=0; i < 3;i++){
			if (board[i][col] != symbol){
				win = false;
				break;
			}
		}
		if(win){
			return true;
		}

		if(row == col) {
			win = true;
			for (int i = 0; i < 3;i++ ){
				if(board[i][i] != symbol){
					win = false;
					break;
				}
			}
			if(win)
				return true;
		}
		if (row + col == 2) {
			win = true;
			for (int i = 0; i < 3; i++) {
				if (board[2 - i][i] != symbol) {
					win = false;
					break;
				}
			}
			if (win) {
				return true;

			}
		}

		return false;
	}


	public static void printBoard(char[][] board) {
		System.out.println("    1   2   3");
		System.out.println("   -----------");
		for (int row = 0; row < 3; ++row) {
			System.out.print(row + 1 + " ");
			for (int col = 0; col < 3; ++col) {
				System.out.print("|");
				System.out.print(" " + board[row][col] + " ");
				if (col == 2)
					System.out.print("|");

			}
			System.out.println();
			System.out.println("   -----------");

		}

	}
	public static boolean isValid(int row,int col){
		if(row<1 || row >3){
			return false;
		}
		if(col<1 || col >3){
			return false;
		}
		return true;
	}

}