using System;
using System.Collections.Generic;

class SplitByWordCasing
{
    static void Main(string[] args)
    {
        char[] ArgumentsDelimiters = { ',', ';', ':', '.', '!', '(', ')', '"', '\'', '/', '\\', '[', ']', ' ' };

        string[] text = Console.ReadLine().Split(ArgumentsDelimiters, StringSplitOptions.RemoveEmptyEntries);
        List<string> upperCase = new List<string>();
        List<string> lowerCase = new List<string>();
        List<string> mixedCase = new List<string>();

        foreach (var word in text)
        {
            int upperCount = 0;
            int lowerCount = 0;
            for (int i = 0; i < word.Length; i++)
            {
                if (word[i] >= 'a' && word[i] <= 'z')
                {
                    lowerCount++;
                }
                if (word[i] >= 'A' && word[i] <= 'Z')
                {
                    upperCount++;
                }
            }

            if (upperCount == word.Length)
            {
                upperCase.Add(word);
            }
            else if (lowerCount == word.Length)
            {
                lowerCase.Add(word);
            }
            else
            {
                mixedCase.Add(word);
            }
        }

        Console.WriteLine("Lower-case: {0}", string.Join(", ", lowerCase));
        Console.WriteLine("Mixed-case: {0}", string.Join(", ", mixedCase));
        Console.WriteLine("Upper-case: {0}", string.Join(", ", upperCase));
    }
}

