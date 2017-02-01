using System;

class IndexOfLetters
{
    static void Main()
    {
        char[] alphabet = new char[26];

        for (int i = 0; i < alphabet.Length; i++)
        {
            alphabet[i] = (char)('a' + i);
        }

        string word = Console.ReadLine();

        for (int i = 0; i < word.Length; i++)
        {
            int index = 0;
            for (int j = 0; j < alphabet.Length; j++)
            {
                if (word[i] == alphabet[j])
                {
                    index = j;
                }
            }

            Console.WriteLine($"{word[i]} -> {index}");
        }

    }
}

