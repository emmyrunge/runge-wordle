package runge.wordledictionary;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

import static org.mockito.Mockito.*;

class WordleGameFrameTest
{
    WordleGame wordleGame = mock(WordleGame.class);
    WordleDictionary dictionary = mock(WordleDictionary.class);
    JLabel labels[][] = new JLabel[][]{
            {mock(), mock(), mock(), mock(), mock()},
            {mock(), mock(), mock(), mock(), mock()},
            {mock(), mock(), mock(), mock(), mock()},
            {mock(), mock(), mock(), mock(), mock()},
            {mock(), mock(), mock(), mock(), mock()},
            {mock(), mock(), mock(), mock(), mock()},
    };

    JButton keyboard[] = new JButton[]{mock(), mock(), mock(), mock(), mock(),
            mock(), mock(), mock(), mock(), mock(), mock(),
            mock(), mock(), mock(), mock(), mock(), mock(),
            mock(), mock(), mock(), mock(), mock(), mock(),
            mock(), mock(), mock()};
    JButton enter = mock();
    JButton backspace = mock();

    @Test
    public void addLetter()
    {
        //given
        WordleController controller = new WordleController(
                wordleGame,
                dictionary,
                labels,
                keyboard,
                enter,
                backspace
        );
        doReturn("").when(labels[0][0]).getText();

        //when
        controller.addLetter("A");

        //then
        verify(labels[0][0]).setText("A");
    }

    @Test
    public void backspaceLetter()
    {
        //given
        WordleController controller = new WordleController(
                wordleGame,
                dictionary,
                labels,
                keyboard,
                enter,
                backspace
        );
        controller.addLetter("A");
        when(labels[0][1].getText()).thenReturn("");

        //when
        controller.backspaceLetter();

        //then
        verify(labels[0][0]).setText("");
    }

    @Test
    public void enterGuess()
    {
        //given
        WordleController controller = new WordleController(
                wordleGame,
                dictionary,
                labels,
                keyboard,
                enter,
                backspace
        );
        controller.guessWord.append("WHALE");
        controller.row = 1;
        ArrayList<String> correctList = new ArrayList<>(Collections.singletonList("WHALE"));
        doReturn(correctList).when(wordleGame).getFiveLetterWords();
        doReturn("WHALE").when(wordleGame).getRandomWord();
        doReturn("").when(dictionary).getDefinition("WHALE");
        doReturn(new CharResult[]{CharResult.Correct, CharResult.Correct, CharResult.Correct,
                CharResult.Correct, CharResult.Correct}).when(wordleGame).guess("WHALE");

        //when
        controller.enterGuess();

        //then
        verify(labels[0][0]).setBackground(Color.GREEN);
        verify(labels[0][1]).setBackground(Color.GREEN);
        verify(labels[0][2]).setBackground(Color.GREEN);
        verify(labels[0][3]).setBackground(Color.GREEN);
        verify(labels[0][4]).setBackground(Color.GREEN);
    }
}