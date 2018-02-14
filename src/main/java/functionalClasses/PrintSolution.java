package functionalClasses;

import essenceClasses.SolutionThree;

public class PrintSolution {
    final static int SIZEOFARRAYPEGS = 5;
    public static String  printWinningGame(SolutionThree parent) {
        String jumpTrack = new String();
        for (int i = 0; i < SIZEOFARRAYPEGS; i++) {
            for (int j = 0; j < SIZEOFARRAYPEGS; j++) {
                System.out.print(parent.getGameBoard()[i][j] + " ");
            }
            System.out.println();
        }
        jumpTrack+=parent.allMoveField;
        System.out.println("===============================================");

        if (parent.numChildren() > 0) {
            SolutionThree nextNode = parent.getFirstChild();
            jumpTrack+=printWinningGame(nextNode);
            if (nextNode.numChildren() == 0)
                parent.removeFirstChild();
        }
        return jumpTrack;
    }
}
