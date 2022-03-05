package org.tic.archa;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String testcase = "1";
        String inputFile = "Assignment1Testcases/testcase"+testcase+"/TitlesInput.txt";
        String outputFile = "Assignment1Testcases/testcase"+testcase+"/TitlesOutputA.txt";

        List<String> listOfTitles = FileReader.readFile(inputFile);
        listOfTitles = CircularShifter.Shift(listOfTitles);
        Alphabetiser.SortTitle(listOfTitles);
        WriteToFile.main(listOfTitles,outputFile);
    }
}
