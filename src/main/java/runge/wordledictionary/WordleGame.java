package runge.wordledictionary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class WordleGame
{
    private String randomWord;
    private final Random rand = new Random();
    private ArrayList<String> fiveLetterWords;


    public WordleGame() throws IOException
    {
        WordleDictionary dictionary = new WordleDictionary();
        ArrayList<String> wordList = dictionary.getList();

        fiveLetterWords = new ArrayList<>();
        for (int i = 0; i < wordList.size(); i++)
        {
            String word = wordList.get(i);
            if (word.length() == 5)
            {
                fiveLetterWords.add(word);
            }
        }
        randomWord = fiveLetterWords.get(rand.nextInt(fiveLetterWords.size()));
    }

    public CharResult[] guess(String guessWord)
    {
        CharResult[] status = new CharResult[5];

        for (int i = 0; i < randomWord.length(); i++)
        {
            char guessChar = guessWord.charAt(i);
            String guessString = String.valueOf(guessChar);

            if (randomWord.contains("" + guessString))
            {
                if (randomWord.charAt(i) == guessChar)
                {
                    status[i] = CharResult.Correct;
                }
                else
                {
                    status[i] = CharResult.WrongPlace;
                }
            }
            else
            {
                status[i] = CharResult.NotFound;
            }
        }
        return status;
    }


    public String getRandomWord()
    {
        return randomWord;
    }
}