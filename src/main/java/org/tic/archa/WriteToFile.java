package org.tic.archa;
import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToFile {
    public static void main(List<String> listTitleSorted, String outputFile) {
        try {
            File myObj = new File(outputFile);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                fileWriterMain(listTitleSorted,outputFile);
            } else {
                System.out.println("File already exists.");
                fileWriterMain(listTitleSorted,outputFile);
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
}
