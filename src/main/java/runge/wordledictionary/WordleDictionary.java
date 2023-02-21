package runge.wordledictionary;

import java.io.*;
import java.util.*;

public class WordleDictionary
{
    protected ArrayList<String> definitionSplit;
    protected ArrayList<String> wordSplit;


    public WordleDictionary() throws IOException
    {
        wordSplit = new ArrayList<>();
        definitionSplit = new ArrayList<>();

        File dictionary = new File("src/main/java/runge/wordledictionary/dictionary.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(dictionary));
        String line = bufferedReader.readLine();

        while (line != null)
        {
            String[] splitLine = line.split(" ", 2);
            if (splitLine.length == 1)
            {
                wordSplit.add(splitLine[0]);
                definitionSplit.add("");
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
        int index = wordSplit.indexOf(word.toUpperCase());
        if(index == -1)
        {
            return null;
        }
        return definitionSplit.get(index);
    }

    public ArrayList<String> getList()
    {
        return wordSplit;
    }
}
