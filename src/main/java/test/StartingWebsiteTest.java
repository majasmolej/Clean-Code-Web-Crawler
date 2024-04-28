package test;

import org.cleancode.StartingWebsite;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class StartingWebsiteTest {

    @Test
    public void getValidStartingWebsiteFromUser() {
        InputStream originalSystemInput = System.in;
        String testWebsite = "https://javatpoint.com\n";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(testWebsite.getBytes());
        System.setIn(byteArrayInputStream);

        StartingWebsite startingWebsite = new StartingWebsite();
        String url = startingWebsite.getStartingWebsiteFromUser();
        assertEquals("https://javatpoint.com", url);

        System.setIn(originalSystemInput);
    }

    @Test
    public void getInvalidStartingWebsiteFromUser() {
        InputStream originalSystemInput = System.in;
        String testWebsite = "https://www.google.com\n";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(testWebsite.getBytes());
        System.setIn(byteArrayInputStream);

        StartingWebsite startingWebsite = new StartingWebsite();
        String url = startingWebsite.getStartingWebsiteFromUser();
        assertNotEquals("https://javatpoint.com", url);

        System.setIn(originalSystemInput);
    }

    @Test
    public void prependHttpsNecessaryTest() {
        StartingWebsite startingWebsite = new StartingWebsite();
        startingWebsite.setStartingUrl("www.google.com");
        startingWebsite.prependHttpsIfNecessary();
        assertEquals("https://www.google.com", startingWebsite.getStartingUrl());
    }

    @Test
    public void prependHttpsNotNecessaryTest() {
        StartingWebsite startingWebsite = new StartingWebsite();
        startingWebsite.setStartingUrl("https://www.google.com");
        startingWebsite.prependHttpsIfNecessary();
        assertEquals("https://www.google.com", startingWebsite.getStartingUrl());
    }
    @Test
    public void isValidWebsiteTest() {
        StartingWebsite startingWebsite = new StartingWebsite();
        startingWebsite.setStartingUrl("https://www.google.com");
        boolean shouldBeValidWebsite = startingWebsite.isValidWebsite();
        assertTrue(shouldBeValidWebsite);
    }

    @Test
    public void isNotValidWebsiteTest1() {
        StartingWebsite startingWebsite = new StartingWebsite();
        startingWebsite.setStartingUrl("");
        boolean shouldNotBeValidWebsite = startingWebsite.isValidWebsite();
        assertFalse(shouldNotBeValidWebsite);
    }

    @Test
    public void isNotValidWebsiteTest2() {
        StartingWebsite startingWebsite = new StartingWebsite();
        startingWebsite.setStartingUrl("https://");
        boolean shouldNotBeValidWebsite = startingWebsite.isValidWebsite();
        assertFalse(shouldNotBeValidWebsite);
    }

    @Test
    public void isNotValidWebsiteTest3() {
        StartingWebsite startingWebsite = new StartingWebsite();
        startingWebsite.setStartingUrl("https://hello");
        boolean shouldNotBeValidWebsite = startingWebsite.isValidWebsite();
        assertFalse(shouldNotBeValidWebsite);
    }

    @Test
    public void isNotValidWebsiteTest4() {
        StartingWebsite startingWebsite = new StartingWebsite();
        startingWebsite.setStartingUrl("https://at");
        boolean shouldNotBeValidWebsite = startingWebsite.isValidWebsite();
        assertFalse(shouldNotBeValidWebsite);
    }

    @Test
    public void isNotValidWebsiteTest5() {
        StartingWebsite startingWebsite = new StartingWebsite();
        startingWebsite.setStartingUrl("https://||9");
        boolean shouldNotBeValidWebsite = startingWebsite.isValidWebsite();
        assertFalse(shouldNotBeValidWebsite);
    }
}
