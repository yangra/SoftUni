using System;
using System.Text.RegularExpressions;

namespace _01.ExtractEmails
{
    public class ExtractEmails
    {
        public static void Main()
        {
            var input = Console.ReadLine();
            //var regex = new Regex(@"[a-zA-Z0-9]+[a-zA-Z0-9_\.-]+?@([a-zA-Z]+[a-zA-Z-]+?\.)+[a-zA-Z]+");
            var regex = new Regex(@"\b(?<!\.|\-|_)[a-zA-Z0-9]+[\w\.-]+?@([a-zA-Z]+[a-zA-Z-]+?\.)+[a-zA-Z]+\b");
            MatchCollection emails = regex.Matches(input);
            foreach (var email in emails)
            {
                Console.WriteLine(email.ToString());
            }
        }
    }
}
