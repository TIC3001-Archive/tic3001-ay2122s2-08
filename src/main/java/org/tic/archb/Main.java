package org.tic.archb;

public class Main {
    public static void main(String[] args) {

        String inputFile = "Assignment1Testcases/testcase1/TitlesInput1.txt";
        String outputFile = "Assignment1Testcases/testcase1/TitlesOutput2.txt";
        Master abstractDateType = new Master(inputFile,outputFile);
        abstractDateType.runProgram();
    }
}
