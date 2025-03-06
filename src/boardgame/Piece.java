package boardgame;

public class Piece {
	
	protected Position pos; // Default is null
	private Board board;
	
	
	public Piece(Board board) {
		this.board = board;
	}


	protected Board getBoard() {
		return board;
	}

}
