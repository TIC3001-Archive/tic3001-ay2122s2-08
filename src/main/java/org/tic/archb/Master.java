package org.tic.archb;

public class Master {
    private final String inputFile;
    private final String outputFile;

    public Master(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    public void runProgram() {

        FileReader fileReader = new FileReader(inputFile);

        Titles titles = new Titles();
        fileReader.populateTitles(titles);

        CircularShift circularShift = new CircularShift();
        circularShift.generateShift(titles);

        Alphabetiser alphaShifter = new Alphabetiser(circularShift);

        WriteToFile fileOutput = new WriteToFile(outputFile);
        fileOutput.writeOutput(alphaShifter);

    }
}
