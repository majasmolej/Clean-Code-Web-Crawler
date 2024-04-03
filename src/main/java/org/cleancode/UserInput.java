package org.cleancode;
import java.util.Scanner;

public class UserInput {

    private String URL;
    private byte depth;
    private String targetLanguage;






    private boolean validateURL(String userInputURL){
        return true;
    }
    private boolean validateDepth (byte userInputDepth){
        return true;
    }

    //TODO: depending on the chosen API for translation, implement this method to accept only available target languages (and possibly add an extra method to convert them to a language code, f.e. "English" to "EN")
    private boolean validateTargetLanguage (String userInputTargetLanguage){
        return true;
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
