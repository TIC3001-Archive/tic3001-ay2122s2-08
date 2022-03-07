package org.tic.archb;

public class Main {
    public static void main(String[] args) {
        String testcase = "1";
        String inputFile = args[0] + "/TitlesInput.txt";
        String outputFile = args[0] +"/TitlesOutputA.txt";
        Master abstractDateType = new Master(inputFile,outputFile);
        abstractDateType.runProgram();
    }
}
