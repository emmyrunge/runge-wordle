import java.io.*;
import java.util.*;

public class WordleDictionary
{
    private static String definitions;
    private static String words;
    private static File dictionary;

    private static BufferedReader bufferedReader;

    public static File getDictionary()
    {
        return dictionary;
    }

    public WordleDictionary() throws IOException
    {
        dictionary = new File("src/main/java/runge/dictionary/dictionary.txt");
        bufferedReader = new BufferedReader(new FileReader(dictionary));
    }

    //should only return the definition of the word
    public String getDefinition(String word) throws IOException
    {
        String definition = null;

        if (dictionary.exists())
        {
            for(int i = 0; i < dictionary.length(); i++)
            {
                String line = bufferedReader.readLine();
                String[] splitLine = line.split(" ", 2);
                words = splitLine[0].trim();
                definitions = splitLine[1].trim();

                if (words.equals(word))
                {
                    definition = definitions;
                    break;
                }
            }

        }
        return definition; //return definition
    }

    //should return the entire list of words
    public ArrayList<String> getList() throws IOException
    {
        ArrayList<String> words = new ArrayList<>();
        String line = bufferedReader.readLine();
        while (line != null)
        {
            words.add(line);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        return words;
    }
}
