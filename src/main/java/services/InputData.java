package services;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class InputData {
    private static final Logger logger = org.apache.log4j.Logger.getLogger(InputData.class);
    private static final String ROW = "Row";

    /**
     * value entered from the console
     */
    public static int input(String textIndetifier) {
        try {
            Scanner in = new Scanner(System.in);
            if (textIndetifier.equals(ROW)) {
                logger.info("Введите, пожалуйста, строку пустого элемента.");
                int row = in.nextInt();
                return row;
            } else {
                logger.info("Введите,пожалуйста, столбец пустого элемента.");
                int col = in.nextInt();
                return col;
            }
        } catch (Exception e) {
            logger.error("Введенные данные некорректны");
            SearchSolution.inputDataIsCorrect = false;
            return 0;
        }
    }
}
