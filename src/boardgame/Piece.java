package boardgame;

public abstract class Piece {
	
	protected Position pos; // Default is null
	private Board board;
	
	
	public Piece(Board board) {
		this.board = board;
	}


	protected Board getBoard() {
		return board;
	}
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position pos) {
		return possibleMoves()[pos.getRow()][pos.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}

}
