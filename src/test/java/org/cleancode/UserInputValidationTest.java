package org.cleancode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import static org.junit.jupiter.api.Assertions.*;

public class UserInputValidationTest {

    private UserInputValidation validator;

    @BeforeEach
    public void setUp() {
        validator = new UserInputValidation();
    }

    @Test
    public void testIsValidDomain_ValidDomain() {
        assertTrue(validator.isValidDomain("example.com"));
        assertTrue(validator.isValidDomain("www.example.com"));
        assertTrue(validator.isValidDomain("subdomain.example.com"));
    }

    @Test
    public void testIsValidDomain_InvalidDomain() {
        assertFalse(validator.isValidDomain("example"));
        //FIXME fix regex userInputDomain to actually reject the statement below
        //assertFalse(validator.isValidDomain("www.example"));
        assertFalse(validator.isValidDomain("examplecom"));
        assertFalse(validator.isValidDomain("example.com@"));
    }

    @Test
    public void testIsValidURL_ValidURL() throws MalformedURLException, URISyntaxException {
        assertTrue(validator.isValidURL("http://example.com"));
        assertTrue(validator.isValidURL("https://www.example.com"));
    }

    @Test
    public void testIsValidURL_InvalidURL() {
        assertFalse(validator.isValidURL(null));
        assertFalse(validator.isValidURL(""));
        assertFalse(validator.isValidURL("example.com"));
        assertFalse(validator.isValidURL("htp://example.com"));
        assertFalse(validator.isValidURL("http://example..com"));
    }

    @Test
    public void testIsValidDepth_ValidDepth() {
        assertTrue(validator.isValidDepth((byte) 0));
        assertTrue(validator.isValidDepth((byte) 1));
        assertTrue(validator.isValidDepth((byte) 2));
    }

    @Test
    public void testIsValidDepth_InvalidDepth() {
        assertFalse(validator.isValidDepth((byte) -1));
        assertFalse(validator.isValidDepth((byte) 3));
    }

    @Test
    public void testIsValidTargetLanguage() {
        // Assuming all languages are valid for now
        assertTrue(validator.isValidTargetLanguage("English"));
        assertTrue(validator.isValidTargetLanguage("French"));
        assertTrue(validator.isValidTargetLanguage("German"));
        assertTrue(validator.isValidTargetLanguage("Spanish"));
    }
    @Test
    public void testInvalidURL() {
        assertFalse(validator.isValidURLwithJDK("http://invalid url"));
        assertFalse(validator.isValidURLwithJDK("http://invalid:url"));
    }

}
