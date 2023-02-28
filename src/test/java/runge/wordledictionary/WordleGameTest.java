package runge.wordledictionary;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static runge.wordledictionary.CharResult.*;

public class WordleGameTest
{
    @Test
    public void correctGuess()
    {

        //given
        WordleDictionary dictionary = Mockito.mock(WordleDictionary.class);
        ArrayList<String> words = new ArrayList<>(List.of("APPLE"));
        doReturn(words).when(dictionary).getList();
        WordleGame game1 = new WordleGame(dictionary);

        //when
        CharResult[] status = game1.guess("APPLE");

        //then
        CharResult[] correctArray = {Correct, Correct, Correct, Correct, Correct};
        assertArrayEquals(correctArray, status);

    }

    @Test
    public void incorrectGuess()
    {
        //given
        WordleDictionary dictionary = Mockito.mock(WordleDictionary.class);
        ArrayList<String> words = new ArrayList<>(List.of("APPLE"));
        doReturn(words).when(dictionary).getList();
        WordleGame game1 = new WordleGame(dictionary);

        //when
        CharResult[] incorrectGuess = game1.guess("APRES");
        CharResult[] correctArray = {Correct, Correct,
                NotFound, WrongPlace, NotFound};

        boolean returnStatus = Arrays.equals(incorrectGuess, correctArray);

        //then
        assertTrue(returnStatus);
    }
}
