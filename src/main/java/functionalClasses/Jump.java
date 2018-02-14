package functionalClasses;

import essenceClasses.JumpClass;
import essenceClasses.PlayingField;

public class Jump {
    public static PlayingField jump(JumpClass move, PlayingField currentField){
        PlayingField playingField = new PlayingField(currentField);
        playingField.pegs[move.startPosition.getRow()][move.startPosition.getCol()] = false;
        playingField.pegs[move.jumpPosition.getRow()][move.jumpPosition.getCol()] = false;
        playingField.pegs[move.endPosition.getRow()][move.endPosition.getCol()] = true;
        playingField.currentJump = move.toString();
        return playingField;
    }
}
