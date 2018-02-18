package services;

import catalog.Jump;
import catalog.PlayingField;

public class ExecuteJump {
    /**
     * method realizing jump in playing field
     */
    public static PlayingField jump(Jump move, PlayingField currentField) {
        PlayingField playingField = new PlayingField(currentField);
        playingField.pegs[move.startPosition.getRow()][move.startPosition.getCol()] = false;
        playingField.pegs[move.jumpPosition.getRow()][move.jumpPosition.getCol()] = false;
        playingField.pegs[move.endPosition.getRow()][move.endPosition.getCol()] = true;
        playingField.currentJump = move.toString();
        return playingField;
    }
}
