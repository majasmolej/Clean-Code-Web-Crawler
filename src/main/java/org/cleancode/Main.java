package org.cleancode;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) {
        UserInputData userInputData;
        WebsiteNode rootNode;

        UserInputQuery userInputQuery = new UserInputQuery();
        userInputData = userInputQuery.getUserInputData();

        CrawlingDispatcher crawlingDispatcher = new CrawlingDispatcher(userInputData);
        crawlingDispatcher.crawlWeb();
        rootNode = crawlingDispatcher.getRootNode();

        TranslationDispatcher translator = new TranslationDispatcher(rootNode, userInputData.targetLanguage);
        translator.translateWebsiteNodes();

        ReportProducer resultProducer = new ReportProducer(userInputData, rootNode);
        String mdString = resultProducer.makeMdString();

        FileGenerator fileGenerator = new FileGenerator();
        String mdFileName = "WebCrawler_Report.md";
        fileGenerator.createMdFile(mdString, mdFileName);
    }
}