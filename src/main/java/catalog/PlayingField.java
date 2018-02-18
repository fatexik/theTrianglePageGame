package catalog;


import org.apache.log4j.Logger;
import services.SearchSolution;

import static javafx.application.Platform.exit;

/**
 * class describing the game board ( matrix of boolean )
 */
public class PlayingField {
    final static int SIZEOFARRAYPEGS = 5;
    public boolean[][] pegs = new boolean[SIZEOFARRAYPEGS][SIZEOFARRAYPEGS];
    public String currentJump = new String();
    private static final Logger logger = org.apache.log4j.Logger.getLogger(PlayingField.class);

    public PlayingField() {
        for (int i = 0; i < SIZEOFARRAYPEGS; i++)
            for (int j = 0; j <= i; j++)
                pegs[i][j] = true;
    }

    public PlayingField(PlayingField that) {
        for (int i = 0; i < SIZEOFARRAYPEGS; ++i)
            for (int j = 0; j <= i; ++j)
                pegs[i][j] = that.pegs[i][j];
    }

    public boolean finalField() {
        int remainingPins = 0;

        for (int i = 0; i < SIZEOFARRAYPEGS; ++i)
            for (int j = 0; j <= i; ++j)
                if (this.pegs[i][j]) {
                    remainingPins++;
                }
        return remainingPins == 1;
    }
}
