using System;
using System.Linq;
using System.Text.RegularExpressions;


namespace _04.WinningTicket
{
    public class WinningTicket
    {
        public static void Main()
        {
            var tickets = Console.ReadLine()
                .Split(new char[] { ',' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(t => t.Trim())
                .ToArray();

            foreach (var ticket in tickets)
            {
                if (ticket.Length == 20)
                {
                    var winning = new Regex(@"(@|#|\$|\^)\1{5,9}");
                    var leftHalf = ticket.Substring(0, 10);
                    var rightHalf = ticket.Substring(10);
                    Match matchR = winning.Match(rightHalf);
                    Match matchL = winning.Match(leftHalf);
                    if (matchL.Success && matchR.Success && 
                        matchL.Groups[1].ToString().Equals(matchR.Groups[1].ToString()))
                    {
                        var matchLength = Math.Min(matchL.Length, matchR.Length);
                        var jackpot = matchLength == 10 ? "Jackpot!" : String.Empty;

                        Console.WriteLine($"ticket \"{ticket}\" - {matchLength}{matchL.Groups[1]} {jackpot}");
                    }
                    else
                    {
                        Console.WriteLine($"ticket \"{ticket}\" - no match");
                    }
                }
                else
                {
                    Console.WriteLine("invalid ticket");
                }
            }
        }
    }
}
