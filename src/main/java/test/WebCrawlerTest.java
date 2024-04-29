package test;

import org.cleancode.WebCrawler;
import org.cleancode.Website;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebCrawlerTest {

    @Mock
    private Document document;

    @Mock
    private Connection connection;

    @Mock
    private Connection.Response response;

    private WebCrawler webCrawler;
    private String testUrl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testUrl = "https://example.com";
        webCrawler = new WebCrawler(testUrl);
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
