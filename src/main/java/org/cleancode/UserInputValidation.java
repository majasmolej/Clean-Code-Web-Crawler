package org.cleancode;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

//TODO: JUnit tests
public class UserInputValidation {

    public boolean isValidDomain(String userInputDomain){
        String domainRegex = "^(?:www\\.)?[a-zA-Z0-9-]+\\.[a-z]{2,}";
        return userInputDomain.matches(domainRegex);
    }
    public boolean isValidURL(String userInputURL) throws MalformedURLException, URISyntaxException {
        if (isEmptyURL(userInputURL)) {
            return false;
        }else if(!matchesURLRegex(userInputURL)){
            return false;
        }else if(!isValidURLwithJDK(userInputURL)){
            return false;
        }
        return true;
    }

    //Accepted depth: from 0 (just website with the URL from UserInput) to 2
    public boolean isValidDepth(byte userInputDepth){
        String regex = "[012]";
        String userInputDepthStr = Byte.toString(userInputDepth);
        return userInputDepthStr.matches(regex);
    }

    //TODO: depending on the chosen API for translation, implement this method to accept only available target languages (and possibly add an extra method to convert them to a language code, f.e. "English" to "EN")
    public boolean isValidTargetLanguage(String userInputTargetLanguage){
        return true;
    }

    private boolean isEmptyURL (String userInputURL){
        return userInputURL==null||userInputURL.trim().isEmpty();
    }
    private boolean matchesURLRegex (String userInputURL){
        final String urlRegex = "^(http|https)://[a-zA-Z0-9\\-.]+\\.[a-zA-Z]{2,3}(:\\d+)?/?([a-zA-Z0-9\\-._?,'/+&%$#=~])*[\\w\\-._?,'/+&%$#=~]$";
        return userInputURL.matches(urlRegex);
    }

    private boolean isValidURLwithJDK(String userInputURL) throws MalformedURLException, URISyntaxException{
        try{
            new URL(userInputURL).toURI();
            return true;
        }catch (MalformedURLException | URISyntaxException malformedURLException){
            return false;
        }

    }

}
