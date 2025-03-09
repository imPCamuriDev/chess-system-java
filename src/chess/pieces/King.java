package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
	private ChessMatch chessmatch;

	public King(Board board, Color color, ChessMatch chessmatch) {
		super(board, color);
		this.chessmatch = chessmatch;
	}
	
	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position pos) {
		ChessPiece p = (ChessPiece) getBoard().piece(pos);
		return p == null || p.getColor() != getColor();
	}
	
	private boolean testRookCastling(Position rookPos) {
		ChessPiece p = (ChessPiece) getBoard().piece(rookPos);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		// above
		p.setValues(pos.getRow() - 1, pos.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// below
		p.setValues(pos.getRow() + 1, pos.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// left
		p.setValues(pos.getRow(), pos.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// right
		p.setValues(pos.getRow(), pos.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		// nw
		p.setValues(pos.getRow() - 1, pos.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// ne
		p.setValues(pos.getRow() - 1, pos.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// sw
		p.setValues(pos.getRow() + 1, pos.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// se
		p.setValues(pos.getRow() + 1, pos.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// # SPECIAL MOVE CASTLING
		if (getMoveCount() == 0 && !chessmatch.getCheck()) {
			// # SPECIAL MOVE CASTLING KINGSIDE ROOK
			Position rookPos1 = new Position(pos.getRow(), pos.getColumn() + 3);
			if (testRookCastling(rookPos1)) {
				Position p1 = new Position(pos.getRow(), pos.getColumn() + 1);
				Position p2 = new Position(pos.getRow(), pos.getColumn() + 2);
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					mat[pos.getRow()][pos.getColumn() + 2] = true;
				}
			}
			// # SPECIAL MOVE CASTLING QUEENSIDE ROOK
			Position rookPos2 = new Position(pos.getRow(), pos.getColumn() - 4);
			if (testRookCastling(rookPos2)) {
				Position p1 = new Position(pos.getRow(), pos.getColumn() - 1);
				Position p2 = new Position(pos.getRow(), pos.getColumn() - 2);
				Position p3 = new Position(pos.getRow(), pos.getColumn() - 3);
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
					mat[pos.getRow()][pos.getColumn() - 2] = true;
				}
			}
		}
		
		return mat;
	}

}
