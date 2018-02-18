package services;

import catalog.PlayingField;
import catalog.SolutionThree;

import java.util.ArrayList;

public class DfsFunction {
    /**
     * method calling the recursive function of DFS (depth-first search)
     */
    public String DFS(PlayingField startField) {
        SolutionThree rootSolutionThree = new SolutionThree(startField);
        for (PlayingField nextField : SearchPossibleField.possibleFieldList(startField)) {
            SolutionThree nextNode = new SolutionThree(nextField);
            if (search(nextField, nextNode))
                rootSolutionThree.addChild(nextNode);
        }
        return PrintSolution.printWinningGame(rootSolutionThree);
    }

    /**
     * in-depth method, returns true if the solution is found
     */
    private boolean search(PlayingField playingField, SolutionThree solutionThree) {

        if (playingField.finalField())
            return true;

        ArrayList<PlayingField> nextFields = SearchPossibleField.possibleFieldList(playingField);

        boolean found = false;

        for (PlayingField nextField : nextFields) {
            SolutionThree nextNode = new SolutionThree(nextField);
            if (search(nextField, nextNode)) {
                found = true;
                solutionThree.addChild(nextNode);
            }
        }
        return found;
    }


}