package catalog;

/**
 * class describing the peg on the playing field
 */
public class PegPosition {
    private int row;
    private int col;

    public PegPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int hashCode() {
        int result = 8;

        result = 21 * result + row;
        result = 21 * result + col;

        return result;
    }

    public boolean equals(Object other) {
        if (!(other instanceof PegPosition))
            return false;
        PegPosition that = (PegPosition) other;

        if (this.row != that.row)
            return false;

        return this.col == that.col;
    }

    @Override
    public String toString() {
        return (Integer.toString(this.row) + Integer.toString(this.col));
    }
}
