package org.cleancode;

public class Prompt {

    private final String promptURL = "Please enter a URL of a website, you wish to be crawled: ";
    private final String promptReenterURL = "Wrong URL format. Try again.";
    private final String promptDepth = "Please enter the crawl depth: ";
    private final String promptReenterDepth = "The depth should be in the range from 0 to 2. Try again.";
    private final String promptTargetLanguage = "Please enter the target language: ";
    private final String promptReenterTargetLanguage = "Unknown language. Try again.";

    public String getPromptURL(){
        return promptURL;
    }
    public String getPromptReenterURL(){
        return promptReenterURL;
    }
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
