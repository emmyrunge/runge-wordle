package runge.wordledictionary;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<String> words = new HashSet<>(List.of("APPLE"));
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
        Set<String> words = new HashSet<>(List.of("APPLE"));
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
