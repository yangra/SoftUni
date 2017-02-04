using System;
using System.Collections.Generic;
using System.Linq;

namespace _09.LegendaryFarming
{
    public class LegendaryFarming
    {
        public static void Main()
        {
            var resources = new Dictionary<string, int>();
            resources["motes"] = 0;
            resources["shards"] = 0;
            resources["fragments"] = 0;
            var junks = new SortedDictionary<string, int>();

            while (true)
            {
                var input = Console.ReadLine().Split();
                for (int i = 0; i < input.Length/2; i++)
                {
                    int quantity = int.Parse(input[i * 2]);
                    string material = input[i * 2 + 1].ToLower();

                    if (material == "motes" || material == "shards" || material == "fragments")
                    {
                        resources[material] += quantity;
                        if (resources.Any(x=>x.Value>=250))
                        {
                            break;
                        }
                    }
                    else
                    {
                        AddToJunk(material, quantity, junks);
                    }
                }

                if (resources.Any(x => x.Value >= 250))
                {
                    var toChange = PrintAward(resources);
                    foreach (var item in toChange)
                    {
                        resources[item] -= 250;
                    }

                    break;
                }
            }

            resources = resources.OrderByDescending(x => x.Value).ThenBy(x=>x.Key).ToDictionary(x => x.Key, x => x.Value);
            foreach (var resource in resources)
            {
                Console.WriteLine($"{resource.Key}: {resource.Value}");
            }

            foreach (var junk in junks)
            {
                Console.WriteLine($"{junk.Key}: {junk.Value}");
            }

        }

        public static List<string> PrintAward(Dictionary<string, int> dictionary)
        {
            var keysToChange = new List<string>();
            foreach (var pair in dictionary)
            {
                switch (pair.Key)
                {
                    case "motes":
                        {
                            if (pair.Value >= 250)
                            {
                                Console.WriteLine("Dragonwrath obtained!");
                                keysToChange.Add("motes");
                            }
                            break;
                        }
                    case "shards":
                        {
                            if (pair.Value >= 250)
                            {
                                Console.WriteLine("Shadowmourne obtained!");
                                keysToChange.Add("shards");
                            }
                            break;
                        }
                    case "fragments":
                        {
                            if (pair.Value >= 250)
                            {
                                Console.WriteLine("Valanyr obtained!");
                                keysToChange.Add("fragments");
                            }
                            break;
                        }
                    default:
                        break;
                }
            }
            return keysToChange;
        }

        public static void AddToJunk(string material, int quantity, SortedDictionary<string, int> junk)
        {
            if (!junk.ContainsKey(material))
            {
                junk[material] = 0;
            }

            junk[material] += quantity;
        }
    }
}
