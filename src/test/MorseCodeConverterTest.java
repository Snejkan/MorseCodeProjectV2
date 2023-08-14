package test;

import main.InvalidCharacterException;
import main.InvalidMorseCodeException;
import main.MorseCodeConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MorseCodeConverterTest {

    @Test
    public void testMorseToEnglish() throws InvalidMorseCodeException {
        String morseCode = "*- -***";
        String expectedEnglish = "A B";
        String actualEnglish = MorseCodeConverter.morseToEnglish(morseCode);
        Assertions.assertEquals(expectedEnglish, actualEnglish);
    }


    @Test
    public void testEnglishToMorse() throws InvalidCharacterException {
        String englishText = "HELLO";
        String expected = "**** * *-** *-** ---";
        String actual = MorseCodeConverter.englishToMorse(englishText);
        Assertions.assertEquals(expected, actual);
    }



    @Test
    public void testInvalidCharacter() {
        Assertions.assertThrows(InvalidCharacterException.class, () -> {
            MorseCodeConverter.englishToMorse("Invalid Character!");
        });
    }

}

