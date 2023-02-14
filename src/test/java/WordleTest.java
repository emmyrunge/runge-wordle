import org.junit.jupiter.api.Test;
import runge.WordleDictionary;

import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordleTest
{
    @Test
    public void getDefinition() throws IOException
    {
        //given
        WordleDictionary wordle = new WordleDictionary();

        //when
        String word = wordle.getDefinition("BO");
        String newWord = wordle.getDefinition("AA");

        //then
        assertEquals("a pal [n BOS]", word);
        assertEquals("rough, cindery lava [n -S]", newWord);
    }

    @Test
    public void getList() throws IOException
    {
        //given
        WordleDictionary wordle = new WordleDictionary();
        //when
        ArrayList<String> wordList = wordle.getList();
        //then
        assertEquals(167964, wordList.size());

    }
}
