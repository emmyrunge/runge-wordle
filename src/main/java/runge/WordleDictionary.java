package runge;

import java.io.*;
import java.util.*;

public class WordleDictionary
{
    private ArrayList<String> definitionSplit;
    private ArrayList<String> wordSplit;
    private final File dictionary;

    private final BufferedReader bufferedReader;

    public File getDictionary()
    {
        return dictionary;
    }

    public WordleDictionary() throws IOException
    {
        wordSplit = new ArrayList<>();
        definitionSplit = new ArrayList<>();

        dictionary = new File("src/main/java/runge/dictionary/dictionary.txt");
        bufferedReader = new BufferedReader(new FileReader(dictionary));
        //keep the dictionary open
        //aka get all the objects that are being called to getDefinition of and then find them all at once
        if (dictionary.exists())
        {
            for (int i = 167964; i > 0; i--)
            {
                String line = bufferedReader.readLine();
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
            }
        }
    }

    public String getDefinition(String word)
    {
        String definition = null;
        for (int i = 0; i < wordSplit.size(); i++)
        {
            if (word.equals(wordSplit.get(i)))
            {
                definition = definitionSplit.get(i);
                break;
            }
        }
        return definition;
    }

    public ArrayList<String> getList()
    {
        return wordSplit;
    }
}
