package org.example;

public class TextProcessor {

    public static void main(String[] args) {
        try {
            StringBuilder text = new StringBuilder("Write tests first, then build the features.");
            StringBuilder replacement = new StringBuilder("$$$");
            int wordLength = 5;

            System.out.println("Initial text: " + text);
            StringBuilder result = replaceWords(text, replacement, wordLength);
            System.out.println("Processed text: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println("Input error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unknown error: " + e.getMessage());
        }
    }

    public static StringBuilder replaceWords(StringBuilder text, StringBuilder replacement, int wordLength) {
        validateInputs(text, replacement, wordLength);

        StringBuilder result = new StringBuilder();
        StringBuilder currentWord = new StringBuilder();
        int letterCount = 0;

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (isWordCharacter(currentChar)) {
                letterCount = appendChar(currentWord, currentChar, letterCount);
            } else {
                flushWord(result, currentWord, replacement, wordLength, letterCount);
                result.append(currentChar);
                letterCount = 0;
            }
        }

        flushWord(result, currentWord, replacement, wordLength, letterCount);
        return result;
    }

    private static void validateInputs(StringBuilder text, StringBuilder replacement, int wordLength) {
        if (text == null || text.length() == 0) {
            throw new IllegalArgumentException("Input text is empty");
        }
        if (replacement == null) {
            throw new IllegalArgumentException("Replacement is null");
        }
        if (wordLength <= 0) {
            throw new IllegalArgumentException("Word length must be positive");
        }
    }

    private static int appendChar(StringBuilder currentWord, char currentChar, int letterCount) {
        currentWord.append(currentChar);
        if (Character.isLetter(currentChar)) {
            letterCount++;
        }

        return letterCount;
    }

    private static void flushWord(StringBuilder result, StringBuilder word,
                                  StringBuilder replacement, int wordLength, int letterCount) {
        if (word.length() == 0) return;

        result.append(letterCount == wordLength ? replacement : word);
        word.setLength(0);
    }

    private static boolean isWordCharacter(char currentChar) {
        return Character.isLetter(currentChar) || currentChar == '\'' || currentChar == '’';
    }
}
