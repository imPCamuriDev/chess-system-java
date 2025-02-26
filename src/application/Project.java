package application;

import boardgame.Board;
import boardgame.Position;

public class Project {
	public static void main(String args[]) {
		Board board = new Board(8,3);
		
		System.out.println(board.getColumns() + ", " + board.getRows());
	}
}
