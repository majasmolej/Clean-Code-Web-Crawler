package org.cleancode;

import java.util.Scanner;
public class Depth {
    Scanner scanner = new Scanner(System.in);
    private static final Prompt prompt = new Prompt();
    private byte userInputDepth;

    public byte getDepthFromUser(){
        boolean isValidDepth;
        do{
            userInputDepth = scanner.nextByte();
            String userInputDepthStr = Byte.toString(userInputDepth);
            isValidDepth = isValidDepth(userInputDepthStr);
            if(!isValidDepth){
                System.out.println(prompt.getPromptReenterDepth());
            }
        }while(!isValidDepth);
        return userInputDepth;
    }

    public boolean isValidDepth(String userInputDepth){
        String regex = "[012]";
        boolean result;
        if(isNumeric(userInputDepth)){
            result = userInputDepth.matches(regex);
        }else{
            result = false;
        }
        return result;
    }

    private boolean isNumeric(String userInputDepth){
        String regex = "\\d";
        return userInputDepth.matches(regex);
    }
}
