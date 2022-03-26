package org.tic.archb;

import java.util.*;
import java.util.stream.Collectors;

public class CircularShift {
    private List<String> wordsToIgnore = new ArrayList<>();
    private List<String> wordsRequired = new ArrayList<>();
    private List<String> shiftedTitles = new ArrayList<>();
    private List<String> mainTitles = new ArrayList<>();

    public CircularShift(Words titles, Words ignoreFilter, Words requiredFilter) {
        this.wordsToIgnore = ignoreFilter.getWords().stream().map(String::toLowerCase).collect(Collectors.toList());;
        this.wordsRequired = requiredFilter.getWords();
        this.mainTitles = titles.getWords();
    }

    public void generateShift() {
        checkForRequireWord();

        for (String title : mainTitles) {
            String[] result = title.split(" ");
            shiftedTitles.addAll(checkForValidTitle(result));
        }
    }

    private void checkForRequireWord(){
        if(!(wordsRequired.isEmpty())){
            List<String> list = new ArrayList<>();

            for(String title : mainTitles){
                for(String required : wordsRequired){
                    if((title.toLowerCase(Locale.ROOT)).contains(required.toLowerCase(Locale.ROOT))){
                        if(doubleCheckIfWordEqualWord(title,required)){
                            list.add(title);
                            break;
                        }
                    }
                }
            }
            mainTitles = list;
        }
    }

    private List<String> checkForValidTitle(String[] title){
        List<String> list = new ArrayList<>();

        for(int i = 0; i < title.length; i++){
            if(!(wordsToIgnore.contains(title[0].toLowerCase(Locale.ROOT)))){
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

    private boolean doubleCheckIfWordEqualWord(String title, String word){
        for(String words: title.split(" ")){
            if(Objects.equals(words.toLowerCase(Locale.ROOT), word)){
                return true;
            }
        }
        return false;
    }

    public List<String> getShiftedTitles() {
        return shiftedTitles;
    }
}
