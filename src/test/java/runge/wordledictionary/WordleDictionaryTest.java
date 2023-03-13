package runge.wordledictionary;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordleDictionaryTest
{
    @Test
    public void getList() throws IOException
    {
        //given
        WordleDictionary wordle = new WordleDictionary();
        //when
        Set<String> wordList = wordle.getList();
        //then
        assertEquals(167964, wordList.size());

    }

    @Test
    public void getDefinition() throws IOException
    {
        WordleDictionary wordle = new WordleDictionary();

        String definition = String.format(wordle.getDefinition("FORMATTING"));

        assertEquals("<format=v> [v]", definition);
    }
}
