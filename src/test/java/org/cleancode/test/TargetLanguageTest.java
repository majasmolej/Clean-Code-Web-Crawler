package org.cleancode.test;

import org.cleancode.TargetLanguage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;


class TargetLanguageTest {

    TargetLanguage targetLanguage;

    @BeforeEach
    public void setUp(){
        targetLanguage = new TargetLanguage();
    }

    @AfterEach
    public void tearDown(){
        targetLanguage = null;
    }

    @Test
    void getTargetLanguageFromUser() {

        InputStream originalSystemInput = System.in;
        String testTargetLanguage = "CHInESE\n";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(testTargetLanguage.getBytes());
        System.setIn(byteArrayInputStream);

        String result = targetLanguage.getTargetLanguageFromUser();

        System.setIn(originalSystemInput);

        Assertions.assertEquals("Chinese (simplified)", result);

    }
    @Test
    void isValidTargetLanguage() {

        Assertions.assertTrue (targetLanguage.isValidTargetLanguage("Polish"));
        Assertions.assertTrue(targetLanguage.isValidTargetLanguage("Japanese"));
        Assertions.assertTrue(targetLanguage.isValidTargetLanguage("Norwegian"));
        Assertions.assertTrue(targetLanguage.isValidTargetLanguage("Portuguese (Brazilian)"));

        Assertions.assertFalse(targetLanguage.isValidTargetLanguage("Esperanto"));
        Assertions.assertFalse(targetLanguage.isValidTargetLanguage("Malavi"));
        Assertions.assertFalse(targetLanguage.isValidTargetLanguage("Baby Language"));
    }

    @Test
    void getUserInputLanguage() {
        InputStream originalSystemInput = System.in;
        String testLanguage = "English";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(testLanguage.getBytes());
        System.setIn(byteArrayInputStream);

        TargetLanguage targetLanguage = new TargetLanguage();
        String result = targetLanguage.getUserInputLanguage();
        Assertions.assertEquals("English", result);

        System.setIn(originalSystemInput);
    }

    @Test
    void getFormattedInputLanguage(){
        Assertions.assertEquals("Hungarian", targetLanguage.getFormattedInputLanguage("HUNGARIAN"));
        Assertions.assertEquals("Italian", targetLanguage.getFormattedInputLanguage("iTALIAN"));
        Assertions.assertEquals("Korean", targetLanguage.getFormattedInputLanguage("kOrEaN"));
    }

    @Test
    void setNationalLanguageFormat(){
        Assertions.assertEquals("Chinese (simplified)", targetLanguage.getNationalLanguageFormat("Chinese"));
        Assertions.assertEquals("Portuguese (European)", targetLanguage.getNationalLanguageFormat("Portuguese"));
        Assertions.assertEquals("English (British)", targetLanguage.getNationalLanguageFormat("English"));
        Assertions.assertEquals("Spanish", targetLanguage.getNationalLanguageFormat("Spanish"));
    }
}
