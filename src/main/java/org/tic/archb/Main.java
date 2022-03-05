package org.tic.archb;

public class Main {
    public static void main(String[] args) {
        String testcase = "1";
        String inputFile = "Assignment1Testcases/testcase"+testcase+"/TitlesInput.txt";
        String outputFile = "Assignment1Testcases/testcase"+testcase+"/TitlesOutputB.txt";
        Master abstractDateType = new Master(inputFile,outputFile);
        abstractDateType.runProgram();
    }
}
