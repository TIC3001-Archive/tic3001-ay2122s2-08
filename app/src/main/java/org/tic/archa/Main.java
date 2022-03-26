package org.tic.archa;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String testcase = "1";
        //String inputFile = args[0] + "/TitlesInput.txt";
        //String outputFile = args[0] +"/TitlesOutputA.txt";

        String inputFile = "/Users/gopal/Document/TIC3001/Ass 2/Assignemnt2Testcases/Test1/Titles1.txt";
        String outputFile = "/Users/gopal/Document/TIC3001/Ass 2/Assignemnt2Testcases/Test1/TitlesOutputA.txt";
        String ignoreWordsFile = "/Users/gopal/Document/TIC3001/Ass 2/Assignemnt2Testcases/Test1/Ignored1.txt";
        String mustHaveWordsFile = "/Users/gopal/Document/TIC3001/Ass 2/Assignemnt2Testcases/Test1/Required1.txt";


        List<String> listOfTitles = FileReader.readFile(inputFile);
        listOfTitles = CircularShifter.Shift(listOfTitles,ignoreWordsFile,mustHaveWordsFile);
        Alphabetiser.SortTitle(listOfTitles);
        WriteToFile.main(listOfTitles,outputFile);
    }
}
