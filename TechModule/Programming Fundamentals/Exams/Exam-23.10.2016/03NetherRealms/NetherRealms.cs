using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace _03NetherRealms
{
    public class NetherRealms
    {
        public static void Main()
        {
            var dems = Console.ReadLine().Split(new char[] { ' ', ',' }, StringSplitOptions.RemoveEmptyEntries);
            var deamons = new List<Deamon>();

            for (int i = 0; i < dems.Length; i++)
            {
                var health = 0;
                for (int j = 0; j < dems[i].Length; j++)
                {
                    if (!Char.IsNumber(dems[i][j])&&
                            dems[i][j] !='+'&&
                            dems[i][j] != '-' &&
                            dems[i][j] != '/' &&
                            dems[i][j] != '*' &&
                            dems[i][j] != '.')
                    {
                        health += dems[i][j];
                    } 
                }

                var damage = 0m;
                var regex = new Regex(@"(\+|\-)?\d*\.?\d+");
                MatchCollection matches = regex.Matches(dems[i]);
                foreach (Match match in matches)
                {
                    var reg = new Regex(@"\d\.\d");
                    if (match.ToString().Contains('.')&&reg.IsMatch(match.ToString()))
                    {
                        damage += decimal.Parse(match.ToString());
                    }
                    else if (!match.ToString().Contains('.'))
                    {
                        damage += decimal.Parse(match.ToString());
                    }
                    
                }

                for (int j = 0; j < dems[i].Length; j++)
                {
                    if (dems[i][j] =='*' )
                    {
                        damage *= 2;
                    }

                    if (dems[i][j] == '/')
                    {
                        damage /= 2;
                    }
                }

                var demon = new Deamon()
                {
                    Name = dems[i],
                    Health = health,
                    Damage = damage
                };

                deamons.Add(demon);
            }

            deamons = deamons.OrderBy(d => d.Name).ToList();
            foreach (var deamon in deamons)
            {
                Console.WriteLine("{0} - {1} health, {2:F2} damage", deamon.Name, deamon.Health, deamon.Damage);
            }
        }
    }
}
