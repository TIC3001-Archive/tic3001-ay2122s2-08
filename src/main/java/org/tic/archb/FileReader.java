package org.tic.archb;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    private String fileName;

    public FileReader(String fileName) {
        setInput(fileName);
    }

    public void setInput(String input) {
        this.fileName = input;
    }

    public void populateTitles(Titles titles) {
        List<String> list =new ArrayList<>();

        try {
            File myObj = new File(this.fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                list.add(data);
            }
            myReader.close();
            titles.setTitles(list);
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
