package org.tic.archb;

public class Main {
    public static void main(String[] args) {

        String inputFile = args[0] ;
        String ignoreWordsFile = args[1] ;
        String mustHaveWordsFile = args[2] ;
        String outputFile = args[3] +"/TitlesOutput.txt";

        //String testcase = "3";
        //String inputFile = "/Users/gopal/Document/TIC3001/Ass 2/Assignment2Testcases/Test" + testcase + "/Titles" + testcase + ".txt";
        //String outputFile = "/Users/gopal/Document/TIC3001/Ass 2/Assignment2Testcases/Test" + testcase + "/TitlesOutputA.txt";
        //String ignoreWordsFile = "/Users/gopal/Document/TIC3001/Ass 2/Assignment2Testcases/Test" + testcase + "/Ignored" + testcase + ".txt";
        //String mustHaveWordsFile = "/Users/gopal/Document/TIC3001/Ass 2/Assignment2Testcases/Test" + testcase + "/Required" + testcase + ".txt";

        Master abstractDateType = new Master(inputFile,outputFile,ignoreWordsFile,mustHaveWordsFile);
        abstractDateType.runProgram();
    }
}
