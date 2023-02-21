package runge.wordledictionary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class WordleGame
{
    private ArrayList<String> wordList;
    private String randomWord;
    private final Random rand = new Random();
    private ArrayList<String> fiveLetterWords;


    public WordleGame() throws IOException
    {
        WordleDictionary dictionary = new WordleDictionary();
        wordList = dictionary.getList();

        fiveLetterWords = new ArrayList<>();
        for (int i = 0; i < wordList.size(); i++)
        {
            if (wordList.get(i).length() == 5)
            {
                fiveLetterWords.add(wordList.get(i));
            }
        }
        randomWord = fiveLetterWords.get(rand.nextInt(fiveLetterWords.size()));
    }

    public CharResult[] guess(String guessWord) throws IOException
    {
        //gets random word from wordList
        CharResult[] status = new CharResult[5];

        for (int i = 0; i < randomWord.length(); i++) //iterate 5 times
        {
            if (randomWord.contains("" + guessWord.charAt(i)))
            {
                if (randomWord.charAt(i) == guessWord.charAt(i)) //if letters equals in exact spot
                {
                    status[i] = CharResult.Correct;
                }
                else
                {
                    status[i] = CharResult.WrongPlace;
                }
            }
            else //letter not in word
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


/*

1) wordle sets a random word
2) user will guess a word 5 times
    each guess is one round
3) if letter = true, tell them it is Correct (from enum)
       if letter = wrong spot but right letter, tell them it is in WrongPlace (from enum)
       if letter = wrong everything, tell them it is wrong (from enum)

4) once person runs out of guesses
    if they got it = yay
    if they didn't = boo
        if they get it before (aka all letters return correct, they're super smart)
 */