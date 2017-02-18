using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.GameOfNames
{
    public class GameOfNames
    {
        public static void Main(string[] args)
        {
            int count = int.Parse(Console.ReadLine());
            var scores = new Dictionary<string, int>();
            for (int i = 0; i < count; i++)
            {
                var name = Console.ReadLine();
                var iniScore = int.Parse(Console.ReadLine());
                for (int j = 0; j < name.Length; j++)
                {
                    if (name[j]%2==0)
                    {
                        iniScore += name[j];
                    }
                    else
                    {
                        iniScore -= name[j];
                    }
                }

                scores[name] = iniScore;
            }

            var maxScore = scores.Max(s => s.Value);

            foreach (var player in scores)
            {
                if (player.Value == maxScore)
                {
                    Console.WriteLine("The winner is {0} - {1} points", player.Key, player.Value);
                    break;
                }
            }
        }
    }
}
