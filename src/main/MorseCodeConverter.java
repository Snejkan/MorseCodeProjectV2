package main;

import java.util.HashMap;
import java.util.Map;

public class MorseCodeConverter {
    private static final Map<String, Character> morseToEnglishMap = new HashMap<>();
    private static final Map<Character, String> englishToMorseMap = new HashMap<>();

    static {
        morseToEnglishMap.put("*-", 'A');
        morseToEnglishMap.put("-***", 'B');
        morseToEnglishMap.put("-*-*", 'C');
        morseToEnglishMap.put("-**", 'D');
        morseToEnglishMap.put("*", 'E');
        morseToEnglishMap.put("**-*", 'F');
        morseToEnglishMap.put("--*", 'G');
        morseToEnglishMap.put("****", 'H');
        morseToEnglishMap.put("**", 'I');
        morseToEnglishMap.put("*---", 'J');
        morseToEnglishMap.put("-*-", 'K');
        morseToEnglishMap.put("*-**", 'L');
        morseToEnglishMap.put("--", 'M');
        morseToEnglishMap.put("-*", 'N');
        morseToEnglishMap.put("---", 'O');
        morseToEnglishMap.put("*--*", 'P');
        morseToEnglishMap.put("--*-", 'Q');
        morseToEnglishMap.put("*-*", 'R');
        morseToEnglishMap.put("***", 'S');
        morseToEnglishMap.put("-", 'T');
        morseToEnglishMap.put("**-", 'U');
        morseToEnglishMap.put("***-", 'V');
        morseToEnglishMap.put("*--", 'W');
        morseToEnglishMap.put("-**-", 'X');
        morseToEnglishMap.put("-*--", 'Y');
        morseToEnglishMap.put("--**", 'Z');


        morseToEnglishMap.put(" ", ' ');


        for (Map.Entry<String, Character> entry : morseToEnglishMap.entrySet()) {
            englishToMorseMap.put(entry.getValue(), entry.getKey());
        }
    }



        public static String morseToEnglish(String morseCode) throws InvalidMorseCodeException {
            StringBuilder englishText = new StringBuilder();
            String[] words = morseCode.trim().split(" ");

            for (String word : words) {
                String[] letters = word.split(" ");
                for (String letter : letters) {
                    Character englishChar = morseToEnglishMap.get(letter);
                    if (englishChar == null) {
                        throw new InvalidMorseCodeException("Invalid Morse code" + letter);
                    }
                    englishText.append(englishChar);
                }
                englishText.append(' ');
            }

            return englishText.toString().trim();
        }

        public static String englishToMorse(String englishText) throws InvalidCharacterException {
            StringBuilder morseCode = new StringBuilder();

            for (char character : englishText.toCharArray()) {
                if (Character.isLetterOrDigit(character)) {
                    String morseChar = englishToMorseMap.get(Character.toUpperCase(character));
                    if (morseChar == null) {
                        throw new InvalidCharacterException("Invalid character: " + character);
                    }
                    morseCode.append(morseChar).append(' ');
                } else if (character == ' ') {
                    morseCode.append(' ');
                } else {
                    throw new InvalidCharacterException("Invalid character: " + character);
                }
            }

            return morseCode.toString().trim();
        }
    }



