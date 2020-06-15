package com.perichandra.autocomplete.dictionary;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AutoCompDictionaryTest {

    AutoCompDictionary autoCompDictionary = new AutoCompDictionary();
    private static final int dictSize = 10;
    @Test
    public void getWordsStartingWith() {
        List<String>  results = autoCompDictionary.getWordsStartingWith("");
        assertTrue(results != null);
        assertEquals(0, results.size());
    }

    @Test
    public void getWordsStartingWith_null_input() {
        List<String>  results = autoCompDictionary.getWordsStartingWith(null);
        assertTrue(results != null);
        assertEquals(0, results.size());
    }

    @Test
    public void getWordsStartingWith_1() {
        List<String>  results = autoCompDictionary.getWordsStartingWith("t");
        assertTrue(results != null);
        assertEquals(dictSize, results.size());
    }

    @Test
    public void getWordsStartingWith_2() {
        List<String>  results = autoCompDictionary.getWordsStartingWith("ta");
        assertTrue(results != null);
        assertEquals(9, results.size());
    }


    @Test
    public void getWordsStartingWith_3() {
        List<String>  results = autoCompDictionary.getWordsStartingWith("tar");
        assertTrue(results != null);
        assertEquals(8, results.size());
    }

    @Test
    public void getWordsStartingWith_4() {
        List<String>  results = autoCompDictionary.getWordsStartingWith("tarz");
        assertTrue(results != null);
        assertEquals(0, results.size());
    }


    @Test
    public void getWordsStartingWith_sorted() {
        List<String>  results = autoCompDictionary.getWordsStartingWith("tar");
        assertTrue(results != null);
        assertEquals(8, results.size());
        assertEquals("tarsal", results.get(0));
        assertEquals("tarsale", results.get(1));
        System.out.println(results);
    }
}
