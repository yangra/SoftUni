using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace _03.NetherRealms
{
    public class Demon
    {
        public int Health { get; set; }
        public string Name { get; set; }
        public double Damage { get; set; }
    }
    class NetherRealms
    {
        static void Main(string[] args)
        {
            var result = new List<Demon>();
            var demons = Console.ReadLine()
                .Split(',').Select(d => d.Trim()).ToArray();
            var numbers = new Regex(@"(\+|-)*\d*\.*\d+");
            var symbols = new Regex(@"[^0-9\+-\.\*\/]");
            for (int i = 0; i < demons.Length; i++)
            {
                var health = 0;
                foreach (Match match in symbols.Matches(demons[i]))
                {
                    health += char.Parse(match.ToString());
                }
                var damage = 0.0;
                foreach (Match match in numbers.Matches(demons[i]))
                {
                    damage += double.Parse(match.ToString());
                }
                for (int j = 0; j < demons[i].Length; j++)
                {
                    if (demons[i][j]=='/')
                    {
                        damage /= 2;
                    }
                    if (demons[i][j] == '*')
                    {
                        damage *= 2;
                    }
                }
                var deamon = new Demon
                {
                    Name = demons[i],
                    Health = health,
                    Damage = damage
                };
                result.Add(deamon);
            }

            result = result.OrderBy(d=>d.Name).ToList();
            foreach (var demon in result)
            {
                Console.WriteLine($"{demon.Name} - {demon.Health} health, {demon.Damage:F2} damage");
            }
        }
    }
}
