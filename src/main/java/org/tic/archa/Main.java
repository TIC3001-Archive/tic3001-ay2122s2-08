package org.tic.archa;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String testcase = "1";
        String inputFile = args[0] + "/TitlesInput.txt";
        String outputFile = args[0] +"/TitlesOutputA.txt";

        List<String> listOfTitles = FileReader.readFile(inputFile);
        listOfTitles = CircularShifter.Shift(listOfTitles);
        Alphabetiser.SortTitle(listOfTitles);
        WriteToFile.main(listOfTitles,outputFile);
    }
}
