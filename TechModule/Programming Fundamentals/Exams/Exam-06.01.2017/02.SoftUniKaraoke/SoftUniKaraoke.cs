using System;
using System.Collections.Generic;
using System.Linq;

namespace _02.SoftUniKaraoke
{
    public class SoftUniKaraoke
    {
        public static void Main()
        {
            var participants = Console.ReadLine().Split(new char[] { ',' }, StringSplitOptions.RemoveEmptyEntries);
            for (int i = 0; i < participants.Length; i++)
            {
                participants[i] = participants[i].Trim();
            }

            var songs = Console.ReadLine().Split(new char[] { ',' }, StringSplitOptions.RemoveEmptyEntries);
            for (int i = 0; i < songs.Length; i++)
            {
                songs[i] = songs[i].Trim();
            }

            var awards = new Dictionary<string, List<string>>();

            var participation = Console.ReadLine();
            while (!participation.Equals("dawn"))
            {
                var parts = participation.Split(new char[] { ',' }, StringSplitOptions.RemoveEmptyEntries);

                var singer = parts[0].Trim();
                var song = parts[1].Trim();
                var award = parts[2].Trim();
                if (singer.Length > 0 && song.Length > 0 && participants.Contains(singer) && songs.Contains(song))
                {
                    if (!awards.ContainsKey(singer))
                    {
                        awards[singer] = new List<string>();
                    }

                    if (!awards[singer].Contains(award))
                    {
                        awards[singer].Add(award);
                    }
                }

                participation = Console.ReadLine();
            }

            awards = awards
                .OrderByDescending(p => p.Value.Count)
                .ThenBy(p => p.Key)
                .ToDictionary(p => p.Key, 
                              p => p.Value.OrderBy(a => a).ToList());

            if (awards.Keys.Count > 0)
            {
                foreach (var participant in awards)
                {
                    Console.WriteLine("{0}: {1} awards", participant.Key, participant.Value.Count);
                    foreach (var award in participant.Value)
                    {
                        Console.WriteLine("--{0}", award);
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
