using System;
using System.Collections.Generic;
using System.Linq;

namespace _04.PopulationAggregation
{
    public class PopulationAggregation
    {
        public static void Main(string[] args)
        {
            string input = Console.ReadLine();
            var countries = new SortedDictionary<string, int>();
            var cities = new Dictionary<string, long>();
            while (input != "stop")
            {
                string[] inputArgs = input.Split('\\');
                inputArgs[0] = ClearProhibitedSymbols(inputArgs[0]);
                inputArgs[1] = ClearProhibitedSymbols(inputArgs[1]);
                string country = string.Empty;
                string city = string.Empty;
                if (inputArgs[0][0] < 'a')
                {
                    country = inputArgs[0];
                    city = inputArgs[1];
                }
                else
                {
                    city = inputArgs[0];
                    country = inputArgs[1];
                }

                var population = long.Parse(inputArgs[2]);

                if (!countries.ContainsKey(country))
                {
                    countries[country] = 0;
                }

                countries[country]++;

                if (!cities.ContainsKey(city))
                {
                    cities[city] = 0;
                }

                cities[city] = population;

                input = Console.ReadLine();
            }

            foreach (var pair in countries)
            {
                Console.WriteLine($"{pair.Key} -> {pair.Value}");
            }

            var biggestThree = cities.OrderByDescending(n => n.Value)
                                     .Take(3)
                                     .ToDictionary(n => n.Key, n => n.Value);

            foreach (var pair in biggestThree)
            {
                Console.WriteLine($"{pair.Key} -> {pair.Value}");
            }
        }

        public static string ClearProhibitedSymbols(string name)
        {
            for (int i = 0; i < 10; i++)
            {
                char symbol = (char)(i + '0');
                name = name.Replace(symbol, ' ');
            }

            name = name.Replace("@", "");
            name = name.Replace("&", "");
            name = name.Replace("$", "");
            name = name.Replace("#", "");
            name = name.Replace(" ", "");
            return name;
        }
    }
}
