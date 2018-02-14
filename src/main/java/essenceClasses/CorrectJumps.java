package essenceClasses;

import java.util.ArrayList;
import java.util.HashMap;

public class CorrectJumps {
    private static HashMap < PegPosition, ArrayList<JumpClass>> validMoves = new HashMap< PegPosition,ArrayList<JumpClass> >();
    static {
        PegPosition start;

        start = new PegPosition(0,0);
        validMoves.put(start, new ArrayList<JumpClass>());
        validMoves.get(start).add(new JumpClass(start, new PegPosition(1,0), new PegPosition(2,0)));
        validMoves.get(start).add(new JumpClass(start, new PegPosition(1,1), new PegPosition(2,2)));

        start = new PegPosition(1,0);
        validMoves.put(start, new ArrayList<JumpClass>());
        validMoves.get(start).add(new JumpClass(start, new PegPosition(2,0), new PegPosition(3,0)));
        validMoves.get(start).add(new JumpClass(start, new PegPosition(2,1), new PegPosition(3,2)));
        start = new PegPosition(1,1);
        validMoves.put(start, new ArrayList<JumpClass>());
        validMoves.get(start).add(new JumpClass(start, new PegPosition(2,1), new PegPosition(3,1)));
        validMoves.get(start).add(new JumpClass(start, new PegPosition(2,2), new PegPosition(3,3)));

        start = new PegPosition(2,0);
        validMoves.put(start, new ArrayList<JumpClass>());
        validMoves.get(start).add(new JumpClass(start, new PegPosition(1,0), new PegPosition(0,0)));
        validMoves.get(start).add(new JumpClass(start, new PegPosition(2,1), new PegPosition(2,2)));
        validMoves.get(start).add(new JumpClass(start, new PegPosition(3,0), new PegPosition(4,0)));
        validMoves.get(start).add(new JumpClass(start, new PegPosition(3,1), new PegPosition(4,2)));

        start = new PegPosition(2,1);
        validMoves.put(start, new ArrayList<JumpClass>());
        validMoves.get(start).add(new JumpClass(start, new PegPosition(3,1), new PegPosition(4,1)));
        validMoves.get(start).add(new JumpClass(start, new PegPosition(3,2), new PegPosition(4,3)));

        start = new PegPosition(2,2);
        validMoves.put(start, new ArrayList<JumpClass>());
        validMoves.get(start).add(new JumpClass(start, new PegPosition(1,1), new PegPosition(0,0)));
        validMoves.get(start).add(new JumpClass(start, new PegPosition(2,1), new PegPosition(2,0)));
        validMoves.get(start).add(new JumpClass(start, new PegPosition(3,2), new PegPosition(4,2)));
        validMoves.get(start).add(new JumpClass(start, new PegPosition(3,3), new PegPosition(4,4)));

        start = new PegPosition(3,0);
        validMoves.put(start, new ArrayList<JumpClass>());
        validMoves.get(start).add(new JumpClass(start, new PegPosition(2,0), new PegPosition(1,0)));
        validMoves.get(start).add(new JumpClass(start, new PegPosition(3,1), new PegPosition(3,2)));

        start = new PegPosition(3,1);
        validMoves.put(start, new ArrayList<JumpClass>());
        validMoves.get(start).add(new JumpClass(start, new PegPosition(2,1), new PegPosition(1,1)));
        validMoves.get(start).add(new JumpClass(start, new PegPosition(3,2), new PegPosition(3,3)));

        start = new PegPosition(3,2);
        validMoves.put(start, new ArrayList<JumpClass>());
        validMoves.get(start).add(new JumpClass(start, new PegPosition(2,1), new PegPosition(1,0)));
        validMoves.get(start).add(new JumpClass(start, new PegPosition(3,1), new PegPosition(3,0)));

        start = new PegPosition(3,3);
        validMoves.put(start, new ArrayList<JumpClass>());
        validMoves.get(start).add(new JumpClass(start, new PegPosition(2,2), new PegPosition(1,1)));
        validMoves.get(start).add(new JumpClass(start, new PegPosition(3,2), new PegPosition(3,1)));

        start = new PegPosition(4,0);
        validMoves.put(start, new ArrayList<JumpClass>());
        validMoves.get(start).add(new JumpClass(start, new PegPosition(3,0), new PegPosition(2,0)));
        validMoves.get(start).add(new JumpClass(start, new PegPosition(4,1), new PegPosition(4,2)));

        start = new PegPosition(4,1);
        validMoves.put(start, new ArrayList<JumpClass>());
        validMoves.get(start).add(new JumpClass(start, new PegPosition(3,1), new PegPosition(2,1)));
        validMoves.get(start).add(new JumpClass(start, new PegPosition(4,2), new PegPosition(4,3)));

        start = new PegPosition(4,2);
        validMoves.put(start, new ArrayList<JumpClass>());
        validMoves.get(start).add(new JumpClass(start, new PegPosition(3,1), new PegPosition(2,0)));
        validMoves.get(start).add(new JumpClass(start, new PegPosition(3,2), new PegPosition(2,2)));
        validMoves.get(start).add(new JumpClass(start, new PegPosition(4,1), new PegPosition(4,0)));
        validMoves.get(start).add(new JumpClass(start, new PegPosition(4,3), new PegPosition(4,4)));

        start = new PegPosition(4,3);
        validMoves.put(start, new ArrayList<JumpClass>());
        validMoves.get(start).add(new JumpClass(start, new PegPosition(3,2), new PegPosition(2,1)));
        validMoves.get(start).add(new JumpClass(start, new PegPosition(4,2), new PegPosition(4,1)));

        start = new PegPosition(4,4);
        validMoves.put(start, new ArrayList<JumpClass>());
        validMoves.get(start).add(new JumpClass(start, new PegPosition(3,3), new PegPosition(2,2)));
        validMoves.get(start).add(new JumpClass(start, new PegPosition(4,3), new PegPosition(4,2)));
    }


    public static ArrayList<JumpClass> getMoves(PegPosition pegPosition) {
        if (!validMoves.containsKey(pegPosition))
            throw new RuntimeException("Invalid position: " + pegPosition);

        return validMoves.get(pegPosition);
    }

        public String toString() {
            return validMoves.toString();
        }
}

