package runge.wordledictionary;

import javax.swing.*;
import java.awt.*;

public class WordleController
{
    private final WordleGame wordleGame;
    private final WordleDictionary dictionary;
    private final JLabel labels[][];
    private final JButton[] keyboard;
    private final JButton enter;
    private final JButton backspace;
    StringBuilder guessWord = new StringBuilder();
    int row = 0;
    private int column = 0;


    public WordleController(WordleGame wordleGame, WordleDictionary dictionary,
                            JLabel[][] labels, JButton[] keyboard, JButton enter, JButton backspace) {
        this.wordleGame = wordleGame;
        this.dictionary = dictionary;
        this.labels = labels;
        this.keyboard = keyboard;
        this.enter = enter;
        this.backspace = backspace;
    }

    public void addLetter(String letter) {
        JLabel spot = labels[row][column];

        guessWord.append(letter);

        spot.setText(letter);
        spot.setHorizontalAlignment(SwingConstants.CENTER);
        spot.setFont(new Font("Helvetica Neue", Font.ITALIC, 20));
        System.out.println(guessWord);

        if (column < 4)
        {
            column++;
        } else
        {
            row++;
            column = 0;
        }
    }


    public void enterGuess() {
        String lookFor = guessWord.toString();
        String correctWord = wordleGame.getRandomWord();
        System.out.println(correctWord);
        if (wordleGame.getFiveLetterWords().contains(lookFor))
        {
            if (column == 0)
            {
                row--;
                CharResult[] result = wordleGame.guess(String.valueOf(guessWord));
                for (int i = 0; i < guessWord.length(); i++)
                {
                    if (result[i] == CharResult.Correct)
                    {
                        labels[row][column].setOpaque(true);
                        labels[row][column].setBackground(Color.GREEN);
                        column++;
                    } else if (result[i] == CharResult.WrongPlace)
                    {
                        labels[row][column].setOpaque(true);
                        labels[row][column].setBackground(Color.YELLOW);
                        column++;
                    } else
                    {
                        labels[row][column].setOpaque(true);
                        labels[row][column].setBackground(Color.GRAY);
                        column++;
                    }
                }
                row++;
                column = 0;
                guessWord.delete(0, 5);
            }
        }
    }

    public void backspaceLetter() {
        if (labels[row][column].getText().isEmpty())
        {
            if (row > 0 && column == 0)
            {
                --row;
                column += 4;
                labels[row][column].setText("");
                guessWord.deleteCharAt(column);
            } else
            {
                column--;
                labels[row][column].setText("");
                guessWord.deleteCharAt(column);
            }
        } else
        {
            row++;
            column += 4;
        }
    }
}