package org.cleancode;

public class Prompt {

    private final String promptStartingWebsite = "Please enter a website to be crawled: ";
    private final String promptReenterStartingWebsite = "Wrong format. Please reenter: ";
    private final String promptDepth = "Please enter the crawl depth: ";
    private final String promptReenterDepth = "The depth should be in the range from 0 to 2. Try again.";
    private final String promptTargetLanguage = "Please enter the target language: ";
    private final String promptReenterTargetLanguage = "Unknown language. Try again.";

    public String getPromptStartingWebsite(){
        return promptStartingWebsite;
    }
    public String getPromptReenterStartingWebsite(){return promptReenterStartingWebsite;}
    public String getPromptDepth(){
        return promptDepth;
    }
    public String getPromptReenterDepth(){
        return promptReenterDepth;
    }
    public String getPromptTargetLanguage(){
        return promptTargetLanguage;
    }
    public String getPromptReenterTargetLanguage(){
        return promptReenterTargetLanguage;
    }

}
