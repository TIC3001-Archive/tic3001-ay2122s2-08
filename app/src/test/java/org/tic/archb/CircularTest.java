package org.tic.archb;

import org.junit.Test;
import org.tic.archb.FileReader;
import org.tic.archb.Words;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CircularTest {
    @Test public void ProperShift() {
        List<String> listT = new ArrayList<>(Arrays.asList("Back to the Future", "Desperado", "Night at the Museum", "Robocop", "Ghostbusters", "Cool World", "donnie Darko", "Double Indemnity"));
        List<String> listI = new ArrayList<>(Arrays.asList("cool" , "a" , "the" , "to" , "donniE"));
        List<String> listR = new ArrayList<>(Arrays.asList("world" , "ghost" , "robocop"));
        List<String> listO = new ArrayList<>(Arrays.asList("Robocop " ,"World Cool "));

        Words titles = new Words();
        titles.setWords(listT);

        Words ignore = new Words();
        ignore.setWords(listI);

        Words required = new Words();
        required.setWords(listR);

        CircularShift circularShift = new CircularShift(titles,ignore,required);
        circularShift.generateShift();

        assertEquals(listO,circularShift.getShiftedTitles());
    }
}
