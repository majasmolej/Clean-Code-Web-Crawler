package org.cleancode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyByte;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserInputTest {

    private UserInput userInput;
    @Mock
    private Prompt prompt;
    private Scanner scanner;
    @Mock
    private UserInputValidation userInputValidation;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        // Prepare inputs
        String[] inputs = {"example.com\n", "https://example.com\n", "1\n"}; // Domain, URL, Depth

        // Combine inputs into a single string with newlines
        String inputString = String.join("", inputs);

        InputStream in = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(in);
        System.setOut(new PrintStream(outContent));

        scanner = new Scanner(System.in);
        userInput = new UserInput(userInputValidation, prompt, scanner);
    }

    @After
    public void tearDown() {
        System.setIn(System.in);
        System.setOut(originalOut);
    }

    @Test
    public void testGetDomain() {
        when(userInputValidation.isValidDomain(anyString())).thenReturn(true);

        // Call the method under test
        String domain = userInput.getDomain();

        assertEquals("example.com", domain);
    }

    @Test
    public void testGetValidDomain_InvalidInput() {
        // Mock isValidDomain method to return false initially and then true
        when(userInputValidation.isValidDomain((anyString()))).thenReturn(false).thenReturn(true);
        when(prompt.getPromptReenterDomain()).thenReturn("Please enter a valid domain:");

        // Call the method under test
        userInput.getValidDomain();

        // Assert
        assertTrue(outContent.toString().contains("Please enter a valid domain:"));
    }



    @Test
    public void testGetURL() throws MalformedURLException, URISyntaxException {
        when(userInputValidation.isValidURL(anyString())).thenReturn(true);

        // Call the method under test
        String url = userInput.getURL();

        assertEquals("example.com", url);
    }

    @Test
    public void testGetValidURL_InvalidInput() throws MalformedURLException, URISyntaxException {
        // Mock isValidURL method to return false initially and then true
        when(userInputValidation.isValidURL(anyString())).thenReturn(false).thenReturn(true);
        when(prompt.getPromptReenterURL()).thenReturn("Please enter a valid URL:");

        // Call the method under test
        userInput.getURL();

        assertTrue(outContent.toString().contains("Please enter a valid URL:"));
    }

    @Test
    public void testGetDepth() {
        when(userInputValidation.isValidDepth(anyByte())).thenReturn(true);

        // Call the method under test
        byte depth = userInput.getDepth();

        assertEquals(1, depth);
    }

    @Test
    public void testGetValidDepth_ValidInput() {
        // Mock validation to return true for any input
        when(userInputValidation.isValidDepth((byte) 1)).thenReturn(true);

        // Call the method under test
        byte expectedDepth = 1;
        byte actualDepth = userInput.getValidDepth();

        assertEquals(expectedDepth, actualDepth);
    }


    @Test
    public void testGetTargetLanguage() {
        when(userInputValidation.isValidTargetLanguage(anyString())).thenReturn(true);

        // Call the method under test
        String language = userInput.getTargetLanguage();

        assertEquals("example.com", language);
    }

    @Test
    public void testGetValidTargetLanguage_InvalidInput() {
        // Mock isValidTargetLanguage method to return false initially and then true
        when(userInputValidation.isValidTargetLanguage(anyString())).thenReturn(false).thenReturn(true);
        when(prompt.getPromptReenterTargetLanguage()).thenReturn("Please enter a valid target language:");

        // Call the method under test
        userInput.getTargetLanguage();

        assertTrue(outContent.toString().contains("Please enter a valid target language:"));
    }

}
