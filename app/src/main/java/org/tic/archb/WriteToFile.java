package org.tic.archb;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToFile {
    private String fileName;

    public WriteToFile(String file) {
        setOutput(file);
    }

    public void writeOutput(Alphabetiser shifter) {
        try {
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                fileWriterMain(shifter.getSortedTitles(),fileName);
            } else {
                System.out.println("File already exists.");
                fileWriterMain(shifter.getSortedTitles(),fileName);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void fileWriterMain(List<String> listTitleSorted, String outputFile) {
        try {
            FileWriter myWriter = new FileWriter(outputFile,false);
            for(String titles:listTitleSorted){
                myWriter.write(titles + System.getProperty( "line.separator" ));
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void setOutput(String output) {
        this.fileName = output;
    }
}
