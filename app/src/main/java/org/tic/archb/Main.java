package org.tic.archb;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        /*String inputFile = args[0] ;
        String ignoreWordsFile = args[1] ;
        String mustHaveWordsFile = args[2] ;
        String outputFile = args[3] +"/TitlesOutput.txt";*/

        /* Assignment 2 Code
        String testcase = "3";
        String inputFile = "/Users/gopal/Document/TIC3001/Ass 2/Assignment2Testcases/Test" + testcase + "/Titles" + testcase + ".txt";
        String outputFile = "/Users/gopal/Document/TIC3001/Ass 2/Assignment2Testcases/Test" + testcase + "/TitlesOutputA.txt";
        String ignoreWordsFile = "/Users/gopal/Document/TIC3001/Ass 2/Assignment2Testcases/Test" + testcase + "/Ignored" + testcase + ".txt";
        String mustHaveWordsFile = "/Users/gopal/Document/TIC3001/Ass 2/Assignment2Testcases/Test" + testcase + "/Required" + testcase + ".txt";

        Master abstractDateType = new Master(inputFile,outputFile,ignoreWordsFile,mustHaveWordsFile);
        abstractDateType.runProgram();
         */



        String inputFile = "/Users/gopal/Document/TIC3001/Assignment3/ListOfFiles4.txt";

        // Read main file
        FileReader readInputFile = new FileReader(inputFile);
        Words ListOfFiles = new Words();
        readInputFile.populateWords(ListOfFiles);

        List<String> searchedWords = new ArrayList<>();
        List<String> ignoredWords = new ArrayList<>();


        Scanner scan = new Scanner(System.in);
        String userInput = scan.nextLine();
        while(!userInput.equals("q") ){

            if ((userInput.split(" ")).length == 1) {
                // prevent duplicate search
                if(checkIfSearchWordAlreadyExsist(searchedWords,userInput.toLowerCase(Locale.ROOT))) {
                    searchedWords.add(userInput.toLowerCase(Locale.ROOT));
                }
                for (String file : ListOfFiles.getWords())  mySearch(file,ignoredWords,searchedWords);
            }
            userInput = scan.nextLine();
        }

        scan.close();
    }

    static void mySearch( String inputFile, List<String> iw, List<String> sw){

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
        }
    }

    public static  boolean checkIfSearchWordAlreadyExsist(List<String> searched, String searching){
        for(String xxx : searched){ if(Objects.equals(xxx,searching)) return false; }
        return true;
    }

}
