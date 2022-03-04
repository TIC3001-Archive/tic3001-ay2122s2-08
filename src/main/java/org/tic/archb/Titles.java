package org.tic.archb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Titles {
    private List<String> titles;
    private List<String> wordsToIgnore;

    public Titles() {
        titles = new ArrayList<>();
        wordsToIgnore = new ArrayList<>();
        setWordsToIgnore();
    }

    public void setTitles(List<String> characters) {
        titles = characters;
    }

    private void setWordsToIgnore(){
        List<String> nameList = new ArrayList<>(Arrays.asList("a","of","to","with","the"));
        wordsToIgnore.addAll(nameList);
    }

    public List<String> getTitles() {
        return titles;
    }

    public List<String> getIgnoredWords() {
        return wordsToIgnore;
    }
}
