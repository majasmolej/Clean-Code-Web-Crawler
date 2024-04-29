package test;

import org.cleancode.StartingWebsite;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.*;


public class StartingWebsiteTest {

    private static StartingWebsite startingWebsite;

    @BeforeEach
    public void setUp(){
        startingWebsite = new StartingWebsite();
    }

    @AfterEach
    public void tearDown(){
        startingWebsite=null;
    }

    @Test
    public void getValidStartingWebsiteFromUser() {
        String url = getUserInputWebSite("https://javatpoint.com");
        assertEquals("https://javatpoint.com", url);
    }

    @Test
    public void getInvalidStartingWebsiteFromUser() {
        String url = getUserInputWebSite("https://www.google.com");
        assertNotEquals("https://javatpoint.com", url);
    }

    @Test
    public void prependHttpsNecessaryTest() {
        startingWebsite.setStartingUrl("www.google.com");
        startingWebsite.prependHttpsIfNecessary();
        assertEquals("https://www.google.com", startingWebsite.getStartingUrl());
    }

    @Test
    public void prependHttpsNotNecessaryTest() {
        startingWebsite.setStartingUrl("https://www.google.com");
        startingWebsite.prependHttpsIfNecessary();
        assertEquals("https://www.google.com", startingWebsite.getStartingUrl());
    }
    @Test
    public void isValidWebsiteTest() {
        startingWebsite.setStartingUrl("https://www.google.com");
        boolean shouldBeValidWebsite = startingWebsite.isValidWebsite();
        assertTrue(shouldBeValidWebsite);
    }

    @Test
    public void isNotValidWebsiteTest1() {
        startingWebsite.setStartingUrl("");
        boolean shouldNotBeValidWebsite = startingWebsite.isValidWebsite();
        assertFalse(shouldNotBeValidWebsite);
    }

    @Test
    public void isNotValidWebsiteTest2() {
        startingWebsite.setStartingUrl("https://");
        boolean shouldNotBeValidWebsite = startingWebsite.isValidWebsite();
        assertFalse(shouldNotBeValidWebsite);
    }

    @Test
    public void isNotValidWebsiteTest3() {
        startingWebsite.setStartingUrl("https://hello");
        boolean shouldNotBeValidWebsite = startingWebsite.isValidWebsite();
        assertFalse(shouldNotBeValidWebsite);
    }

    @Test
    public void isNotValidWebsiteTest4() {
        startingWebsite.setStartingUrl("https://at");
        boolean shouldNotBeValidWebsite = startingWebsite.isValidWebsite();
        assertFalse(shouldNotBeValidWebsite);
    }

    @Test
    public void isNotValidWebsiteTest5() {
        startingWebsite.setStartingUrl("https://||9");
        boolean shouldNotBeValidWebsite = startingWebsite.isValidWebsite();
        assertFalse(shouldNotBeValidWebsite);
    }

    private String getUserInputWebSite(String input){
        InputStream originalSystemInput = System.in;
        String testWebsite = input+"\n";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(testWebsite.getBytes());
        System.setIn(byteArrayInputStream);

        StartingWebsite startingWebsite = new StartingWebsite();
        String url = startingWebsite.getStartingWebsiteFromUser();

        System.setIn(originalSystemInput);

        return url;
    }
}
