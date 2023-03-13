package runge.wordledictionary;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class WordleController
{
    private final WordleGame wordleGame;
    private final WordleDictionary dictionary;
    private final JLabel labels[][];
    private final JButton[] keyboard;
    private final JButton enter;
    private final JButton backspace;
    private StringBuilder guessWord = new StringBuilder();
    private int row = 0;
    private int column = 0;


    public WordleController(WordleGame wordleGame, WordleDictionary dictionary,
                            JLabel[][] labels, JButton[] keyboard, JButton enter, JButton backspace)
    {
        this.wordleGame = wordleGame;
        this.dictionary = dictionary;
        this.labels = labels;
        this.keyboard = keyboard;
        this.enter = enter;
        this.backspace = backspace;
    }

    public void addLetter(String letter)
    {
        //TEST BUG: gets string and returns void, so inner .setText is void
        JLabel spot = labels[row][column];

        guessWord.append(letter);

        if (spot.getText().isEmpty())
        {
            spot.setText(letter);
            spot.setHorizontalAlignment(SwingConstants.CENTER);
            spot.setFont(new Font("Helvetica Neue", Font.ITALIC, 20));
            //BUG: one letter not word
            System.out.println(guessWord);
        }
        else
        {
            spot.setText("");
        }
        if (column < 4)
        {
            column++;
        }
        else
        {
            row++;
            column = 0;
        }
    }


    public void enterGuess()
    {
        //make sure user has a guess left
        //once all five spots have been filled
        //and word is in list
        String lookFor = guessWord.toString();
        String correctWord = wordleGame.getRandomWord();
        System.out.println(correctWord);
        if (wordleGame.getFiveLetterWords().contains(lookFor))
        {
            if (column == 0)
            {
                row--;
                CharResult[] result = wordleGame.guess(String.valueOf(guessWord));
                //CharResult[] correctValues = {CharResult.Correct, CharResult.Correct, CharResult.Correct, CharResult.Correct, CharResult.Correct};
                for (int i = 0; i < guessWord.length(); i++)
                {
                    //enter guess and run the .guess method
                    if (result[i] == CharResult.Correct)
                    {
                        labels[row][column].setOpaque(true);
                        labels[row][column].setBackground(new Color(0, 204, 0));
                        column++;
                    }
                    else if (result[i] == CharResult.WrongPlace)
                    {
                        labels[row][column].setOpaque(true);
                        labels[row][column].setBackground(new Color(213, 228, 13));
                        column++;
                    }
                    else
                    {
                        labels[row][column].setOpaque(true);
                        labels[row][column].setBackground(new Color(155, 155, 155));
                        column++;
                    }
                }
                if (Objects.equals(correctWord, guessWord.toString()))
                {
                    JOptionPane.showMessageDialog(null, "GOOD JOB!");
                    System.exit(0);
                }
                row++;
                column = 0;
                guessWord.delete(0, 5);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Word is not found, try again");
        }

        if (row >= 6)
        {
            JOptionPane.showMessageDialog(null, "The word was: " + correctWord + ". Better luck next time");
            System.exit(1);

        }
    }

    public void backspaceLetter()
    {
        //BUG: for some reason already sets the text to ""
        //spot = labels[row][column];
        //get the label, set text to "" and then go back one label
        if (labels[row][column].getText().isEmpty())
        {
            if (row > 0 && column == 0)
            {
                --row;
                column += 4;
                labels[row][column].setText("");
            }
            else
            {
                column--;
                labels[row][column].setText("");
                //moves the spot im looking at one column back
            }
        }
        guessWord.deleteCharAt(column);
    }
}