using System;
using System.Collections.Generic;
using System.Linq;

namespace _03.FootballLeague
{
    public class FootballLeague
    {
        public static void Main()
        {
            var key = Console.ReadLine();

            var standings = new SortedDictionary<string, int>();
            var goals = new SortedDictionary<string, int>();

            var input = Console.ReadLine();
            while (input != "final")
            {
                var inputArgs = input.Split(' ');
                var firstTeam = GetValue(inputArgs[0], key);
                var secondTeam = GetValue(inputArgs[1], key);
                var scores = inputArgs[2].Split(':');
                var firstTeamScore = int.Parse(scores[0]);
                var secondTeamScore = int.Parse(scores[1]);

                AddToStandings(standings, firstTeam, firstTeamScore, secondTeamScore);
                AddToStandings(standings, secondTeam, secondTeamScore, firstTeamScore);
                AddGoals(goals, firstTeam, firstTeamScore);
                AddGoals(goals, secondTeam, secondTeamScore);

                input = Console.ReadLine();
            }

            var finalStandings = standings.OrderByDescending(p => p.Value);

            var count = 1;
            Console.WriteLine("League standings:");
            foreach (var team in finalStandings)
            {
                Console.WriteLine($"{count}. {team.Key} {team.Value}");
                count++;
            }

            var topThree = goals.OrderByDescending(p => p.Value).Take(3);

            Console.WriteLine("Top 3 scored goals:");
            foreach (var team in topThree)
            {
                Console.WriteLine($"- {team.Key} -> {team.Value}");
            }
        }

        private static void AddGoals(SortedDictionary<string, int> goals, string team, int score)
        {
            if (!goals.ContainsKey(team))
            {
                goals[team] = 0;
            }

            goals[team] += score;
        }

        private static void AddToStandings(SortedDictionary<string, int> standings, string team, int teamScore, int opponentScore)
        {
            if (!standings.ContainsKey(team))
            {
                standings[team] = 0;
            }

            if (teamScore > opponentScore)
            {
                standings[team] += 3;
            }
            else if (teamScore == opponentScore)
            {
                standings[team] += 1;
            }
        }

        private static string GetValue(string encrypted, string key)
        {
            var encReplace = encrypted.Replace(key, " ");
            var encArgs = encReplace.Split(' ');

            char[] charArray = encArgs[1].ToCharArray();
            Array.Reverse(charArray);
            return new string(charArray).ToUpper();
        }
    }
}
