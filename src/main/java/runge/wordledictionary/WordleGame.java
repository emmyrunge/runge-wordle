package runge.wordledictionary;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class WordleGame
{
    private final Random rand = new Random();
    private final ArrayList<String> fiveLetterWords;
    private String randomWord;


    public WordleGame(WordleDictionary dictionary)
    {
        Set<String> wordList = dictionary.getList();
        fiveLetterWords = new ArrayList<>();

        for (String word : wordList)
        {
            if (word.length() == 5)
            {
                fiveLetterWords.add(word);
            }
        }
        randomWord = fiveLetterWords.get(rand.nextInt(fiveLetterWords.size()));
    }

    public String getRandomWord()
    {
        return randomWord;
    }

    public ArrayList<String> getFiveLetterWords()
    {
        return fiveLetterWords;
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
}