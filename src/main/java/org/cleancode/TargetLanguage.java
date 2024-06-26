package org.cleancode;

import com.deepl.api.Language;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TargetLanguage {

    private String targetLanguage;
    private final Prompt prompt = new Prompt();

    public String getTargetLanguageFromUser() {
        String userInputTargetLanguage;
        do {
            userInputTargetLanguage = getUserInputLanguage();//original user input
            String formattedUserInput = getFormattedInputLanguage(userInputTargetLanguage); //brings the string f.e. "CHInESE" to form "Chinese"
            String normalizedLanguageVariant = getNationalLanguageFormat(formattedUserInput);// converts to an API specific form f.e. "Chinese (simplified)"
            targetLanguage = normalizedLanguageVariant.trim();

            if(!isValidTargetLanguage(targetLanguage)){
                System.out.println(prompt.getPromptReenterTargetLanguage());
            }
        } while (!isValidTargetLanguage(targetLanguage));
        return targetLanguage;
    }

    public boolean isValidTargetLanguage(String targetLanguage) {
        DeeplAPIWrapper deeplAPIWrapper = new DeeplAPIWrapper();
        List<Language> supportedAPILanguages = deeplAPIWrapper.getSupportedLanguages();
        ArrayList<String> supportedLanguages = deeplAPIWrapper.getSupportedLanguageNamesList(supportedAPILanguages);

        if(!supportedLanguages.contains(targetLanguage)){
            return false;
        }
        return true;
    }

    public String getUserInputLanguage(){      //example output "English"
        Scanner scanner = new Scanner(System.in);
        String userInputLanguage = scanner.nextLine();
        return userInputLanguage;
    }

    public String getFormattedInputLanguage (String language){
        String formattedInputLanguage = language.substring(0,1).toUpperCase()+language.substring(1).toLowerCase();
        return formattedInputLanguage;
    }

    //convertion is required by Deepl API
    public String getNationalLanguageFormat(String inputLanguageString){
        String formattedLanguageString;
        if(inputLanguageString.equals("English")){
            formattedLanguageString = "English "+"(British)";
        }else if(inputLanguageString.equals("Portuguese")){
            formattedLanguageString = "Portuguese "+"(European)";
        }else if(inputLanguageString.equals("Chinese")){
            formattedLanguageString = "Chinese "+"(simplified)";
        }else{
            formattedLanguageString = inputLanguageString;
        }
        return formattedLanguageString;
    }
}
