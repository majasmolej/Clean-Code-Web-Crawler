package org.cleancode;

import java.util.Scanner;
public class Depth {
    Scanner scanner = new Scanner(System.in);
    private Prompt prompt = new Prompt();

    public byte getValidDepth(){
        byte userInputDepth;
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

    private boolean isValidDepth(String userInputDepth){
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
