package org.cleancode;

import java.util.ArrayList;

    public class TranslationDispatcher {
        private DeeplAPIWrapper deeplAPIWrapper;
        private WebsiteNode rootNode;
        private String targetLanguage;

        public TranslationDispatcher(WebsiteNode rootNode, String targetLanguage) {
            this.rootNode = rootNode;
            this.targetLanguage = targetLanguage;
            this.deeplAPIWrapper = new DeeplAPIWrapper();
        }

        public void translateWebsiteNodes() {
            recursiveTranslate(rootNode, 0);
        }

        private String getTargetLanguageCode() {
            return deeplAPIWrapper.getLanguageCode(targetLanguage);
        }

        private void recursiveTranslate(WebsiteNode websiteNode, int depth) {
            if (websiteNode.getWebsite() == null) {
                return; // Termination condition for recursion
            }

            ArrayList<String> headings = websiteNode.getWebsite().headings;

            for (int i = 0; i < headings.size(); i++) {
                String heading = headings.get(i);
                if (!heading.isEmpty()) {
                    String[] headingLevelAndHeading = heading.split(" ", 2);
                    int headingLevel = Integer.parseInt(headingLevelAndHeading[0].substring(1));
                    String headingToTranslate = headingLevelAndHeading[1];

                    try {
                        String translatedHeading = deeplAPIWrapper.getTranslatedHeading(headingToTranslate, getTargetLanguageCode());
                        String translatedHeadingWithLevel = headingLevel + " " + translatedHeading;
                        websiteNode.getWebsite().translatedHeadings.add(i, translatedHeadingWithLevel);
                    } catch (Exception e) {
                        ExceptionLogger.log(e);
                    }
                }
            }

            // Recursive call to children
            for (WebsiteNode child : websiteNode.getChildren()) {
                recursiveTranslate(child, depth + 1);
            }
        }
    }


