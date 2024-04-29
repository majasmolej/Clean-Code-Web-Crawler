package test;

import org.cleancode.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CrawlingDispatcherTest {

    //Tried to mock WebCrawler. Need to adjust CrawlingDispatcher Class to make mocking possible -> Assignment 2
/*
    @Test
    void crawlingDispatcherTest() {

        WebCrawler mockWebCrawler = Mockito.mock(WebCrawler.class);

        // Creating a mock website
        Website mockWebsite = new Website();
        mockWebsite.urlString = "https://javatpoint.com";
        mockWebsite.functionalLinks.add("https://example.com/functionalLink");
        Mockito.when(mockWebCrawler.getWebsiteHeadingsAndLinks()).thenReturn(mockWebsite);


        UserInputData userInputData = new UserInputData();
        userInputData.startingWebsite = "https://example.com";
        userInputData.maxDepth = 1;
        userInputData.targetLanguage = "German";


        CrawlingDispatcher crawlingDispatcher = new CrawlingDispatcher(userInputData);


        crawlingDispatcher.webCrawler = mockWebCrawler;

        crawlingDispatcher.crawlWeb();

        WebsiteNode rootNode = crawlingDispatcher.getRootNode();

        assertEquals(1, rootNode.getChildren().size());
        WebsiteNode childNode = rootNode.getChildren().get(0);
        assertEquals(mockWebsite.urlString, childNode.getWebsite().urlString);
        assertEquals(mockWebsite.functionalLinks.get(0), childNode.getWebsite().functionalLinks.get(0));
    }

*/
}
