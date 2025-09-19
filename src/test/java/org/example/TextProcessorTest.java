package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TextProcessorTest {

    @Test
    void testSimpleReplacement() {
        StringBuilder text = new StringBuilder("Hello world");
        StringBuilder replacement = new StringBuilder("$$$");
        StringBuilder result = TextProcessor.replaceWords(text, replacement, 5);

        assertEquals("$$$ $$$", result.toString());
    }

    @Test
    void testMultipleReplacements() {
        StringBuilder text = new StringBuilder("These words shall be masked");
        StringBuilder replacement = new StringBuilder("***");
        StringBuilder result = TextProcessor.replaceWords(text, replacement, 5);

        assertEquals("*** *** *** be masked", result.toString());
    }

    @Test
    void testAllWordsSameLength() {
        StringBuilder text = new StringBuilder("alpha bravo begin");
        StringBuilder replacement = new StringBuilder("A");
        StringBuilder result = TextProcessor.replaceWords(text, replacement, 5);

        assertEquals("A A A", result.toString());
    }

    @Test
    void testNoWordsOfRequiredLength() {
        StringBuilder text = new StringBuilder("This sentence has no matching length words.");
        StringBuilder replacement = new StringBuilder("XXX");
        StringBuilder result = TextProcessor.replaceWords(text, replacement, 20);

        assertEquals("This sentence has no matching length words.", result.toString());
    }

    @Test
    void testReplacementWithPunctuation() {
        StringBuilder text = new StringBuilder("Write, tests. First?");
        StringBuilder replacement = new StringBuilder("###");
        StringBuilder result = TextProcessor.replaceWords(text, replacement, 5);

        assertEquals("###, ###. ###?", result.toString());
    }

    @Test
    void testReplacementWithMixedSpacing() {
        StringBuilder text = new StringBuilder("test   test\ttest\ntest");
        StringBuilder replacement = new StringBuilder("R");
        StringBuilder result = TextProcessor.replaceWords(text, replacement, 4);

        assertEquals("R   R\tR\nR", result.toString());
    }

    @Test
    void testReplacementAtEndOfSentence() {
        StringBuilder text = new StringBuilder("Build features strong");
        StringBuilder replacement = new StringBuilder("XXX");
        StringBuilder result = TextProcessor.replaceWords(text, replacement, 6);

        assertEquals("Build features XXX", result.toString());
    }

    @Test
    void testOnlyPunctuation() {
        StringBuilder text = new StringBuilder("!!! ??? ... ))) ((( [[[ ]]] {{{ }}}");
        StringBuilder replacement = new StringBuilder("R");
        StringBuilder result = TextProcessor.replaceWords(text, replacement, 3);

        assertEquals("!!! ??? ... ))) ((( [[[ ]]] {{{ }}}", result.toString());
    }

    @Test
    void testLongText() {
        StringBuilder text = new StringBuilder("Java programming is very popular nowadays among developers");
        StringBuilder replacement = new StringBuilder("###");
        StringBuilder result = TextProcessor.replaceWords(text, replacement, 7);

        assertEquals("Java programming is very ### nowadays among developers", result.toString());
    }

    @Test
    void testReplacementWordLongerThanOriginal() {
        StringBuilder text = new StringBuilder("code test");
        StringBuilder replacement = new StringBuilder("LONG_REPLACEMENT");
        StringBuilder result = TextProcessor.replaceWords(text, replacement, 4);

        assertEquals("LONG_REPLACEMENT LONG_REPLACEMENT", result.toString());
    }

    @Test
    void testReplacementWordShorterThanOriginal() {
        StringBuilder text = new StringBuilder("replace longword here");
        StringBuilder replacement = new StringBuilder("R");
        StringBuilder result = TextProcessor.replaceWords(text, replacement, 8);

        assertEquals("replace R here", result.toString());
    }

    @Test
    void testApostropheInWordsNoReplacement() {
        StringBuilder text = new StringBuilder("Don't stop believing");
        StringBuilder replacement = new StringBuilder("XXX");
        StringBuilder result = TextProcessor.replaceWords(text, replacement, 5);

        assertEquals("Don't stop believing", result.toString());
    }

    @Test
    void testApostropheInWordsWithReplacement() {
        StringBuilder text = new StringBuilder("Don't go");
        StringBuilder replacement = new StringBuilder("YES");
        StringBuilder result = TextProcessor.replaceWords(text, replacement, 4);

        assertEquals("YES go", result.toString());
    }

    @Test
    void testMultipleWordsWithApostrophes() {
        StringBuilder text = new StringBuilder("It's John's book. He won’t read yours.");
        StringBuilder replacement = new StringBuilder("XXX");
        StringBuilder result = TextProcessor.replaceWords(text, replacement, 5);

        assertEquals("It's XXX book. He won’t read XXX.", result.toString());
    }

    @Test
    void testWordWithUnicodeApostrophe() {
        StringBuilder text = new StringBuilder("He won’t leave");
        StringBuilder replacement = new StringBuilder("NO");
        StringBuilder result = TextProcessor.replaceWords(text, replacement, 4);

        assertEquals("He NO leave", result.toString());
    }

    @Test
    void testEmptyTextThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> TextProcessor.replaceWords(new StringBuilder(""), new StringBuilder("X"), 3));
    }

    @Test
    void testNullTextThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> TextProcessor.replaceWords(null, new StringBuilder("X"), 3));
    }

    @Test
    void testNullReplacementThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> TextProcessor.replaceWords(new StringBuilder("Hello"), null, 5));
    }

    @Test
    void testZeroWordLengthThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> TextProcessor.replaceWords(new StringBuilder("Hello"), new StringBuilder("X"), 0));
    }

    @Test
    void testNegativeWordLengthThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> TextProcessor.replaceWords(new StringBuilder("Hello"), new StringBuilder("X"), -1));
    }
}
