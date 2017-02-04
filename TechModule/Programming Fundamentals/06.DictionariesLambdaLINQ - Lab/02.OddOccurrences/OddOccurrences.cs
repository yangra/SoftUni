using System;
using System.Collections.Generic;
using System.Linq;

namespace _02.OddOccurrences
{
    class OddOccurrences
    {
        static void Main(string[] args)
        {
            string[] words = Console.ReadLine().ToLower().Split(' ');
            Dictionary<string, int> wordCounts = new Dictionary<string, int>();
            for (int i = 0; i < words.Length; i++)
            {
                string word = words[i];
                if (!wordCounts.ContainsKey(word))
                {
                    wordCounts[word] = 0;
                    
                }
                
                wordCounts[word]++;
            }
            //var result = from x in wordCounts where x.Value % 2 != 0 select x.Key;
            var result = new List<string>();
            foreach (var pair in wordCounts)
            {
                if (pair.Value%2!=0)
                {
                    result.Add(pair.Key);
                }
            }
           
            Console.WriteLine(string.Join(", ", result));
        }
    }
}
