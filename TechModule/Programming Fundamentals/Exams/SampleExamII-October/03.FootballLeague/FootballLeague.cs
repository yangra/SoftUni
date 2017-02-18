using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.FootballLeague
{
    public class FootballLeague
    {
        public static void Main()
        {

            var standings = new Dictionary<string, int>();
            var goals = new Dictionary<string, int>();
            var key = Console.ReadLine();
            var input = Console.ReadLine();
            while (input != "final")
            {
                var args = input.Split();
                var teamA = Decrypt(args[0], key);
                var teamB = Decrypt(args[1], key);
                var scores = args[2].Split(':');
                var teamAScore = int.Parse(scores[0]);
                var teamBScore = int.Parse(scores[1]);

                CheckIfTeamExists(teamA, standings);
                CheckIfTeamExists(teamB, standings);

                if (teamAScore > teamBScore)
                {
                    standings[teamA] += 3;
                }
                else if (teamBScore > teamAScore)
                {
                    standings[teamB] += 3;
                }
                else
                {
                    standings[teamA] += 1;
                    standings[teamB] += 1;
                }

                CheckIfTeamExists(teamA, goals);
                CheckIfTeamExists(teamB, goals);

                goals[teamA] += teamAScore;
                goals[teamB] += teamBScore;

                input = Console.ReadLine();
            }

            var resultStandings = standings.OrderByDescending(t => t.Value).ThenBy(t=>t.Key);
            var resultGoals = goals.OrderByDescending(t => t.Value).ThenBy(t=>t.Key).Take(3);

            var number = 1;
            Console.WriteLine("League standings:");
            foreach (var team in resultStandings)
            {
                Console.WriteLine("{0}. {1} {2}", number, team.Key, team.Value);
                number++;
            }

            Console.WriteLine("Top 3 scored goals:");
            foreach (var team in resultGoals)
            {
                Console.WriteLine("- {0} -> {1}", team.Key, team.Value);
            }
        }

        public static void CheckIfTeamExists(string team,Dictionary<string,int> dict)
        {
            if (!dict.ContainsKey(team))
            {
                dict[team] = 0;
            }
        }

        public static string Decrypt(string encrypted,string key)
        {
            var index = 0;
            var firstIndex = encrypted.IndexOf(key, index);
            var secondIndex = encrypted.IndexOf(key, firstIndex + 1);
            var sub = encrypted.Substring(firstIndex, secondIndex - firstIndex);
            var reversed = sub.Replace(key, "").ToUpper();
            var sb = new StringBuilder();
            for (int i = reversed.Length-1; i >= 0; i--)
            {
                sb.Append(reversed[i]);
            }

            return sb.ToString();
        }
    }
}
