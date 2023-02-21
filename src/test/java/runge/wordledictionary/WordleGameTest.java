package runge.wordledictionary;

import org.junit.jupiter.api.Test;

import java.io.CharArrayReader;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class WordleGameTest
{
    @Test
    public void WordleGameCorrectTest() throws IOException
    {

        //given
        WordleGame game1 = new WordleGame();

        //when
        String correctWord = game1.getRandomWord();
        CharResult[] correctArray = {CharResult.Correct, CharResult.Correct, CharResult.Correct, CharResult.Correct, CharResult.Correct};
        CharResult[] status = game1.guess(correctWord);

        //then
        assertArrayEquals(correctArray, status);

    }

    @Test
    public void WordleGameIncorrectTest() throws IOException
    {
        //given
        WordleGame game1 = new WordleGame();

        //when
        CharResult[] notCorrect = game1.guess("xxxxx");
        CharResult[] correctArray = {CharResult.Correct, CharResult.Correct,
                CharResult.Correct, CharResult.Correct, CharResult.Correct};

        boolean returnStatus = Arrays.equals(notCorrect,correctArray);

        //then
        assertFalse(false, String.valueOf(returnStatus));
    }
}
