package org.tic.archa;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files

public class FileReader {
    public static List<String> readFile(String inputFile){
        List<String> list =new ArrayList<String>();

        try {
            File myObj = new File(inputFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                list.add(data);
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
                System.exit(1);
        }
       return list;
    }
}
