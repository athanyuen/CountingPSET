package com.example.countingfinal;

import java.util.ArrayList;

public class SortText {
    private final ArrayList<String> sortedWords;
    private final ArrayList<String> commonWords;
    public SortText(String commonWordsFilePath, String textFilePath) {
        TextFileReader textFile = new TextFileReader(textFilePath);
        TextFileReader commonWordsFile = new TextFileReader(commonWordsFilePath);
        ArrayList<String> unsortedWords = textFile.getWords();
        commonWords = toLowercase(commonWordsFile.getWords());
        sortedWords = removeCommonWords(toLowercase(removePunctuation(unsortedWords)));
    }
    private ArrayList<String> removePunctuation(ArrayList<String> arrayList) {
        for(int i = 0; i < arrayList.size(); i++){
            arrayList.set(i, arrayList.get(i).replaceAll("[^a-zA-Z0-9]", ""));
        }
        return arrayList;
    }
    private ArrayList<String> toLowercase(ArrayList<String> arrayList) {
        ArrayList<String> temp = new ArrayList<>();
        for (String s : arrayList) {
            temp.add(s.toLowerCase());
        }
        return temp;
    }

    private ArrayList<String> removeCommonWords(ArrayList<String> arrayList) {
        ArrayList<String> temp = new ArrayList<>();
        for (String s : arrayList) {
            if (!commonWords.contains(s)) {
                temp.add(s);
            }
        }
        return temp;
    }
    public ArrayList<String> getSortedWords() {
        return sortedWords;
    }
}
