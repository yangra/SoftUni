using System;

public class Substring_broken
{
    public static void Main()
    {
        const char Search = 'p';

        string text = Console.ReadLine();
        int jump = int.Parse(Console.ReadLine());

        bool hasMatch = false;

        for (int i = 0; i < text.Length; i++)
        {
            if (text[i] == Search)
            {
                hasMatch = true;

                int endIndex = i + jump;
                string matchedString = "";

                if (endIndex >= text.Length)
                {
                    endIndex = text.Length - 1;
                    matchedString = text.Substring(i);
                }
                else
                {
                    matchedString = text.Substring(i, jump + 1);
                }

                Console.WriteLine(matchedString);
                i = endIndex;
            }
        }

        if (!hasMatch)
        {
            Console.WriteLine("no");
        }
    }
}
