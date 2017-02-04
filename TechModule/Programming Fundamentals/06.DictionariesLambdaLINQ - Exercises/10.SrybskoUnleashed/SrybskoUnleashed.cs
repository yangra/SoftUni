using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace _10.SrybskoUnleashed
{
    public class SrybskoUnleashed
    {
        public static void Main(string[] args)
        {
            var venues = new Dictionary<string, Dictionary<string, long>>();
            string input = Console.ReadLine();
            while (input != "End")
            {
                string inputPattern = @"([a-zA-Z]+\s){1,3}@([a-zA-z]+\s){1,3}(\d+\s)(\d+)";
                Match result = Regex.Match(input, inputPattern);
                if (result.Success)
                {
                    var splittedSinger = input.Split('@');
                    string singer = splittedSinger[0].Trim();
                    string[] venueNumbers = splittedSinger[1].Split(' ');
                    long ticketsCount = long.Parse(venueNumbers[venueNumbers.Length - 1]);
                    long ticketsPrice = long.Parse(venueNumbers[venueNumbers.Length - 2]);
                    long total = ticketsCount * ticketsPrice;
                    string venue = string.Empty;
                    for (int i = 0; i < venueNumbers.Length - 2; i++)
                    {
                        venue += venueNumbers[i];
                        if (i != venueNumbers.Length - 3)
                        {
                            venue += " ";
                        }
                    }

                    if (!venues.ContainsKey(venue))
                    {
                        venues[venue] = new Dictionary<string, long>();
                    }

                    if (!venues[venue].ContainsKey(singer))
                    {
                        venues[venue][singer] = 0;
                    }

                    venues[venue][singer] += total;
                }

                input = Console.ReadLine(); 
            }

            foreach (var venue in venues)
            {
                Console.WriteLine($"{venue.Key}");
                var singers = venue.Value;
                singers = singers.OrderByDescending(x => x.Value).ToDictionary(x => x.Key, x => x.Value);
                foreach (var singer in singers)
                {
                    Console.WriteLine($"#  {singer.Key} -> {singer.Value}");
                }
            }
        }
    }
}
