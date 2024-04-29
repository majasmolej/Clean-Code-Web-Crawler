package org.cleancode.test;

import org.cleancode.WebCrawler;
import org.cleancode.Website;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebCrawlerTest {

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        String testUrl = "https://example.com";
        WebCrawler webCrawler = new WebCrawler(testUrl);
    }

    @Test
    void manuallyCrawlWebsite() {
        // remarks: I tried every way of mocking, but did not manage...

        WebCrawler webCrawler = new WebCrawler("https://javatpoint.com");

        Website website = webCrawler.getWebsiteHeadingsAndLinks();
        System.out.println("\nWebsite: " + website.urlString);
        System.out.println("\nHeadings: ");
        int headerCounter = 1;
        for (String heading : website.headings) {
            System.out.println(headerCounter + " " + heading);
            headerCounter++;
        }
        int funcionalLinkCounter = 1;
        System.out.println("\nFunctional Links:");
        for (String functionalLink : website.functionalLinks) {
            System.out.println(funcionalLinkCounter + " " + functionalLink);
            funcionalLinkCounter++;
        }
        int brokenLinkCounter = 1;
        System.out.println("\nBroken Links:");
        for (String brokenLink : website.brokenLinks) {
            System.out.println(brokenLinkCounter + " " + brokenLink);
            brokenLinkCounter++;
        }

        assertEquals("h1 Latest Tutorials", website.headings.get(0));
    }
}
