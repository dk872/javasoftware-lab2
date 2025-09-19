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
}
