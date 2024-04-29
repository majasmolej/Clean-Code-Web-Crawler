package org.cleancode;

import java.util.ArrayList;

public class ReportProducer {
    UserInputData userInputData;
    WebsiteNode rootNode;
    StringBuilder report = new StringBuilder();
    public ReportProducer(UserInputData userInputData, WebsiteNode rootNode) {
        this.userInputData = userInputData;
        this.rootNode = rootNode;
    }

    public String makeMdString() {
        report.append("# Web Crawler Report");
        report.append(newLine());
        report.append(assembleInput());
        report.append(newLine());

        recursiveAppend(rootNode, 0);

        return report.toString();
    }

    private void recursiveAppend(WebsiteNode websiteNode, int depth) {

        if (websiteNode.getWebsite() != null) {
            String url = websiteNode.getWebsite().urlString;
            report.append(newLine());
            report.append(newLine());
            report.append(newLine());
            report.append(url);
            report.append(newLine());
            report.append(newLine());

            ArrayList<String> headings = websiteNode.getWebsite().translatedHeadings;
            for (String translatedHeading : headings) {
                String[] headingLevelAndHeading = translatedHeading.split(" ", 2);
                // uses only the number of the string "h1 Example Heading", result: '1'
                int headingLevel = Integer.parseInt(headingLevelAndHeading[0]);

                report.append("#".repeat(Math.max(0, headingLevel)));
                report.append(" ").append(headingLevelAndHeading[1]).append(newLine());

            }

            report.append(newLine());
            report.append("Functional Links: ");
            report.append(newLine());
            report.append(newLine());

            ArrayList<String> functionalLinks = websiteNode.getWebsite().functionalLinks;
            for (String link : functionalLinks) {
                report.append(makeFunctionalLink(link));
            }

            report.append(newLine());
            report.append("Broken Links: ");
            report.append(newLine());
            report.append(newLine());

            ArrayList<String> brokenLinks = websiteNode.getWebsite().brokenLinks;
            for (String link : brokenLinks) {
                report.append(makeBrokenLink(link));
            }
        }

        // recursive call to children
        for (WebsiteNode child : websiteNode.getChildren()) {
            recursiveAppend(child, depth + 1);
        }
    }

    String newLine() {
        return "\n";
    }
    String assembleInput() {
        return "Starting Website: <a>" + userInputData.startingWebsite + "</a>\n"
                + "Crawling Depth: " + userInputData.maxDepth + "\n"
                + "Target Language: " + userInputData.targetLanguage + "\n";
    }

    String makeFunctionalLink(String text) {
        return "--> Functional Link to: <a>" + text + "</a>\n";
    }
    String makeBrokenLink(String text) {
        return "--> Broken Link to: <a>" + text + "</a>\n";
    }
}
