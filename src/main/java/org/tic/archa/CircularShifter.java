package org.tic.archa;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CircularShifter {

    private static List<String> ignoredWordsList = new ArrayList<>();
    private static List<String> mustHaveWordsList = new ArrayList<>();

    private static void setIgnoredWords(String blablabla){
        ignoredWordsList = FileReader.readFile(blablabla);
    }

    private static void setMustHaveWords(String blablabla){
        mustHaveWordsList = FileReader.readFile(blablabla);
    }

    private static List<String> getMustHaveWords (List<String> listOfTitles){
        List<String> newList = new ArrayList<>();
        if(mustHaveWordsList.isEmpty()){
            return  listOfTitles;
        }
        else{
            for (String title : listOfTitles) {
                for(String required : mustHaveWordsList){
                    if(title.contains(required)){
                        newList.add(title);
                    }
                }
            }
            return newList;
        }
    }

    public static List<String> Shift(List<String> listOfTitles, String ignored, String mustHave) {
        setIgnoredWords(ignored);
        setMustHaveWords(mustHave);

        listOfTitles = getMustHaveWords(listOfTitles);

        List<String> newList = new ArrayList<>();
        for (String title : listOfTitles) {
            newList.addAll(checkForValidTile(title));
        }
        return newList;
    }

    private static List<String> checkForValidTile(String title){
        List<String> validTitles = new ArrayList<>();
        String[] splitedTitle = title.split(" ");

        for(int i = 0; i < splitedTitle.length; i++){
            if(!(ignoredWordsList.contains(splitedTitle[0].toLowerCase(Locale.ROOT)))){
                StringBuilder sb = new StringBuilder();
                for (String s : splitedTitle) {
                    sb.append(s).append(" ");
                }
                String str = sb.toString();
                validTitles.add(str);
            }
            shiftTitleLeft(splitedTitle);
        }
        return validTitles;
    }

    private static void shiftTitleLeft(String[] str){
        for (int i = 0; i < 1; i++) {
            for (int j = str .length - 1; j > 0; j--) {
                String temp = str [j];
                str [j] = str [j - 1];
                str [j - 1] = temp;
            }
        }
    }
}
