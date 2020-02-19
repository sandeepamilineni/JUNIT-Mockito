package com.giffgaff.utility;

public class MiscUtility {

    public String truncateAInFirst2Positions(String line){
        String sentence = line.toUpperCase();
        if(sentence.length() < 0){
            return sentence.replace('A',' ');
        }
        String first2Chars = sentence.substring(0, 2);
        String truncatedStr= sentence.substring(2);

        return first2Chars.replaceAll("A", "") + truncatedStr;
    }

}
