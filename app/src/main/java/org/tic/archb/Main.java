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


        String inputFile = args[0] ;
        //String inputFile = "/Users/gopal/Document/TIC3001/Assignment3/test5/ListOfFiles.txt";

        // Read main file
        FileReader readInputFile = new FileReader(inputFile);
        Words ListOfFiles = new Words();
        readInputFile.populateWords(ListOfFiles);

        List<String> searchedWords = new ArrayList<>();
        List<String> ignoredWords = new ArrayList<>();


        Scanner scan = new Scanner(System.in);
        String userInput = scan.nextLine().toLowerCase(Locale.ROOT);

        while(!userInput.equals("q") ){                                                               // Terminates at q or Q
            if ((userInput.split(" ")).length == 1) {                                           // Checks for multiples words
                if(WordAlreadyExist(searchedWords,userInput))  searchedWords.add(userInput);          //If new word, then add to list
                for (String file : ListOfFiles.getWords()) {
                    Master abstractDateType = new Master();
                    abstractDateType.runProgram2(file, ignoredWords, searchedWords); //Search on all inserted word
                }
            }
            userInput = scan.nextLine().toLowerCase(Locale.ROOT);
        }
        scan.close();
    }

    public static  boolean WordAlreadyExist(List<String> searched, String searching){
        for(String xxx : searched){ if(Objects.equals(xxx,searching)) return false; }
        return true;
    }

}
