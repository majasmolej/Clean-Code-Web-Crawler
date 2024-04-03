package org.cleancode;

public class Prompt {

    private final String promptURL = "Please enter a URL of a website, you wish to be crawled: ";
    private final String promptDepth = "Please enter the crawl depth: ";
    private final String promptTargetLanguage = "Please enter the target language: ";

    public String getPromptURL(){
        return promptURL;
    }
    public String getPromptDepth(){
        return promptDepth;
    }
    public String getPromptTargetLanguage(){
        return promptTargetLanguage;
    }

}
