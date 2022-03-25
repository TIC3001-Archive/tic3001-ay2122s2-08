package org.tic.archb;

public class Main {
    public static void main(String[] args) {
        String testcase = "3";
        //String inputFile = args[0] + "/TitlesInput.txt";
        //String outputFile = args[0] +"/TitlesOutputA.txt";

        String inputFile = "/Users/gopal/Document/TIC3001/Ass 2/Assignemnt2Testcases/Test" + testcase + "/Titles" + testcase + ".txt";
        String outputFile = "/Users/gopal/Document/TIC3001/Ass 2/Assignemnt2Testcases/Test" + testcase + "/TitlesOutputA.txt";
        String ignoreWordsFile = "/Users/gopal/Document/TIC3001/Ass 2/Assignemnt2Testcases/Test" + testcase + "/Ignored" + testcase + ".txt";
        String mustHaveWordsFile = "/Users/gopal/Document/TIC3001/Ass 2/Assignemnt2Testcases/Test" + testcase + "/Required" + testcase + ".txt";

        Master abstractDateType = new Master(inputFile,outputFile,ignoreWordsFile,mustHaveWordsFile);
        abstractDateType.runProgram();
    }
}
