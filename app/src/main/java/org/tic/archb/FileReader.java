package org.tic.archb;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FileReader implements FileInput {
    private String titleFileName;

    public FileReader(String fileName) {
        setInput(fileName);
    }

    @Override
    public void populateWords(Words words) {
        List<String> list =new ArrayList<>();

        try {
            File myObj = new File(this.titleFileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                list.add(data);
            }
            myReader.close();
            words.setWords(list);
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void setInput(String titleFileName) {
        this.titleFileName = titleFileName;
    }
}
