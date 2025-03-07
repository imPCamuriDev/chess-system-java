package boardgame;

public class Board {
	private Integer rows;
	private Integer columns;
	private Piece[][] pieces;

	public Board(Integer rows, Integer columns) {

		if (rows < 1 || columns < 1) {
			throw new BoardException("Error creating Board: there must be at a least 1 row and 1 column.");
		}

		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public Integer getRows() {
		return rows;
	}

//	public void setRows(Integer rows) {
//		this.rows = rows;
//	}

	public Integer getColumns() {
		return columns;
	}

//	public void setColumns(Integer columns) {
//		this.columns = columns;
//	}

	public Piece piece(Integer row, Integer column) {
		if (!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}

	public Piece piece(Position pos) {
		if (!positionExists(pos)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[pos.getRow()][pos.getColumn()];
	}

	public void placePiece(Piece piece, Position pos) {
		if (thereIsAPiece(pos)) {
			throw new BoardException("I already had a piece in this position " + pos);
		}
		pieces[pos.getRow()][pos.getColumn()] = piece;
		piece.pos = pos;
	}

	public Piece removePiece(Position pos) {
		if (!positionExists(pos)) {
			throw new BoardException("Position not on the board");
		}
		if (piece(pos) == null) {
			return null;
		}
		Piece aux = piece(pos);
		aux.pos = null;
		pieces[pos.getRow()][pos.getColumn()] = null;
		return aux;
	}

	
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

	public boolean positionExists(Position pos) {
		return positionExists(pos.getRow(), pos.getColumn());
	}

	public boolean thereIsAPiece(Position pos) {
		if (!positionExists(pos)) {
			throw new BoardException("Position not on the board");
		}
		return piece(pos) != null;
	}

}
