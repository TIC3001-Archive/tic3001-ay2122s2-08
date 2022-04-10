package org.tic.archb;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Master {

    public Master() {
    }

    public void runProgram(String inputFile, String outputFile, String ignored, String required) {

        // read and store titles
        FileReader readInputFile = new FileReader(inputFile);
        Words titles = new Words();
        readInputFile.populateWords(titles);

        // read and store ignored words
        FileReader readIgnoreWordsFile = new FileReader(ignored);
        Words ignoreWords = new Words();
        readIgnoreWordsFile.populateWords(ignoreWords);

        // read and store required word
        FileReader readRequiredWordsFile = new FileReader(required);
        Words requiredWords = new Words();
        readRequiredWordsFile.populateWords(requiredWords);

        //Filters out required words in title, then removes ignored words
        CircularShift circularShift = new CircularShift(titles,ignoreWords,requiredWords);
        circularShift.generateShift();

        Alphabetiser alphaShifter = new Alphabetiser(circularShift);

        WriteToFile fileOutput = new WriteToFile(outputFile);
        fileOutput.writeOutput(alphaShifter);

    }

    public void runProgram2(String inputFile, List<String> iw, List<String> sw){

        FileReader readInputFile = new FileReader(inputFile);
        Words titles = new Words();
        readInputFile.populateWords(titles);

        Words ignoreWords = new Words();
        ignoreWords.setWords(iw);

        Words requiredWords = new Words();
        requiredWords.setWords(sw);

        CircularShift circularShift = new CircularShift(titles,ignoreWords,requiredWords);
        circularShift.generateShift();

        Alphabetiser alphaShifter = new Alphabetiser(circularShift);

        ArrangeAndPrintStuff(alphaShifter, inputFile, sw);

    }

    public static void ArrangeAndPrintStuff(Alphabetiser alphaShifter,String inputFile, List<String> sw){
        List<String> finalWords = new ArrayList<>();
        for (String SortedTitles: alphaShifter.getSortedTitles()){
            for(String SearchWord: sw){
                if(Objects.equals(SearchWord, SortedTitles.split(" ")[0].toLowerCase(Locale.ROOT))){
                    finalWords.add(SortedTitles);
                }
            }
        }

        //Print stuff out
        if (finalWords.size() != 0){
            String[] filename = inputFile.split("/");
            System.out.println(filename[(filename.length) -1]);
            for(String stuff: finalWords) System.out.println(stuff);
            System.out.println("\r\n");
        }
    }

}
