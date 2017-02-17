using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.Palindromes
{
    public class Palindromes
    {
        public static void Main()
        {
            var text = Console.ReadLine().Split(new char[] { ' ', ',', '.', '?', '!' }, StringSplitOptions.RemoveEmptyEntries);

            var result = new List<string>();
            foreach (var word in text)
            {
                if (word.Length == 1)
                {
                    result.Add(word);
                    continue;
                }

                var halfWord = word.Substring(0,word.Length/2);

                var reversed = string.Empty;
                for (int i = halfWord.Length - 1; i >= 0; i--)
                {
                    reversed = string.Concat(reversed, halfWord[i]);
                }

                var found = word.IndexOf(reversed, reversed.Length);
                if (found > 0)
                {
                    result.Add(word);
                }
            }

            result.Sort();
            for (int i = 0; i < result.Count-1; i++)
            {
                if (result[i] == result[i+1])
                {
                    result.RemoveAt(i);
                    i--;
                }
            }

            Console.WriteLine(string.Join(", ", result));
        }
    }
}
