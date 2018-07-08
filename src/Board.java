import java.util.*;

public class Board {
	private int size;
	private Space[] board;
	
	public Board() {
		Scanner console = new Scanner(System.in);
		System.out.print("What is the size of the new square board? (the number of vertical spaces) ");
		size = console.nextInt();
		board = new Space[size * size];
		for (int i = 0; i < board.length; i++) {
			board[i] = new Space(" ");
		}
		BoardSetupUI setupUI = new BoardSetupUI(board, size);
	}
}
