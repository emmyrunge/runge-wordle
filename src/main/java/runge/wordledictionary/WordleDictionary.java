package runge.wordledictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class WordleDictionary
{
    private HashMap<String, String> map;

    public WordleDictionary() throws IOException
    {
        map = new HashMap<>();

        File dictionary = new File("src/main/java/runge/wordledictionary/dictionary.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(dictionary));
        String line = bufferedReader.readLine();

        while (line != null)
        {
            String[] splitLine = line.split(" ", 2);
            String wordSplit = splitLine[0];
            if (splitLine.length == 1)
            {
                map.put(wordSplit, "");
            }
            else
            {
                String definitionSplit = splitLine[1];
                map.put(wordSplit, definitionSplit);
            }
            line = bufferedReader.readLine();

        }
    }

    public String getDefinition(String word)
    {
        return map.get(word);
    }

    public Set<String> getList()
    {
        return map.keySet();
    }
}
