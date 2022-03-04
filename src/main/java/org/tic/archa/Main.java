package org.tic.archa;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputFile = "Assignment1Testcases/testcase1/TitlesInput1.txt";
        String outputFile = "Assignment1Testcases/testcase1/TitlesOutput1.txt";

        List<String> listOfTitles = FileReader.readFile(inputFile);
        listOfTitles = CircularShifter.Shift(listOfTitles);
        Alphabetiser.SortTitle(listOfTitles);
        WriteToFile.main(listOfTitles,outputFile);
    }
}
