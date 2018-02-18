package testUtilities;

import catalog.PlayingField;

public class UtilSetFinalField {
    private static final int SIZE_OF_ARRAY_PEGS = 5;

    /**
     * sets a field with one peg
     */
    public static PlayingField setFinalField(PlayingField testField) {
        for (int i = 1; i < SIZE_OF_ARRAY_PEGS; i++) {
            for (int j = 0; j < SIZE_OF_ARRAY_PEGS; j++) {
                testField.pegs[i][j] = false;
            }
        }
        return testField;
    }
}
