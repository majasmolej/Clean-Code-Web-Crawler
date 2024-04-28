package org.cleancode;

public class UserInputQuery {

    private final StartingWebsite startingWebsite = new StartingWebsite();
    private final Depth depth = new Depth();
    private final TargetLanguage targetLanguage = new TargetLanguage();
    private final Prompt prompt = new Prompt();
    private final UserInputData userInputData = new UserInputData();

    public UserInputData getUserInputData(){

        prompt.getPromptStartingWebsite();
        userInputData.startingWebsite = startingWebsite.getStartingWebsiteFromUser();

        prompt.getPromptDepth();
        userInputData.maxDepth = depth.getDepthFromUser();

        prompt.getPromptTargetLanguage();
        userInputData.targetLanguage = targetLanguage.getTargetLanguageFromUser();

        return userInputData;
    }

    public String getUserInputDataSummary(){
        return "_________________________________________________________________" +
                "The user has selected the following options for the crawler: \n" +
                "Starting website: "+userInputData.startingWebsite+"\n" +
                "Crawling depth: "+userInputData.maxDepth+"\n" +
                "Target language for translation: "+userInputData.targetLanguage+"."+
                "________________________________________________________________";
    }






}
