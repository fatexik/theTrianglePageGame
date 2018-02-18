package services;

import catalog.PlayingField;
import org.apache.log4j.Logger;


public class SetEmptyPlace {
    private static final Logger logger = org.apache.log4j.Logger.getLogger(SetEmptyPlace.class);
    static boolean isCorrect = true;

    /**
     * sets an empty space on the playing field
     */
    public static boolean setEmpty(int row, int col, PlayingField currentField) {
        try {
            currentField.pegs[row][col] = false;
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.error("Введенные данные некорректны");
            isCorrect = false;
        }
        return isCorrect;
    }
}
