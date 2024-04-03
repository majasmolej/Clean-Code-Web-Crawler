package org.cleancode;
import java.util.Scanner;

public class UserInput {

    private String URL;
    private byte depth;
    private String targetLanguage;

    private UserInputValidation userInputValidation = new UserInputValidation();
    private Prompt prompt = new Prompt();
    private Scanner scanner = new Scanner(System.in);

    private void setURL (){
        String userInputURL;
        boolean isValidURL;
        do{
            userInputURL = scanner.next();
            isValidURL= userInputValidation.validateURL(userInputURL);
            if(!isValidURL){
                System.out.println(prompt.getPromptReenterURL());
            }
        }while(!isValidURL);
        this.URL=userInputURL;
    }

    private void setDepth(){
        byte userInputDepth;
        boolean isValidDepth;
        do{
            userInputDepth = scanner.nextByte();
            isValidDepth = userInputValidation.validateDepth(userInputDepth);
            if(!isValidDepth){
                System.out.println(prompt.getPromptReenterDepth());
            }
        }while(!isValidDepth);
        this.depth=userInputDepth;
    }

    private void setTargetLanguage(){
        String userInputTargetLanguage;
        boolean isValidTargetLanguage;
        do{
            userInputTargetLanguage = scanner.next();
            isValidTargetLanguage = userInputValidation.validateTargetLanguage(userInputTargetLanguage);
            if(!isValidTargetLanguage){
                System.out.println(prompt.getPromptReenterTargetLanguage());
            }
        }while(!isValidTargetLanguage);
        this.targetLanguage=userInputTargetLanguage;
    }

    public String getURL (){
        return this.URL;
    }
    public byte getDepth(){
        return this.depth;
    }
    public String getTargetLanguage(){
        return this.targetLanguage;
    }



}
