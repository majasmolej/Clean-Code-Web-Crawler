package org.cleancode;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws MalformedURLException, URISyntaxException {
        Prompt prompt = new Prompt();
        UserInputQuery userInputQuery = new UserInputQuery();

        userInputQuery.getUserInputData();
        System.out.println(userInputQuery.getUserInputDataSummary());


    }
}