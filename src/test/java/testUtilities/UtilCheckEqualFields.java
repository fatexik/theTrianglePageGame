package testUtilities;

import catalog.PlayingField;

public class UtilCheckEqualFields {
    private static final int SIZE_OF_ARRAY_PEGS = 5;

    /**
     * compares two game fields
     */
    public static boolean checkEqualFields(PlayingField testField, PlayingField correctField) {
        boolean isEqual = true;
        for (int i = 0; i < SIZE_OF_ARRAY_PEGS; i++) {
            for (int j = 0; j < SIZE_OF_ARRAY_PEGS; j++) {
                if (testField.pegs[i][j] != correctField.pegs[i][j]) {
                    isEqual = false;
                    break;
                }
            }
        }
        return isEqual;
    }
}
