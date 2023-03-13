package runge.wordledictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WordleGameFrame extends JFrame
{
    private JLabel[][] letters = new JLabel[6][5];
    private JButton[] keyboard = new JButton[26];
    private WordleController controller;
    private JButton enter;
    private JButton backspace;

    public WordleGameFrame(WordleGame wordleGame, WordleDictionary dictionary)
    {
        controller = new WordleController(wordleGame,
                dictionary, letters, keyboard, enter, backspace);

        //main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JLabel wordleLabel = new JLabel("Wordle");
        wordleLabel.setVerticalAlignment(JLabel.TOP);
        wordleLabel.setSize(5, 5);
        wordleLabel.setFont(new Font("Monospace", Font.ITALIC, 100));
        wordleLabel.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(wordleLabel, BorderLayout.NORTH);


        //grid
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(6, 5, 20, 20)); //add two more ints for gaps
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                JLabel letterBox = new JLabel();
                letterBox.setBorder(BorderFactory.createLineBorder(Color.black, 3));
                letters[i][j] = letterBox;
                gridPanel.add(letters[i][j]);
            }
        }
        mainPanel.add(gridPanel, BorderLayout.CENTER);


        //keyboard
        JPanel keyboardGrid = new JPanel(new GridLayout(3, 10));
        JPanel keyboardLine1 = new JPanel();
        JPanel keyboardLine2 = new JPanel();
        JPanel keyboardLine3 = new JPanel();
        enter = new JButton("Return");
        backspace = new JButton("Delete");
        String[] row1 = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P"};
        String[] row2 = {"A", "S", "D", "F", "G", "H", "J", "K", "L"};
        String[] row3 = {"Z", "X", "C", "V", "B", "N", "M"};


        for (int i = 0; i < row1.length; i++)
        {
            keyboard[i] = new JButton(row1[i]);

            JButton letter = keyboard[i];
            requestFocus();
            letter.addActionListener(e ->
                    controller.addLetter(letter.getText()));

            keyboardLine1.add(keyboard[i]);
        }

        for (int j = 0; j < row2.length; j++)
        {
            keyboard[j] = new JButton(row2[j]);

            JButton letter = keyboard[j];
            requestFocus();
            letter.addActionListener(e ->
                    controller.addLetter(letter.getText()));

            keyboardLine2.add(keyboard[j], BorderLayout.CENTER);
        }

        for (int k = 0; k < row3.length; k++)
        {
            keyboard[k] = new JButton(row3[k]);

            JButton letter = keyboard[k];
            requestFocus();
            letter.addActionListener(e ->
                    controller.addLetter(letter.getText()));

            keyboardLine3.add(keyboard[k], BorderLayout.SOUTH);
        }


        //virtual keyboard
        enter.addActionListener(e ->
        {
            requestFocus();
            controller.enterGuess();
            System.out.println("Enter pressed");
        });
        keyboardLine2.add(enter);

        backspace.addActionListener(e ->
        {
            requestFocus();
            controller.backspaceLetter();
            System.out.println("Backspace pressed");
        });
        keyboardLine3.add(backspace);

        keyboardGrid.add(keyboardLine1, BorderLayout.NORTH);
        keyboardGrid.add(keyboardLine2, BorderLayout.CENTER);
        keyboardGrid.add(keyboardLine3, BorderLayout.CENTER);

        mainPanel.add(keyboardGrid, BorderLayout.SOUTH);

        setFocusable(true);
        requestFocus();

        //this is for the physical keyboard
        addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                char character = e.getKeyChar();
                if (Character.isAlphabetic(character))
                {
                    controller.addLetter(String.valueOf(e.getKeyChar()).toUpperCase());
                    System.out.println("Key " + e.getKeyChar() + " pressed");
                }
                else if (character == KeyEvent.VK_BACK_SPACE)
                {
                    //remove letter
                    controller.backspaceLetter();
                    System.out.println("Key 'backspace' pressed");
                }
                else if (character == KeyEvent.VK_ENTER)
                {
                    //take each letter, build into string and do .guess method
                    controller.enterGuess();
                    System.out.println("Key 'enter' pressed");
                }
            }

            @Override
            public void keyPressed(KeyEvent e)
            {
            }

            @Override
            public void keyReleased(KeyEvent e)
            {
            }
        });


        gridPanel.setOpaque(true);
        gridPanel.setBackground(new Color(192, 192, 192));
        mainPanel.setOpaque(true);
        mainPanel.setBackground(new Color(192, 192, 192));
        setContentPane(mainPanel);
        setSize(600, 1000);
        setTitle("Wordle Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}