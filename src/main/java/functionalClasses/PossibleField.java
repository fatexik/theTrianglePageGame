package functionalClasses;

import essenceClasses.CorrectJumps;
import essenceClasses.JumpClass;
import essenceClasses.PegPosition;
import essenceClasses.PlayingField;
import functionalClasses.Jump;

import java.util.ArrayList;

public class PossibleField {
    final static int SIZEOFARRAYPEGS = 5;
    public static ArrayList<PlayingField> possibleFieldList(PlayingField currentField) {
        ArrayList<PlayingField> boards = new ArrayList<PlayingField>();
        for (int i = 0; i < SIZEOFARRAYPEGS; ++i)
            for (int j = 0; j <= i; ++j) {
                PegPosition start = new PegPosition(i,j);
                ArrayList<JumpClass> possibleMoves = CorrectJumps.getMoves(start);
                for (JumpClass move : possibleMoves) {
                    if (validMove(move,currentField.pegs))
                        boards.add(Jump.jump(move,currentField));
                }
            }

        return boards;
    }

    public static boolean validMove(JumpClass move,boolean[][] pins) {
        if (!pins[move.startPosition.getRow()][move.startPosition.getCol()])	// empty start
            return false;
        if (!pins[move.jumpPosition.getRow()][move.jumpPosition.getCol()])	// empty jump over
            return false;
        if (pins[move.endPosition.getRow()][move.endPosition.getCol()])		// filled in end
            return false;

        return true;
    }
}
