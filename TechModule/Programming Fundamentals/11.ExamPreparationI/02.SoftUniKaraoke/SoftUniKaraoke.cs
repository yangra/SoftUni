using System;
using System.Collections.Generic;
using System.Linq;

namespace _02.SoftUniKaraoke
{
    public class SoftUniKaraoke
    {
        public static void Main()
        {
            var participants = Console.ReadLine().Split(new char[] { ',' }, StringSplitOptions.RemoveEmptyEntries).Select(p => p.Trim()).ToArray();
            var songs = Console.ReadLine().Split(new char[] { ',' }, StringSplitOptions.RemoveEmptyEntries).Select(s => s.Trim()).ToArray();
            var awards = new Dictionary<string, List<string>>();
            var line = Console.ReadLine();
            while (!line.Equals("dawn"))
            {
                var performance = line.Split(new char[] { ',' }, StringSplitOptions.RemoveEmptyEntries).Select(p => p.Trim()).ToArray();
                var participant = performance[0];
                var song = performance[1];
                var award = performance[2];

                if (participants.Contains(participant) && songs.Contains(song))
                {
                    if (!awards.ContainsKey(participant))
                    {
                        awards[participant] = new List<string>();
                    }

                    if (!awards[participant].Contains(award))
                    {
                        awards[participant].Add(award);
                    }
                }

                line = Console.ReadLine();
            }

            if (awards.Count > 0)
            {
                foreach (var participant in awards.OrderByDescending(p => p.Value.Count).ThenBy(p => p.Key))
                {
                    Console.WriteLine($"{participant.Key}: {participant.Value.Count} awards");
                    foreach (var award in participant.Value.OrderBy(a => a))
                    {
                        Console.WriteLine($"--{award}");
                    }
                }
            }
            else
            {
                Console.WriteLine("No awards");
            }
        }
    }
}
