package test;

import com.deepl.api.Language;
import org.cleancode.DeeplAPIWrapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeeplAPIWrapperTest {

    DeeplAPIWrapper deeplAPIWrapper;
    ArrayList<String> supportedLanguagesNamesCheckList = new ArrayList<>(Arrays.asList("Bulgarian",
            "Czech", "Danish", "German", "Greek", "English (British)", "English (American)", "Spanish", "Estonian", "Finnish", "French",
            "Hungarian", "Indonesian", "Italian", "Japanese", "Korean", "Lithuanian", "Latvian", "Norwegian",
            "Dutch", "Polish", "Portuguese (Brazilian)", "Portuguese (European)", "Romanian", "Russian", "Slovak", "Slovenian", "Swedish", "Turkish",
            "Ukrainian", "Chinese (simplified)"));

    @BeforeEach
    public void setUp() {
        deeplAPIWrapper = new DeeplAPIWrapper();
    }

    @AfterEach
    public void tearDown() {
        deeplAPIWrapper = null;
    }

    @Test
    public void getLanguages() {
        List<Language> supportedLanguagesWithCodesList = deeplAPIWrapper.getSupportedLanguages();
        ArrayList<String> supportedLanguagesNamesList = new ArrayList<>();
        for (Language language : supportedLanguagesWithCodesList) {
            supportedLanguagesNamesList.add(language.getName());
        }
        assertEquals(supportedLanguagesNamesList, supportedLanguagesNamesCheckList);
    }

    @Test
    public void getLanguageNamesList(){
        ArrayList<String> supportedLanguagesNamesList = deeplAPIWrapper.getSupportedLanguageNamesList(deeplAPIWrapper.getSupportedLanguages());

        assertEquals(supportedLanguagesNamesCheckList, supportedLanguagesNamesList);
    }

    @Test
    public void getLanguageCode() {
        String apiCodeSpanish = deeplAPIWrapper.getLanguageCode("Spanish");
        String apiCodePortuguese = deeplAPIWrapper.getLanguageCode("Portuguese (Brazilian)");
        String apiCodePolish = deeplAPIWrapper.getLanguageCode("Polish");
        String apiCodeChinese = deeplAPIWrapper.getLanguageCode("Chinese (simplified)");

        assertEquals("es", apiCodeSpanish);
        assertEquals("pt-BR", apiCodePortuguese);
        assertEquals("pl", apiCodePolish);
        assertEquals("zh", apiCodeChinese);
    }

    @Test
    public void getTranslatedHeading() throws Exception {
        String headingEnglish = "Hello";

        String expectedTranslationItalian = "Ciao";
        String expectedTranslationFrench = "Bonjour";
        String expectedTranslationGerman = "Hallo";

        assertEquals(expectedTranslationItalian, deeplAPIWrapper.getTranslatedHeading(headingEnglish, "it"));
        assertEquals(expectedTranslationFrench, deeplAPIWrapper.getTranslatedHeading(headingEnglish, "fr"));
        assertEquals(expectedTranslationGerman, deeplAPIWrapper.getTranslatedHeading(headingEnglish, "de"));

    }

}
