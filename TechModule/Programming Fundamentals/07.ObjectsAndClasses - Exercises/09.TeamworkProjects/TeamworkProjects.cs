using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _09.TeamworkProjects
{
    public class TeamworkProjects
    {
        public static void Main()
        {
            var teams = new List<Team>();
            var members = new List<User>();
            int n = int.Parse(Console.ReadLine());
            for (int i = 0; i < n; i++)
            {
                var input = Console.ReadLine().Split('-');
                var name = input[0];
                var teamName = input[1];

                if (teams.Any(t => t.Name == teamName))
                {
                    Console.WriteLine($"Team {teamName} was already created!");
                    continue;
                }
                if (members.Any(u => u.Name == name))
                {
                    Console.WriteLine($"{name} cannot create another team!");
                    continue;
                }

                Team team = new Team(teamName);
                teams.Add(team);
                User user = new User(name, team);
                members.Add(user);
                team.Creator = name;

                Console.WriteLine($"Team {team.Name} has been created by {user.Name}!");
            }

            var assingment = Console.ReadLine();
            while (assingment != "end of assignment")
            {
                var assignArgs = assingment.Split(new char[] { '-', '>' }, StringSplitOptions.RemoveEmptyEntries);
                var name = assignArgs[0];
                var teamName = assignArgs[1];
                if (!teams.Any(t => t.Name == teamName))
                {
                    Console.WriteLine($"Team {teamName} does not exist!");
                    assingment = Console.ReadLine();
                    continue;
                }
                if (members.Any(m => m.Name == name))
                {
                    Console.WriteLine($"Member {name} cannot join team {teamName}!");
                    assingment = Console.ReadLine();
                    continue;
                }

                Team team = teams.Single(t => t.Name == teamName);
                User user = new User(name, team);
                members.Add(user);
                team.Members.Add(user);

                assingment = Console.ReadLine();
            }

            teams = teams.OrderByDescending(t => t.Members.Count).ThenBy(t => t.Name).ToList();
            var teamsToDisband = new List<Team>();
            foreach (var team in teams)
            {
                if (team.Members.Count == 0)
                {
                    teamsToDisband.Add(team);
                    continue;
                }

                Console.WriteLine($"{team.Name}");
                Console.WriteLine($"- {team.Creator}");
                team.Members = team.Members.OrderBy(m => m.Name).ToList();
                foreach (var member in team.Members)
                {
                    Console.WriteLine($"-- {member.Name}");
                }
            }

            teamsToDisband = teamsToDisband.OrderBy(t => t.Name).ToList();
            Console.WriteLine("Teams to disband:");
            foreach (var team in teamsToDisband)
            {
                Console.WriteLine(team.Name);
            }
        }
    }
}
