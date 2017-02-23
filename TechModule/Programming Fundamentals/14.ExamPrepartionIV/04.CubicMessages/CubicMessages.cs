using System;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

namespace _04.CubicMessages
{
    class CubicMessages
    {
        static void Main()
        {
            var line = Console.ReadLine();
            while (!line.Equals("Over!"))
            {
                var count = int.Parse(Console.ReadLine());
                var regex = new Regex($@"^(\d+?)([a-zA-Z]{{{count}}})([^a-zA-Z]*)$");
                
                if (regex.IsMatch(line))
                {
                    var match = regex.Match(line);
                    var left = match.Groups[1].Value;
                    var message = match.Groups[2].Value;
                    var right = match.Groups[3].Value;
                    var verificationCode = new StringBuilder();
                    var indexes = string.Concat(left, right)
                                .Where(i=>char.IsDigit(i)==true)
                                .Select(i=>i-'0')
                                .ToArray();

                    foreach (var index in indexes)
                    {
                        if (index<0||index>=message.Length)
                        {
                            verificationCode.Append(' ');
                        }
                        else
                        {
                            verificationCode.Append(message[index]);
                        }
                    }
                    Console.WriteLine($"{message} == {verificationCode.ToString()}");
                }

                line = Console.ReadLine();
            }
        }
    }
}
