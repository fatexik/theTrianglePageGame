package essenceClasses;

import java.util.ArrayList;
import java.util.List;

public class SolutionThree {

    final static int SIZEOFARRAYPEGS = 5;

    List<SolutionThree> children = new ArrayList<SolutionThree>();

    PlayingField playingField;
    public String allMoveField;

    public SolutionThree(PlayingField playingField) {
        this.playingField = playingField;
        this.allMoveField = playingField.currentJump;
    }

    public void addChild(SolutionThree child) {

        children.add(child);
    }

    public String[][] getGameBoard() {
        String[][] result = new String[SIZEOFARRAYPEGS][SIZEOFARRAYPEGS];
        for (int i =0; i < SIZEOFARRAYPEGS;i++) {
            for (int j = 0; j < SIZEOFARRAYPEGS; j++) {
                result[i][j] = "\u0020";
            }
        }
        for (int i = 0; i < SIZEOFARRAYPEGS; i++)
            for (int j = 0; j <= i; j++){
            if (this.playingField.pegs[i][j])
                result[i][j]="\u058E";
            else
                result[i][j]="\u004F";
            }
        return result;
    }


    public SolutionThree getFirstChild() {

        return children.get(0);
    }

    public void removeFirstChild() {
        children.remove(0);
    }

    public int numChildren() {
        return children.size();
    }
}
