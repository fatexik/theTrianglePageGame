package services;

import catalog.PlayingField;
import org.apache.log4j.Logger;

public class CheckEmptySpace {
    private static final Logger logger = org.apache.log4j.Logger.getLogger(CheckEmptySpace.class);
    final static int SIZEOFARRAYPEGS = 5;

    /**
     * Method for checking the presence of an empty spot on the game board
     */
    public static boolean checkEmptySpace(PlayingField currentField) {
        for (int i = 0; i < SIZEOFARRAYPEGS; i++) {
            for (int j = 0; j <= i; j++) {
                if (currentField.pegs[i][j] == false) {
                    return true;
                }
            }
        }
        logger.error("Начальная позиция неккоректна");
        return false;
    }
}
