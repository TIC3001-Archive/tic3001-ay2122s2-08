package org.tic.archa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CircularShifter {

    private static final List<String> nameList = new ArrayList<>(Arrays.asList("a","of","to","with","the"));

    public static List<String> Shift(List<String> listOfTitles) {
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
            if(!(nameList.contains(splitedTitle[0]))){
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