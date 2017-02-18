using System;
using System.Collections.Generic;
using System.Text;
using System.Text.RegularExpressions;
using System.Linq;

namespace _03.RageQuit
{
    public class Pair
    {
        public string Word { get; set; }
        public int Count { get; set; }
    }
    public class RageQuit
    {

        public static void Main()
        {
            var input = Console.ReadLine().ToUpper();
            var words = new List<Pair>();
            //var symbols = new Dictionary<char, int>();
            StringBuilder message = new StringBuilder();
            var pattern = @"([\D]+)(\d+)";
            MatchCollection pairs = Regex.Matches(input, pattern);
            foreach (Match match in pairs)
            {
                var word = match.Groups[1].Value;
                var count = int.Parse(match.Groups[2].Value);
                var pair = new Pair
                {
                    Word = word,
                    Count = count
                };
                words.Add(pair);
                //foreach (var letter in word)
                //{
                //    if (!symbols.ContainsKey(letter))
                //    {
                //        symbols[letter] = 1;
                //    }
                //}
            }
            
            foreach (var word in words)
            {
                for (int i = 0; i < word.Count; i++)
                {
                   message.Append(word.Word);
                }

            }
            string output = message.ToString();
            var symbolCount = output.Distinct().Count();
            Console.WriteLine("Unique symbols used: {0}", symbols.Keys.Count);
            Console.WriteLine(message);
        }
    }
}
