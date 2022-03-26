package org.tic.archb;

public class Master {
    private final String inputFile;
    private final String outputFile;
    private final String ignoredWordsFile;
    private final String requiredWordsFile;

    public Master(String inputFile, String outputFile, String ignored, String required) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.ignoredWordsFile = ignored;
        this.requiredWordsFile = required;
    }

    public void runProgram() {

        // read and store titles
        FileReader readInputFile = new FileReader(inputFile);
        Words titles = new Words();
        readInputFile.populateWords(titles);

        // read and store ignored words
        FileReader readIgnoreWordsFile = new FileReader(ignoredWordsFile);
        Words ignoreWords = new Words();
        readIgnoreWordsFile.populateWords(ignoreWords);

        // read and store required word
        FileReader readRequiredWordsFile = new FileReader(requiredWordsFile);
        Words requiredWords = new Words();
        readRequiredWordsFile.populateWords(requiredWords);

        //Filters out required words in title, then removes ignored words
        CircularShift circularShift = new CircularShift(titles,ignoreWords,requiredWords);
        circularShift.generateShift();

        Alphabetiser alphaShifter = new Alphabetiser(circularShift);

        WriteToFile fileOutput = new WriteToFile(outputFile);
        fileOutput.writeOutput(alphaShifter);

    }
}
