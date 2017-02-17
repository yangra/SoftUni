using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _02.ExtractSentences
{
    public class ExtractSentences
    {
        public static void Main()
        {
            var word = Console.ReadLine();
            var sentences = Console.ReadLine().Split(new char[] {'.','?', '!' }, StringSplitOptions.RemoveEmptyEntries);

            //var regex = new Regex(@"([\w-,;:]+)([^a-zA-Z][\w-,;:]+)+(?=[\.|!|\?])");
            //MatchCollection sentences = regex.Matches(text);

            foreach (var sentence in sentences)
            {
                var wordReg = new Regex($@"[^a-zA-Z]{word}[^a-zA-Z]");
                if (wordReg.IsMatch(sentence.ToString()))
                {
                    Console.WriteLine(sentence.ToString());
                }
            }
        }
    }
}
