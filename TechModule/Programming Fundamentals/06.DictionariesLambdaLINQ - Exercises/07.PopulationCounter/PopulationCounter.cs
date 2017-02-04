using System;
using System.Collections.Generic;
using System.Linq;

namespace _07.PopulationCounter
{
    public class PopulationCounter
    {
        public static void Main()
        {
            var countries = new Dictionary<string, Dictionary<string, long>>();
            string input = Console.ReadLine();
            while (input!="report")
            {
                string[] splitted = input.Split('|');
                string city = splitted[0];
                string country = splitted[1];
                long population = long.Parse(splitted[2]);

                if (!countries.ContainsKey(country))
                {
                    countries[country] = new Dictionary<string, long>();
                }
                countries[country][city] = population;

                input = Console.ReadLine();
            }
            countries = countries.OrderByDescending(x => x.Value.Values.Sum()).ToDictionary(x=>x.Key, x=>x.Value);

            foreach(var country in countries)
            {
                var countryCities = country.Value;
                var countryPopulation = countryCities.Values.Sum(x => x);
                Console.WriteLine($"{country.Key} (total population: {countryPopulation})");

                countryCities = countryCities.OrderByDescending(x => x.Value).ToDictionary(x => x.Key, x => x.Value);

                foreach (var city in countryCities)
                {
                    Console.WriteLine($"=>{city.Key}: {city.Value}");
                }
            }
        }
    }
}
