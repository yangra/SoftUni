using System;
using System.Text;
using System.Text.RegularExpressions;


namespace _04.CubicMessages
{
    public class Program
    {
        public static void Main()
        {
            var input = Console.ReadLine();
            while (input != "Over!")
            {
                var n = int.Parse(Console.ReadLine());
                var regex = new Regex($@"^[0-9]+([a-zA-Z]{{{n}}})([^a-zA-Z]*)$");

                if (regex.IsMatch(input))
                {
                    Match match = regex.Match(input);
                    var message = match.Groups[1].ToString();

                    Console.Write("{0} == ", message);

                    var digreg = new Regex(@"\d");
                    var verCode = new StringBuilder();
                    MatchCollection verification = digreg.Matches(input);
                    foreach (Match m in verification)
                    {
                        var digit = int.Parse(m.ToString());
                        
                        if (digit >= 0 && digit < n)
                        {
                            verCode.Append(message[digit]);
                        }
                        else
                        {
                            verCode.Append(" ");
                        }
                    }
                    Console.WriteLine(verCode.ToString());
                }

                input = Console.ReadLine();
            }
        }
    }
}
