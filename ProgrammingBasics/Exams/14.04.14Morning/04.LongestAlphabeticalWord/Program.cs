using System;
using System.Collections.Generic;


namespace _04.LongestAlphabeticalWord
{
    class Program
    {
        static void Main(string[] args)
        {
            string w = Console.ReadLine();
            int n = int.Parse(Console.ReadLine());

            string longestAlphaWord = "";
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    string strLeft = GetAlphaWord(w, n, i, j, -1, 0);
                    longestAlphaWord = GetBetterWord(longestAlphaWord, strLeft);
                    string strRight = GetAlphaWord(w, n, i, j, 1, 0);
                    longestAlphaWord = GetBetterWord(longestAlphaWord, strRight);
                    string strUp = GetAlphaWord(w, n, i, j, 0, -1);
                    longestAlphaWord = GetBetterWord(longestAlphaWord, strUp);
                    string strDown = GetAlphaWord(w, n, i, j, 0, 1);
                    longestAlphaWord = GetBetterWord(longestAlphaWord, strDown);
                }
            }

            Console.WriteLine(longestAlphaWord);

        }

        static string GetAlphaWord(string word, int n, int row, int col, int directionX, int directionY)
        {
            List<char> letters = new List<char>();
            char prevLetter = GetLetterAtPosition(row, col, n, word);
            letters.Add(prevLetter);
            while (true)
            {
                row += directionX;
                col += directionY;
                if (row < 0 || row >= n || col < 0 || col >= n)
                {
                    break;
                }
                char nextLetter = GetLetterAtPosition(row, col, n, word);
                if (nextLetter <= prevLetter)
                {
                    break;
                }
                letters.Add(nextLetter);
                prevLetter = nextLetter;
            }
            string alphaWord = new string(letters.ToArray());
            return alphaWord;
        }

        static string GetBetterWord(string word1, string word2)
        {
            if (word1.Length > word2.Length || (word1.Length == word2.Length && word1.CompareTo(word2) < 0))
            {
                return word1;
            }

            return word2;
        }

        static char GetLetterAtPosition(int row, int col, int n, string word)
        {
            int index = ((row * n + col) % word.Length);
            return word[index];
        }
    }
}
