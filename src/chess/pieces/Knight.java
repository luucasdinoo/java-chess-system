package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

    //private ChessMatch chessMatch;

    public Knight(Board board, Color color) {
        super(board, color);
        //this.chessMatch = chessMatch;
    }
    @Override
    public String toString(){
        return "N";
    }

    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    private boolean testRookCastling(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return  p != null && p instanceof  Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
    }
    @Override
    public boolean[][] possibleMovies() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        p.setValues(position.getRow() - 1, position.getColumn() - 2);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        p.setValues(position.getRow() - 2, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        p.setValues(position.getRow() - 2, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        p.setValues(position.getRow() - 1, position.getColumn() + 2);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        p.setValues(position.getRow() + 1 , position.getColumn() + 2);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        p.setValues(position.getRow() + 2 , position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        p.setValues(position.getRow() + 2 , position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        p.setValues(position.getRow() + 1 , position.getColumn() - 2);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //#Movimento especial castling
       /* if (getMoveCount() == 0 && !chessMatch.getCheck()){
            //#Movimento especial castling do lado do rei
            Position postT1 = new Position(position.getRow(), position.getColumn() + 3);
            if (testRookCastling(postT1)){
                Position p1 = new Position(position.getRow(), position.getColumn() + 1);
                Position p2 = new Position(position.getRow(), position.getColumn() + 2);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null){
                    mat[position.getRow()][position.getColumn() + 2] = true;
                }
            }
        } */
        return mat;
    }
}
