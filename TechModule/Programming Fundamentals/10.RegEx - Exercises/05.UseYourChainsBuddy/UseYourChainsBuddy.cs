using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _05.UseYourChainsBuddy
{
    public class UseYourChainsBuddy
    {
        public static void Main()
        {
            var input = Console.ReadLine();
            var paragraphs = new List<string>();

            var regex = new Regex(@"<p>(.+?)<\/p>");
            MatchCollection matches = regex.Matches(input);
            foreach (Match match in matches)
            {
                paragraphs.Add(match.Groups[1].ToString());
            }

            var reg = new Regex(@"[^a-z0-9]");
            for (int i = 0; i < paragraphs.Count; i++)
            {
                paragraphs[i] = reg.Replace(paragraphs[i], " ");
                var par = paragraphs[i].ToCharArray();
                for (int j = 0; j < par.Length; j++)
                {
                    if (Char.IsLetter(par[j])&&par[j]>'m')
                    {
                        par[j] = (char)(par[j] - 13);
                    }
                    else if (Char.IsLetter(par[j]) && par[j] <= 'm')
                    {
                        par[j] = (char)(par[j] + 13);
                    }
                }
                paragraphs[i] = new string(par);
            }

            var multsp = new Regex(@"\s+");
            for (int i = 0; i < paragraphs.Count; i++)
            {
                paragraphs[i] = multsp.Replace(paragraphs[i], " ");
            }

            Console.WriteLine(string.Join("", paragraphs));
        }
    }
}
