package org.cleancode;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Scanner;

//TODO: Test the class with JUnit
public class UserInput {

    private String domain;
    private String URL;
    private byte depth;
    private String targetLanguage;

    private UserInputValidation userInputValidation = new UserInputValidation();
    private Prompt prompt = new Prompt();
    private Scanner scanner = new Scanner(System.in);

    private void setDomain(){
        this.domain=getValidDomain();
    }
    private void setURL () throws MalformedURLException, URISyntaxException {
        this.URL= getValidURL();
    }

    private void setDepth(){
        this.depth= getValidDepth();
    }

    private void setTargetLanguage(){
        this.targetLanguage= getValidTargetLanguage();
    }

    private String getValidDomain(){
        String userInputDomain;
        boolean isValidDomain;
        do{
            userInputDomain = scanner.next();
            isValidDomain= userInputValidation.isValidDomain(userInputDomain);
            if(!isValidDomain){
                System.out.println(prompt.getPromptReenterDomain());
            }
        }while(!isValidDomain);
        return userInputDomain;
    }
    private String getValidURL() throws MalformedURLException, URISyntaxException {
        String userInputURL;
        boolean isValidURL;
        do{
            userInputURL = scanner.next();
            isValidURL= userInputValidation.isValidURL(userInputURL);
            if(!isValidURL){
                System.out.println(prompt.getPromptReenterURL());
            }
        }while(!isValidURL);
        return userInputURL;
    }
    private byte getValidDepth(){
        byte userInputDepth;
        boolean isValidDepth;
        do{
            userInputDepth = scanner.nextByte();
            isValidDepth = userInputValidation.isValidDepth(userInputDepth);
            if(!isValidDepth){
                System.out.println(prompt.getPromptReenterDepth());
            }
        }while(!isValidDepth);
        return userInputDepth;
    }
    private String getValidTargetLanguage(){
        String userInputTargetLanguage;
        boolean isValidTargetLanguage;
        do{
            userInputTargetLanguage = scanner.next();
            isValidTargetLanguage = userInputValidation.isValidTargetLanguage(userInputTargetLanguage);
            if(!isValidTargetLanguage){
                System.out.println(prompt.getPromptReenterTargetLanguage());
            }
        }while(!isValidTargetLanguage);
        return userInputTargetLanguage;
    }

    public String getDomain(){
        setDomain();
        return this.domain;
    }
    public String getURL () throws MalformedURLException, URISyntaxException {
        setURL();
        return this.URL;
    }
    public byte getDepth(){
        setDepth();
        return this.depth;
    }
    public String getTargetLanguage(){
        setTargetLanguage();
        return this.targetLanguage;
    }



}
