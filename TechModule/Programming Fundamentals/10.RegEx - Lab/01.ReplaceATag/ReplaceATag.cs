using System;
using System.Text;
using System.Text.RegularExpressions;

namespace _01.ReplaceATag
{
    public class ReplaceATag
    {
        public static void Main(string[] args)
        {
            var original = Console.ReadLine();
            var result = new StringBuilder();
            while (original != "end")
            {
                var regex = new Regex(@"<a.*?href=(.*?)>(.*?)<\/a>");

                var replacement = @"[URL href=$1]$2[/URL]";
                result.Append(regex.Replace(original, replacement)+"\r\n");

                original = Console.ReadLine();
            }
            Console.WriteLine(result);
        }

    }
}
