package org.example;

public class TextProcessor {

    public static void main(String[] args) {
    }

    private static void validateInputs(StringBuilder text, StringBuilder replacement, int wordLength) {
        if (text == null || text.length() == 0) {
            throw new IllegalArgumentException("Input text is empty");
        }
        if (replacement == null) {
            throw new IllegalArgumentException("Replacement is empty");
        }
        if (wordLength <= 0) {
            throw new IllegalArgumentException("Word length must be positive");
        }
    }

    private static int appendChar(StringBuilder currentWord, char c, int letterCount) {
        currentWord.append(c);
        if (Character.isLetter(c)) {
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

    private static boolean isWordCharacter(char c) {
        return Character.isLetter(c) || c == '\'' || c == '’';
    }
}
