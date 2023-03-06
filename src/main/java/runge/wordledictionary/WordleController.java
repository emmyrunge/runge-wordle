package runge.wordledictionary;

import javax.swing.*;

public class WordleController
{
    private final WordleGame wordleGame;
    private final WordleDictionary dictionary;
    private final JLabel labels[][];
    private final JButton[] keyboard;
    private final JButton enter;
    private final JButton backspace;

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
        
    }

    public void enterGuess()
    {

    }

    public void backspaceLetter()
    {

    }
}
