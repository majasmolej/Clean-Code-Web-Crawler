package test;

import org.cleancode.ReportProducer;
import org.cleancode.UserInputData;
import org.cleancode.Website;
import org.cleancode.WebsiteNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReportProducerTest {

    @Test
    void printTestPage1() {
        UserInputData userData = new UserInputData();
        userData.startingWebsite = "https://javatpoint.com";
        userData.maxDepth = 2;
        userData.targetLanguage = "German";

        WebsiteNode websiteNode = new WebsiteNode();
        Website website = new Website();
        website.urlString = "https://google.com";
        website.headings.add("h1 Test");

        ReportProducer resultProducer = new ReportProducer(userData, websiteNode);

        String testString
                = "# Web Crawler Report"
                + "\nStarting Website: <a>"
                + userData.startingWebsite + "</a>"
                + "\nCrawling Depth: "
                + userData.maxDepth
                + "\nTarget Language: "
                + userData.targetLanguage
                + "\n\n";

        assertEquals(testString, resultProducer.makeMdString());

    }


}
