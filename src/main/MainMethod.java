package main;

import java.util.Scanner;

public class MainMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose conversion type:");
        System.out.println("1. Morse code to English");
        System.out.println("2. English to Morse code");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.print("Enter Morse code: ");
            String morseCode = scanner.nextLine();
            try {
                String englishText = MorseCodeConverter.morseToEnglish(morseCode);
                System.out.println("English: " + englishText);
            } catch (InvalidMorseCodeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else if (choice == 2) {
            System.out.print("Enter English text: ");
            String englishText = scanner.nextLine();
            try {
                String morseCode = MorseCodeConverter.englishToMorse(englishText);
                System.out.println("Morse Code: " + morseCode);
            } catch (InvalidCharacterException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}