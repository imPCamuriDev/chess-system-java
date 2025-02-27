package application;

import chess.ChessMatch;

public class Project {
	public static void main(String args[]) {
		ChessMatch chessMatch = new ChessMatch();
		
		UI.printBoard(chessMatch.getPieces());
		
	}
}
