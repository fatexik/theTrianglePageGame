package essenceClasses;


public class PlayingField  {
    final static int SIZEOFARRAYPEGS = 5;
    public boolean[][] pegs = new boolean[SIZEOFARRAYPEGS][SIZEOFARRAYPEGS];
    public String currentJump = new String() ;

    public PlayingField(int emptyRow,int emptyCol){
        for (int i = 0; i < SIZEOFARRAYPEGS; i++)
            for (int j = 0; j <= i; j++)
                pegs[i][j] = true;
        setEmpty(emptyRow,emptyCol);
    }

    public void setEmpty (int row, int col) {
        this.pegs[row][col]=false;
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
