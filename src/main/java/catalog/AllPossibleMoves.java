package catalog;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class define all possible moves from all position in playing field.
 */
public class AllPossibleMoves {
    private static final Logger logger = org.apache.log4j.Logger.getLogger(AllPossibleMoves.class);
    private static HashMap<PegPosition, ArrayList<Jump>> validMoves = new HashMap<PegPosition, ArrayList<Jump>>();

    static {
        PegPosition start;

        start = new PegPosition(0, 0);
        validMoves.put(start, new ArrayList<Jump>());
        validMoves.get(start).add(new Jump(start, new PegPosition(1, 0), new PegPosition(2, 0)));
        validMoves.get(start).add(new Jump(start, new PegPosition(1, 1), new PegPosition(2, 2)));

        start = new PegPosition(1, 0);
        validMoves.put(start, new ArrayList<Jump>());
        validMoves.get(start).add(new Jump(start, new PegPosition(2, 0), new PegPosition(3, 0)));
        validMoves.get(start).add(new Jump(start, new PegPosition(2, 1), new PegPosition(3, 2)));
        start = new PegPosition(1, 1);
        validMoves.put(start, new ArrayList<Jump>());
        validMoves.get(start).add(new Jump(start, new PegPosition(2, 1), new PegPosition(3, 1)));
        validMoves.get(start).add(new Jump(start, new PegPosition(2, 2), new PegPosition(3, 3)));

        start = new PegPosition(2, 0);
        validMoves.put(start, new ArrayList<Jump>());
        validMoves.get(start).add(new Jump(start, new PegPosition(1, 0), new PegPosition(0, 0)));
        validMoves.get(start).add(new Jump(start, new PegPosition(2, 1), new PegPosition(2, 2)));
        validMoves.get(start).add(new Jump(start, new PegPosition(3, 0), new PegPosition(4, 0)));
        validMoves.get(start).add(new Jump(start, new PegPosition(3, 1), new PegPosition(4, 2)));

        start = new PegPosition(2, 1);
        validMoves.put(start, new ArrayList<Jump>());
        validMoves.get(start).add(new Jump(start, new PegPosition(3, 1), new PegPosition(4, 1)));
        validMoves.get(start).add(new Jump(start, new PegPosition(3, 2), new PegPosition(4, 3)));

        start = new PegPosition(2, 2);
        validMoves.put(start, new ArrayList<Jump>());
        validMoves.get(start).add(new Jump(start, new PegPosition(1, 1), new PegPosition(0, 0)));
        validMoves.get(start).add(new Jump(start, new PegPosition(2, 1), new PegPosition(2, 0)));
        validMoves.get(start).add(new Jump(start, new PegPosition(3, 2), new PegPosition(4, 2)));
        validMoves.get(start).add(new Jump(start, new PegPosition(3, 3), new PegPosition(4, 4)));

        start = new PegPosition(3, 0);
        validMoves.put(start, new ArrayList<Jump>());
        validMoves.get(start).add(new Jump(start, new PegPosition(2, 0), new PegPosition(1, 0)));
        validMoves.get(start).add(new Jump(start, new PegPosition(3, 1), new PegPosition(3, 2)));

        start = new PegPosition(3, 1);
        validMoves.put(start, new ArrayList<Jump>());
        validMoves.get(start).add(new Jump(start, new PegPosition(2, 1), new PegPosition(1, 1)));
        validMoves.get(start).add(new Jump(start, new PegPosition(3, 2), new PegPosition(3, 3)));

        start = new PegPosition(3, 2);
        validMoves.put(start, new ArrayList<Jump>());
        validMoves.get(start).add(new Jump(start, new PegPosition(2, 1), new PegPosition(1, 0)));
        validMoves.get(start).add(new Jump(start, new PegPosition(3, 1), new PegPosition(3, 0)));

        start = new PegPosition(3, 3);
        validMoves.put(start, new ArrayList<Jump>());
        validMoves.get(start).add(new Jump(start, new PegPosition(2, 2), new PegPosition(1, 1)));
        validMoves.get(start).add(new Jump(start, new PegPosition(3, 2), new PegPosition(3, 1)));

        start = new PegPosition(4, 0);
        validMoves.put(start, new ArrayList<Jump>());
        validMoves.get(start).add(new Jump(start, new PegPosition(3, 0), new PegPosition(2, 0)));
        validMoves.get(start).add(new Jump(start, new PegPosition(4, 1), new PegPosition(4, 2)));

        start = new PegPosition(4, 1);
        validMoves.put(start, new ArrayList<Jump>());
        validMoves.get(start).add(new Jump(start, new PegPosition(3, 1), new PegPosition(2, 1)));
        validMoves.get(start).add(new Jump(start, new PegPosition(4, 2), new PegPosition(4, 3)));

        start = new PegPosition(4, 2);
        validMoves.put(start, new ArrayList<Jump>());
        validMoves.get(start).add(new Jump(start, new PegPosition(3, 1), new PegPosition(2, 0)));
        validMoves.get(start).add(new Jump(start, new PegPosition(3, 2), new PegPosition(2, 2)));
        validMoves.get(start).add(new Jump(start, new PegPosition(4, 1), new PegPosition(4, 0)));
        validMoves.get(start).add(new Jump(start, new PegPosition(4, 3), new PegPosition(4, 4)));

        start = new PegPosition(4, 3);
        validMoves.put(start, new ArrayList<Jump>());
        validMoves.get(start).add(new Jump(start, new PegPosition(3, 2), new PegPosition(2, 1)));
        validMoves.get(start).add(new Jump(start, new PegPosition(4, 2), new PegPosition(4, 1)));

        start = new PegPosition(4, 4);
        validMoves.put(start, new ArrayList<Jump>());
        validMoves.get(start).add(new Jump(start, new PegPosition(3, 3), new PegPosition(2, 2)));
        validMoves.get(start).add(new Jump(start, new PegPosition(4, 3), new PegPosition(4, 2)));
    }


    /**
     * return list all moves from this position
     */
    public static ArrayList<Jump> getMoves(PegPosition pegPosition) {
        if (!validMoves.containsKey(pegPosition)) {
            throw new RuntimeException("Некорректная позиция: " + pegPosition);
        }
        return validMoves.get(pegPosition);
    }

    public String toString() {
        return validMoves.toString();
    }
}

