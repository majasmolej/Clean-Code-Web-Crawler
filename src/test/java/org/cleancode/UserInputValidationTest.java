package org.cleancode;

import org.junit.jupiter.api.Test;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import static org.junit.jupiter.api.Assertions.*;

public class UserInputValidationTest {

    @Test
    public void testIsValidDomain_ValidDomain() {
        UserInputValidation validator = new UserInputValidation();
        assertTrue(validator.isValidDomain("example.com"));
        assertTrue(validator.isValidDomain("www.example.com"));
        assertTrue(validator.isValidDomain("subdomain.example.com"));
    }

    @Test
    public void testIsValidDomain_InvalidDomain() {
        UserInputValidation validator = new UserInputValidation();
        assertFalse(validator.isValidDomain("example"));
        //assertFalse(validator.isValidDomain("www.example"));
        assertFalse(validator.isValidDomain("examplecom"));
        assertFalse(validator.isValidDomain("example.com@"));
    }

    @Test
    public void testIsValidURL_ValidURL() throws MalformedURLException, URISyntaxException {
        UserInputValidation validator = new UserInputValidation();
        assertTrue(validator.isValidURL("http://example.com"));
        assertTrue(validator.isValidURL("https://www.example.com"));
    }

    @Test
    public void testIsValidURL_InvalidURL() throws MalformedURLException, URISyntaxException {
        UserInputValidation validator = new UserInputValidation();
        assertFalse(validator.isValidURL(null));
        assertFalse(validator.isValidURL(""));
        assertFalse(validator.isValidURL("example.com"));
        assertFalse(validator.isValidURL("htp://example.com"));
        assertFalse(validator.isValidURL("http://example..com"));
    }

    @Test
    public void testIsValidDepth_ValidDepth() {
        UserInputValidation validator = new UserInputValidation();
        assertTrue(validator.isValidDepth((byte) 0));
        assertTrue(validator.isValidDepth((byte) 1));
        assertTrue(validator.isValidDepth((byte) 2));
    }

    @Test
    public void testIsValidDepth_InvalidDepth() {
        UserInputValidation validator = new UserInputValidation();
        assertFalse(validator.isValidDepth((byte) -1));
        assertFalse(validator.isValidDepth((byte) 3));
    }

    @Test
    public void testIsValidTargetLanguage() {
        UserInputValidation validator = new UserInputValidation();
        // Assuming all languages are valid for now
        assertTrue(validator.isValidTargetLanguage("English"));
        assertTrue(validator.isValidTargetLanguage("French"));
        assertTrue(validator.isValidTargetLanguage("German"));
        assertTrue(validator.isValidTargetLanguage("Spanish"));
    }
}
