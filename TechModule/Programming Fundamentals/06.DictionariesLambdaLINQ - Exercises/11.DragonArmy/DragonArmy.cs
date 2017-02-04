using System;
using System.Collections.Generic;
using System.Linq;

namespace _11.DragonArmy
{
    public class DragonArmy
    {
        public static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            var dragons = new Dictionary<string, SortedDictionary<string, int[]>>();
            for (int i = 0; i < n; i++)
            {
                string[] input = Console.ReadLine().Split(' ');
                string type = input[0];
                string name = input[1];
                int dmg = 0;
                if (!int.TryParse(input[2], out dmg))
                {
                    dmg = 45;
                }
                
                int health = 0;
                if (!int.TryParse(input[3], out health))
                {
                    health = 250;
                }

                int armor = 0;
                if (!int.TryParse(input[4], out armor))
                {
                    armor = 10;
                }
                
                int[] stats = new int[3];
                stats[0] = dmg;
                stats[1] = health;
                stats[2] = armor;

                if (!dragons.ContainsKey(type))
                {
                    dragons[type] = new SortedDictionary<string, int[]>();
                }

                dragons[type][name] = stats;
            }

            foreach (var type in dragons)
            {
                var dragonsByType = type.Value;
                var dmgAvg = dragonsByType.Values.Average(a=>a[0]);
                var healthAvg = dragonsByType.Values.Average(a => a[1]);
                var armorAvg = dragonsByType.Values.Average(a => a[2]);

                Console.WriteLine($"{type.Key}::({dmgAvg:f2}/{healthAvg:f2}/{armorAvg:f2})");

                foreach (var dragon in dragonsByType)
                {
                        Console.WriteLine($"-{dragon.Key} -> damage: {dragon.Value[0]}, health: {dragon.Value[1]}, armor: {dragon.Value[2]}");                    
                }
            }
        }
    }
}
