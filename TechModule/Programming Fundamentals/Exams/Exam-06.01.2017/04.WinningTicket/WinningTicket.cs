using System;
using System.Text.RegularExpressions;

namespace _04.WinningTicket
{
    public class WinningTicket
    {
        public static void Main()
        {
            var tickets = Console.ReadLine().Split(new char[] { ',' }, StringSplitOptions.RemoveEmptyEntries);

            var jackpot = new Regex(@"(@|\^|\$|#)\1{19}");
            var winning = new Regex(@"(@|\^|\$|#)\1{5,8}");

            for (int i = 0; i < tickets.Length; i++)
            {
                var ticket = tickets[i].Trim();
                if (ticket.Length == 20)
                {
                    var ticketLeftHalf = ticket.Substring(0, 10);
                    var ticketRightHalf = ticket.Substring(10);

                    if (jackpot.IsMatch(ticket))
                    {
                        Console.WriteLine("ticket \"{0}\" - 10{1} Jackpot!",
                            ticket,
                            jackpot.Match(ticket).Groups[1].ToString());
                    }
                    else if (winning.IsMatch(ticketLeftHalf) && winning.IsMatch(ticketRightHalf) &&
                             winning.Match(ticketLeftHalf).Groups[1].ToString().Equals(winning.Match(ticketRightHalf).Groups[1].ToString()))
                    {
                        Console.WriteLine("ticket \"{0}\" - {1}{2}",
                            ticket,
                            Math.Min(winning.Match(ticketLeftHalf).Length, winning.Match(ticketRightHalf).Length),
                            winning.Match(ticketLeftHalf).Groups[1].ToString());
                    }
                    else
                    {
                        Console.WriteLine("ticket \"{0}\" - no match", ticket);
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
