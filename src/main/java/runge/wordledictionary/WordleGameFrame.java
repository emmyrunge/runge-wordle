package runge.wordledictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class WordleGameFrame extends JFrame
{
    //String label = String.valueOf(new JLabel());
    //private JTextField[][] field;
    private String var;


    public WordleGameFrame(WordleGame game)
    {
        //main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        //text field where user guesses a word
        JTextField guessField = new JTextField("Guess here");
        mainPanel.add(guessField, BorderLayout.NORTH);

        //label that shows output of word guessed
        JLabel guessLabel = new JLabel();
        mainPanel.add(guessLabel, BorderLayout.CENTER);

        //button that once pressed sends guess field into guess method then outputs to label
        JButton button = new JButton("Guess");
        mainPanel.add(button, BorderLayout.SOUTH);

        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("GUESS CLICKED");

                var = guessField.getText();
                CharResult[] status = game.guess(var);
                guessLabel.setText("Output: " + Arrays.toString(status));
            }
        });

        setContentPane(mainPanel);
        setSize(600, 1000);
        setTitle("Wordle Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}