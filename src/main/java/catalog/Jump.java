package catalog;

/**
 * class with field values ​​required for a jump
 */
public class Jump {
    public PegPosition startPosition;
    public PegPosition jumpPosition;
    public PegPosition endPosition;

    public Jump(PegPosition startPosition, PegPosition jumpPosition, PegPosition endPosition) {
        this.startPosition = startPosition;
        this.jumpPosition = jumpPosition;
        this.endPosition = endPosition;
    }

    @Override
    public String toString() {
        return (this.startPosition.toString() + "=>" + this.endPosition.toString() + ";");
    }
}
