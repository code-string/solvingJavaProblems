package countDuplicateCharacters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StringsTest {

    String text;
    Map<Character, Integer> expectedResult;
    Map<Character, Long> expectedResult2;
    @BeforeEach
    void setUp() {
        text = "my name is bola";
        expectedResult = new HashMap<>();
        expectedResult.put('m', 2);
        expectedResult.put('a', 2);
        expectedResult.put('s', 1);
        expectedResult.put('y', 1);
        expectedResult.put('n', 1);
        expectedResult.put('e', 1);
        expectedResult.put('b', 1);
        expectedResult.put('o', 1);
        expectedResult.put('l', 1);
        expectedResult.put(' ', 3);
        expectedResult.put('i', 1);

        expectedResult2 = new HashMap<>();
        expectedResult2.put('m', (long)2);
        expectedResult2.put('a', (long)2);
        expectedResult2.put('s', (long)1);
        expectedResult2.put('y', (long)1);
        expectedResult2.put('n', (long)1);
        expectedResult2.put('e', (long)1);
        expectedResult2.put('b', (long)1);
        expectedResult2.put('o', (long)1);
        expectedResult2.put('l', (long)1);
        expectedResult2.put(' ', (long)3);
        expectedResult2.put('i', (long)1);
    }

    @Test
    public void returnEmptyWhenArgumentIsBlank(){
        Map<Character, Integer> resultMap = Strings.countDuplicateCharacters("");
        assertEquals(Collections.emptyMap(), resultMap);
    }

    @Test
    void returnEmptyWhenArgumentIsNull(){
        Map<Character, Integer> resultMap = Strings.countDuplicateCharacters(null);
        assertEquals(Collections.emptyMap(), resultMap);
    }

    @Test
    void countDuplicateCharacters() {
        Map<Character, Integer> resultMap = Strings.countDuplicateCharacters(text);
        assertEquals(expectedResult, resultMap);
    }
    @Test
    void countDuplicateCharactersViaStreamsTest(){
        Map<Character, Long> resultMap = Strings.countDuplicateCharactersViaStreams(text);
        assertEquals(expectedResult2, resultMap);
    }
}