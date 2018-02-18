package services;

import catalog.Jump;
import catalog.PegPosition;
import org.apache.log4j.Logger;
import catalog.PlayingField;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

import testUtilities.UtilCheckEqualFields;
import testUtilities.UtilLoadingTestData;
import testUtilities.UtilSetFinalField;

import static org.testng.Assert.*;
import static services.SearchSolution.emptyPositionIsCorrect;

public class DataDrivenTestCorrectData {
    private static final Logger logger = org.apache.log4j.Logger.getLogger(DataDrivenTestCorrectData.class);
    private static final int SHEET_WITH_CORRECT_DATA = 0;

    @DataProvider(name = "Initialize")
    public static Object[][] checkData() throws IOException {
        ArrayList<Object[]> arrayListTestData = UtilLoadingTestData.loadingData(SHEET_WITH_CORRECT_DATA);
        Object[][] testData = new Object[arrayListTestData.size()][3];
        for (int i = 0; i < arrayListTestData.size(); i++) {
            testData[i] = arrayListTestData.get(i);
        }
        return testData;
    }

    public static String programResult;

    @Test(dataProvider = "Initialize")
    public void testMain(Integer sRow, Integer sCol, String sResult) {
        PlayingField startField = new PlayingField();
        emptyPositionIsCorrect = SetEmptyPlace.setEmpty(sRow, sCol, startField);
        if ((emptyPositionIsCorrect) && ((CheckEmptySpace.checkEmptySpace(startField)))) {
            DfsFunction startDFS = new DfsFunction();
            programResult = startDFS.DFS(startField);
        } else {
            programResult = "Ошибка значения данных";
        }
        logger.info(programResult);
        assertEquals(programResult, sResult);
    }

    @Test
    public void testExecuteJump() {
        boolean expectedResult = true;
        PlayingField testField = new PlayingField();
        PlayingField correctField = new PlayingField();
        correctField.pegs[2][0] = false;
        correctField.pegs[1][0] = false;
        testField.pegs[0][0] = false;
        PegPosition startPosition = new PegPosition(2, 0);
        PegPosition endPosition = new PegPosition(0, 0);
        PegPosition jumpPosition = new PegPosition(1, 0);
        Jump testJump = new Jump(startPosition, jumpPosition, endPosition);
        testField = ExecuteJump.jump(testJump, testField);
        boolean programResult = UtilCheckEqualFields.checkEqualFields(testField, correctField);
        assertEquals(expectedResult, programResult);
    }

    @Test
    public void testSetEmptyPlace() {
        boolean expectedResult = true;
        PlayingField testField = new PlayingField();
        PlayingField correctField = new PlayingField();
        correctField.pegs[1][0] = false;
        SetEmptyPlace.setEmpty(1, 0, testField);
        boolean methodResult = UtilCheckEqualFields.checkEqualFields(testField, correctField);
        assertEquals(expectedResult, methodResult);
    }

    @Test
    public void testCheckEmptySpaceNegative() {
        boolean expectedResult = false;
        PlayingField testField = new PlayingField();
        testField.pegs[3][1] = false;
        testField.pegs[4][2] = false;
        boolean methodResult = testField.finalField();
        assertEquals(expectedResult, methodResult);
    }

    @Test
    public void testCheckEmptySpacePositive() {
        boolean expectedResult = true;
        PlayingField testField = new PlayingField();
        testField = UtilSetFinalField.setFinalField(testField);
        boolean methodResult = testField.finalField();
        assertEquals(expectedResult, methodResult);
    }
}