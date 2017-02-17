using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _09.HarlemShake
{
    public class HarlemShake
    {
        public static void Main(string[] args)
        {
            var input = Console.ReadLine();
            var pattern = Console.ReadLine();
            var count = 0;
            
            if (pattern.Length > 0)
            {
                count = CountMatches(input, pattern);
            }

            while (pattern.Length > 0 && count >= 2)
            {
                var indexFirstMatch = input.IndexOf(pattern);
                var indexLastMatch = input.LastIndexOf(pattern);
                input = input.Remove(indexLastMatch, pattern.Length).Remove(indexFirstMatch, pattern.Length);

                Console.WriteLine("Shaked it.");

                pattern = pattern.Remove(pattern.Length / 2, 1);
                if (pattern.Length == 0)
                {
                    break;
                }
                count = CountMatches(input, pattern);
            }
            
            Console.WriteLine("No shake.");
            Console.WriteLine(input);

        }

        public static int CountMatches(string input, string pattern)
        {
            var count = 0;
            int index = input.IndexOf(pattern);
            while (index != -1)
            {
                count++;
                index = input.IndexOf(pattern, index + 1);
            }

            return count;
        }
    }
}
