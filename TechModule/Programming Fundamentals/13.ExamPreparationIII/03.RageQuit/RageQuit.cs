using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

namespace _03.RageQuit
{
    class RageQuit
    {
        static void Main(string[] args)
        {
            var input = Console.ReadLine().ToUpper();
            var finalText = new StringBuilder();
            var uniqueChars = new List<char>();
            var regex = new Regex(@"(\D+)(\d+)");
            var matches = regex.Matches(input);
            foreach (Match match in matches)
            {
                var word = match.Groups[1].Value;
                var times = int.Parse(match.Groups[2].Value);

                for (int i = 0; i < times; i++)
                {
                    finalText.Append(word);
                }
                if (times>0)
                {
                    uniqueChars.InsertRange(uniqueChars.Count, word);
                }
            }
            var uniqueSym = uniqueChars.Distinct().Count();
            Console.WriteLine("Unique symbols used: {0}", uniqueSym);
            Console.WriteLine(finalText.ToString());
        }
    }
}
