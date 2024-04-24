package org.cleancode;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MalformedURLException, URISyntaxException {
        Scanner scanner = new Scanner(System.in);
        UserInputValidation userInputValidation = new UserInputValidation();
        Prompt prompt = new Prompt();

        UserInput userInput = new UserInput(userInputValidation, prompt, scanner);

        System.out.println(prompt.getPromptDomain());
        userInput.getDomain();
        System.out.println(prompt.getPromptURL());
        userInput.getURL();
        System.out.println(prompt.getPromptDepth());
        userInput.getDepth();
        System.out.println(prompt.getPromptTargetLanguage());
        userInput.getTargetLanguage();


    }
}