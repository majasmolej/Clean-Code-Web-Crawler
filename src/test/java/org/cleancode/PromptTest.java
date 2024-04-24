package org.cleancode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;




public class PromptTest {

    @Test
    public void testGetPromptDomain() {
        Prompt prompt = new Prompt();
        assertEquals("Please enter a domain of a website to be crawled: ", prompt.getPromptDomain());
    }

    @Test
    public void testGetPromptReenterDomain() {
        Prompt prompt = new Prompt();
        assertEquals("Wrong domain format. Please reenter: ", prompt.getPromptReenterDomain());
    }


    @Test
    public void testGetPromptURL() {
        Prompt prompt = new Prompt();
        assertEquals("Please enter a URL of a website, you wish to be crawled: ", prompt.getPromptURL());
    }

    @Test
    public void testGetPromptReenterURL() {
        Prompt prompt = new Prompt();
        assertEquals("Wrong URL format. Try again.", prompt.getPromptReenterURL());
    }

    @Test
    public void testGetPromptDepth() {
        Prompt prompt = new Prompt();
        assertEquals("Please enter the crawl depth: ", prompt.getPromptDepth());
    }

    @Test
    public void testGetPromptReenterDepth() {
        Prompt prompt = new Prompt();
        assertEquals("The depth should be in the range from 0 to 2. Try again.", prompt.getPromptReenterDepth());
    }

    @Test
    public void testGetPromptTargetLanguage() {
        Prompt prompt = new Prompt();
        assertEquals("Please enter the target language: ", prompt.getPromptTargetLanguage());
    }

    @Test
    public void testGetPromptReenterTargetLanguage() {
        Prompt prompt = new Prompt();
        assertEquals("Unknown language. Try again.", prompt.getPromptReenterTargetLanguage());
    }
}
