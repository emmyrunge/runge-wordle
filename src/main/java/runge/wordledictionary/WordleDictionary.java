package runge.wordledictionary;

import java.io.*;
import java.util.*;

public class WordleDictionary
{
    private ArrayList<String> definitionSplit;
    private ArrayList<String> wordSplit;

    private final BufferedReader bufferedReader;


    public WordleDictionary() throws IOException
    {
        wordSplit = new ArrayList<>();
        definitionSplit = new ArrayList<>();

        File dictionary = new File("src/main/java/runge/wordledictionary/dictionary.txt");
        bufferedReader = new BufferedReader(new FileReader(dictionary));
        String line = bufferedReader.readLine();

        while (line != null)
        {
            String[] splitLine = line.split(" ", 2);
            if (splitLine.length == 1)
            {
                wordSplit.add(splitLine[0]);
            }
            else
            {
                wordSplit.add(splitLine[0]);
                definitionSplit.add(splitLine[1]);
            }
            line = bufferedReader.readLine();
        }

    }

    public String getDefinition(String word)
    {
        for (int i = 0; i < wordSplit.size(); i++)
        {
            if (word.equals(wordSplit.get(i)))
            {
                return definitionSplit.get(i);
            }
        }
        return null;
    }

    public ArrayList<String> getList()
    {
        return wordSplit;
    }
}
