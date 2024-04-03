package org.cleancode;

public class UserInputValidation {

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
}
