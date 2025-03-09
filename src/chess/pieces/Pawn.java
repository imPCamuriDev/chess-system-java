package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
	}

	@Override
	public boolean[][] possibleMoves() {
 		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
 		
 		Position p = new Position(0, 0);
 
 		if (getColor() == Color.WHITE) {
 			p.setValues(pos.getRow() - 1, pos.getColumn());
 			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
 				mat[p.getRow()][p.getColumn()] = true;
 			}
 			p.setValues(pos.getRow() - 2, pos.getColumn());
 			Position p2 = new Position(pos.getRow() - 1, pos.getColumn());
 			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
 				mat[p.getRow()][p.getColumn()] = true;
 			}
 			p.setValues(pos.getRow() - 1, pos.getColumn() - 1);
 			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
 				mat[p.getRow()][p.getColumn()] = true;
 			}			
 			p.setValues(pos.getRow() - 1, pos.getColumn() + 1);
 			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
 				mat[p.getRow()][p.getColumn()] = true;
 			}			
 		}
 		else {
 			p.setValues(pos.getRow() + 1, pos.getColumn());
 			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
 				mat[p.getRow()][p.getColumn()] = true;
 			}
 			p.setValues(pos.getRow() + 2, pos.getColumn());
 			Position p2 = new Position(pos.getRow() + 1, pos.getColumn());
 			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}
 			p.setValues(pos.getRow() + 1, pos.getColumn() - 1);
 			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
 				mat[p.getRow()][p.getColumn()] = true;
 			}			
 			p.setValues(pos.getRow() + 1, pos.getColumn() + 1);
 			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
 				mat[p.getRow()][p.getColumn()] = true;
 			}	
 		}
 		return mat;
 	}
	
	@Override
 	public String toString() {
 		return "P";
 	}
	
}
