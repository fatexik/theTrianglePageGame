package functionalClasses;

import essenceClasses.PlayingField;
import essenceClasses.SolutionThree;

import java.util.ArrayList;

public class DfsFunction {
    public String DFS(PlayingField startField) {
        SolutionThree rootSolutionThree = new SolutionThree(startField);
        for (PlayingField nextField : PossibleField.possibleFieldList(startField)) {
            SolutionThree nextNode = new SolutionThree(nextField);
            if (search(nextField, nextNode))
                rootSolutionThree.addChild(nextNode);
        }
        return PrintSolution.printWinningGame(rootSolutionThree);
    }

    private boolean search(PlayingField playingField, SolutionThree solutionThree) {

        if (playingField.finalField())
            return true;

        ArrayList<PlayingField> nextFields = PossibleField.possibleFieldList(playingField);

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