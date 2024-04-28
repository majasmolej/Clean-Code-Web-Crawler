package org.cleancode;

import com.deepl.api.Language;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TargetLanguage {

    private String targetLanguage;

    public static String getTargetLanguageFromUser() {
        String targetLanguage;
        do {
            printPromptForTargetLanguage();

            String userInput = getUserInputLanguage();//original user input

            String formatedUserInput = getFormattedInputLanguage(userInput); //brings the string f.e. "CHInESE" to form "Chinese"

            String normalizedLanguageVariant = getNationalLanguageFormat(formatedUserInput);// converts to an API specific form f.e. "Chinese (simplified)"

            targetLanguage = normalizedLanguageVariant.trim();

        } while (!isValidTargetLanguage(targetLanguage));

        return targetLanguage;
    }

    //todo: add functionality to check if the chosen API supports the user defined target language
    private static boolean isValidTargetLanguage(String targetLanguage) {
        DeeplAPIWrapper deeplAPIWrapper = new DeeplAPIWrapper();
        List<Language> supportedAPILanguages = deeplAPIWrapper.getSupportedLanguages();
        ArrayList<String> supportedLanguages = deeplAPIWrapper.getSupportedLanguageNamesList(supportedAPILanguages);

        if(!supportedLanguages.contains(targetLanguage)){
            return false;
        }
        return true;
    }

    private static void printPromptForTargetLanguage(){
        System.out.print("Please enter a target language: ");
    }

    private static String getUserInputLanguage(){      //example output "English"
        Scanner scanner = new Scanner(System.in);
        String userInputLanguage = scanner.nextLine();
        return userInputLanguage;
    }

    private static String getFormattedInputLanguage (String language){
        String formattedInputLanguage = language.substring(0,1).toUpperCase()+language.substring(1).toLowerCase();
        return formattedInputLanguage;
    }

    //convertion is required by Deepl API
    private static String getNationalLanguageFormat (String inputLanguageString){
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
