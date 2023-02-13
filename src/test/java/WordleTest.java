import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

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
        //then
        assertEquals("a pal [n BOS]", word);
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
