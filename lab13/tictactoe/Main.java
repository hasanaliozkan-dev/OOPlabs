package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        Board board = new Board();

        System.out.println(board);
        while (!board.isEnded()) {

            int player = board.getCurrentPlayer();

            System.out.print("Player " + player + " enter row number:");
            int row = Integer.valueOf(reader.nextLine());


            System.out.print("Player " + player + " enter column number:");
            int col = Integer.valueOf(reader.nextLine());

            board.move(row, col);
            System.out.println(board);
        }


        reader.close();
    }


}
