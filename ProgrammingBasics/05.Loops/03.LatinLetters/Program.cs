using System;

namespace _03.LatinLetters
{
    class Program
    {
        static void Main(string[] args)
        {
            char letter = 'a';
            for (int i = 0; i < 26; i++)
            {
                Console.WriteLine(letter++);
            }
        }
    }
}
