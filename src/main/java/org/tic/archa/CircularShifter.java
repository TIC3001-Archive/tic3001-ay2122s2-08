package org.tic.archa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CircularShifter {

    private static List<String> nameList = new ArrayList<>(Arrays.asList("a","of","to","with","the"));

    public static List<String> Shift(List<String> listOfTitles) {
        List<String> newList = new ArrayList<>();
        for (String title : listOfTitles) {
            String[] result = title.split(" ");
            newList.addAll(checkForValidTile(result));
        }
        return newList;
    }

    public static List<String> checkForValidTile(String[] title){
        List<String> list = new ArrayList<>();

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

    public static void shiftLeft(String[] str){
        for (int i = 0; i < 1; i++) {
            for (int j = str .length - 1; j > 0; j--) {
                String temp = str [j];
                str [j] = str [j - 1];
                str [j - 1] = temp;
            }
        }
    }
}
