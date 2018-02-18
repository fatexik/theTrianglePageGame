package services;

import catalog.PlayingField;
import org.apache.log4j.Logger;

public class SearchSolution {
    final static String ROW = "Row";
    final static String COL = "Col";
    private static Integer row, col;
    public static boolean inputDataIsCorrect = true, emptyPositionIsCorrect = true;

    public static String programResult;
    private static final Logger logger = org.apache.log4j.Logger.getLogger(SearchSolution.class);

    public static void main(String[] args) {
        PlayingField startField = new PlayingField();
        row = InputData.input(ROW);
        col = InputData.input(COL);
        if ((inputDataIsCorrect)) {
            emptyPositionIsCorrect = SetEmptyPlace.setEmpty(row, col, startField);
            if ((emptyPositionIsCorrect) && ((CheckEmptySpace.checkEmptySpace(startField)))) {
                DfsFunction startDFS = new DfsFunction();
                programResult = startDFS.DFS(startField);
            } else {
                programResult = "Ошибка значения данных";
            }
        } else {
            programResult = "Ошибка формата данных";
        }
        logger.info(programResult);
    }
}