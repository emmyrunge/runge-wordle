package runge.wordledictionary;

import java.io.IOException;

public class WordleGameMain
{
    public static void main(String[] args) throws IOException
    {
        WordleGame game = new WordleGame(new WordleDictionary());
        WordleDictionary dictionary = new WordleDictionary();
        WordleGameFrame frame = new WordleGameFrame(game, dictionary);
        frame.setVisible(true);
    }
}
