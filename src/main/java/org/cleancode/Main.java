package org.cleancode;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws MalformedURLException, URISyntaxException {
        UserInputQuery userInputQuery = new UserInputQuery();

        userInputQuery.getUserInputData();
        System.out.println(userInputQuery.getUserInputDataSummary());


    }
}