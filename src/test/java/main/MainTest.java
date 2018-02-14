package main;

import functionalClasses.DfsFunction;
import essenceClasses.PlayingField;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import testUtilities.utilLoadingTestData;
import static org.testng.Assert.*;

public class MainTest {

    @DataProvider(name = "Initialize")
    public static Object[][] checkData() throws IOException {
        ArrayList<Object[]> arrayListTestData = utilLoadingTestData.loadingData();
        Object [][] testData = new Object[arrayListTestData.size()][3];
        for(int i =0 ; i<arrayListTestData.size();i++){
            testData[i] = arrayListTestData.get(i);
        }
        return testData;
    }


    @Test(dataProvider = "Initialize")
    public void testMain(Integer sRow,Integer sCol,String sResult) throws Exception {
        PlayingField startField = new PlayingField(sRow,sCol);
        DfsFunction startDFS = new DfsFunction();
        String programResult = startDFS.DFS(startField);
        assertEquals(programResult,sResult);
    }
}