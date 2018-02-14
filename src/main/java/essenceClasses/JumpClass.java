package essenceClasses;

public class JumpClass {
    public PegPosition startPosition;
    public PegPosition jumpPosition;
    public PegPosition endPosition;


    public JumpClass(PegPosition startPosition,PegPosition jumpPosition,PegPosition endPosition){
        this.startPosition = startPosition;
        this.jumpPosition = jumpPosition;
        this.endPosition = endPosition;
    }

    @Override
    public String toString() {
        return (this.startPosition.toString()+"=>"+this.endPosition.toString()+";");
    }
}
