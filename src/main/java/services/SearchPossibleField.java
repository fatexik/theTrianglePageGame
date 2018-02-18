package services;

import catalog.AllPossibleMoves;
import catalog.Jump;
import catalog.PegPosition;
import catalog.PlayingField;

import java.util.ArrayList;

public class SearchPossibleField {
    final static int SIZEOFARRAYPEGS = 5;

    /**
     * all possible playing field after jumping from this position
     */
    public static ArrayList<PlayingField> possibleFieldList(PlayingField currentField) {
        ArrayList<PlayingField> boards = new ArrayList<PlayingField>();
        for (int i = 0; i < SIZEOFARRAYPEGS; ++i)
            for (int j = 0; j <= i; ++j) {
                PegPosition start = new PegPosition(i, j);
                ArrayList<Jump> possibleMoves = AllPossibleMoves.getMoves(start);
                for (Jump move : possibleMoves) {
                    if (validMove(move, currentField.pegs))
                        boards.add(ExecuteJump.jump(move, currentField));
                }
            }

        return boards;
    }

    /**
     * check the correctness of the jump
     */
    public static boolean validMove(Jump move, boolean[][] pins) {
        if (!pins[move.startPosition.getRow()][move.startPosition.getCol()])
            return false;
        if (!pins[move.jumpPosition.getRow()][move.jumpPosition.getCol()])
            return false;
        if (pins[move.endPosition.getRow()][move.endPosition.getCol()])
            return false;

        return true;
    }
}
