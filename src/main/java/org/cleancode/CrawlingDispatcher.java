package org.cleancode;

import java.util.ArrayList;
import java.util.HashSet;

public class CrawlingDispatcher {

    UserInputData userInputData;
    WebsiteNode rootNode;
    HashSet<String> crawledUrls = new HashSet<>();

    public CrawlingDispatcher(UserInputData userInputData) {
        this.userInputData = userInputData;
    }

    public void crawlWeb() {
        WebCrawler webCrawler = new WebCrawler(userInputData.startingWebsite);
        Website website = webCrawler.getWebsiteHeadingsAndLinks();
        rootNode = new WebsiteNode();
        rootNode.setWebsite(website);
        crawledUrls.add(userInputData.startingWebsite);

        if (website != null) {
            crawlRecursively(rootNode, 1);
        }
    }

    private void crawlRecursively(WebsiteNode websiteNode, int currentCrawlingDepth) {

        if (currentCrawlingDepth > userInputData.maxDepth) {
            return;
        }

        ArrayList<String> links = websiteNode.getWebsite().functionalLinks;
        for (String link : links) {
            if (!crawledUrls.contains(link)) {
                crawledUrls.add(link);

                WebCrawler webCrawler = new WebCrawler(link);
                Website website = webCrawler.getWebsiteHeadingsAndLinks();

                WebsiteNode childNode = new WebsiteNode();
                childNode.setWebsite(website);
                websiteNode.addChild(childNode);

                crawlRecursively(childNode, currentCrawlingDepth + 1);
            }
        }
    }

    public WebsiteNode getRootNode() {
        return rootNode;
    }


}
