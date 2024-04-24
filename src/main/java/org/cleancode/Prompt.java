package org.cleancode;

public class Prompt {

    private static final String PROMPT_DOMAIN = "Please enter a domain of a website to be crawled: ";
    private static final String PROMPT_REENTER_DOMAIN = "Wrong domain format. Please reenter: ";
    private static final String PROMPT_URL = "Please enter a URL of a website, you wish to be crawled: ";
    private static final String PROMPT_REENTER_URL = "Wrong URL format. Try again.";
    private static final String PROMPT_DEPTH = "Please enter the crawl depth: ";
    private static final String PROMPT_REENTER_DEPTH = "The depth should be in the range from 0 to 2. Try again.";
    private static final String PROMPT_TARGET_LANGUAGE = "Please enter the target language: ";
    private static final String PROMPT_REENTER_TARGET_LANGUAGE = "Unknown language. Try again.";

    public String getPromptDomain(){
        return PROMPT_DOMAIN;
    }
    public String getPromptReenterDomain(){return PROMPT_REENTER_DOMAIN;}
    public String getPromptURL(){
        return PROMPT_URL;
    }
    public String getPromptReenterURL(){
        return PROMPT_REENTER_URL;
    }
    public String getPromptDepth(){
        return PROMPT_DEPTH;
    }
    public String getPromptReenterDepth(){
        return PROMPT_REENTER_DEPTH;
    }
    public String getPromptTargetLanguage(){
        return PROMPT_TARGET_LANGUAGE;
    }
    public String getPromptReenterTargetLanguage(){
        return PROMPT_REENTER_TARGET_LANGUAGE;
    }

}
