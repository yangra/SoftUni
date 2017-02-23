using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace _03.FootballLeague
{
    class FootballLeague
    {
        static void Main(string[] args)
        {
            var key = Console.ReadLine();

            var standings = new Dictionary<string, long>();
            var goals = new Dictionary<string, long>();
            var escapedKey = Regex.Escape(key);
            var regex = new Regex($@"{escapedKey}(.*?){escapedKey}.*?{escapedKey}(.*?){escapedKey}.*?(\d+):(\d+)");
            
            var line = Console.ReadLine();
            while(!line.Equals("final"))
            {
                var match = regex.Match(line);
                var teamA =new string( match.Groups[1].Value.Reverse().ToArray()).ToUpper();
                var teamB = new string(match.Groups[2].Value.Reverse().ToArray()).ToUpper();
                var teamAGoals = int.Parse(match.Groups[3].Value);
                var teamBGoals = int.Parse(match.Groups[4].Value);

                if (!standings.ContainsKey(teamA))
                {
                    standings[teamA] = 0;
                }

                if (!standings.ContainsKey(teamB))
                {
                    standings[teamB] = 0;
                }
                if (!goals.ContainsKey(teamA))
                {
                    goals[teamA] = 0;
                }

                if (!goals.ContainsKey(teamB))
                {
                    goals[teamB] = 0;
                }

                goals[teamA] += teamAGoals;
                goals[teamB] += teamBGoals;

                if (teamAGoals>teamBGoals)
                {
                    standings[teamA] += 3;
                }
                else if (teamBGoals>teamAGoals)
                {
                    standings[teamB] += 3;
                }
                else
                {
                    standings[teamA]++;
                    standings[teamB]++;
                }

                line = Console.ReadLine();
            }
            Console.WriteLine("League standings:");
            int number = 1;
            foreach (var team in standings
                                .OrderByDescending(t=>t.Value)
                                .ThenBy(t=>t.Key))
            {
                Console.WriteLine($"{number}. {team.Key} {team.Value}");
                number++;
            }
            Console.WriteLine("Top 3 scored goals:");
            foreach (var team in goals
                                .OrderByDescending(t=>t.Value)
                                .ThenBy(t=>t.Key)
                                .Take(3))
            {
                Console.WriteLine($" - {team.Key} -> {team.Value}");
            }
        }
    }
}
