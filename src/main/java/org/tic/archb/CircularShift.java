package org.tic.archb;

import java.util.ArrayList;
import java.util.List;

public class CircularShift {
    private List<String> wordsToIgnore = new ArrayList<>();
    private List<String> shiftedTitles = new ArrayList<>();

    public CircularShift(Titles titles) {
        setWordsToIgnore(titles.getIgnoredWords());
    }

    public void generateShift(Titles titles) {
        for (String title : titles.getTitles()) {
            String[] result = title.split(" ");
            shiftedTitles.addAll(checkForValidTitle(result));
        }
    }

    private List<String> checkForValidTitle(String[] title){
        List<String> list = new ArrayList<>();
        List<String> nameList = new ArrayList<>(wordsToIgnore);

        for(int i = 0; i < title.length; i++){
            if(!(nameList.contains(title[0]))){
                StringBuilder sb = new StringBuilder();
                for (String s : title) {
                    sb.append(s).append(" ");
                }
                String str = sb.toString();
                list.add(str);
            }
            shiftLeft(title);
        }
        return list;
    }

    private void shiftLeft(String[] str){
        for (int i = 0; i < 1; i++) {
            for (int j = str .length - 1; j > 0; j--) {
                String temp = str [j];
                str [j] = str [j - 1];
                str [j - 1] = temp;
            }
        }
    }

    public void setWordsToIgnore(List<String> words) {
        wordsToIgnore = words;
    }

    public List<String> getShiftedTitles() {
        return shiftedTitles;
    }
}
