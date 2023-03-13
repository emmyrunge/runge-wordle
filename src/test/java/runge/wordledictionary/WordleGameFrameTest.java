package runge.wordledictionary;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
    int row = 0;
    int column = 0;

    @Test
    void addLetter()
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


        //when
        controller.addLetter("A");

        //then
        verify(labels[row][column].setText("A"));
        //doThrow(new RuntimeException("Error")).when(labels[row][column].setText("A"));
    }
}