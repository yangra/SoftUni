using System;
using System.Collections.Generic;
using System.Linq;

namespace _04.SofUniCoffeeSupplies
{
    public class SofUniCoffeeSupplies
    {
        public static void Main()
        {
            string[] delimiters = Console.ReadLine().Split(' ').ToArray();
            var coffeeQuantity = new Dictionary<string, long>();
            var coffeePeople = new Dictionary<string, string>();
            string input = Console.ReadLine();
            while (input != "end of info")
            {
                if (input.Contains(delimiters[0]))
                {
                    input = input.Replace(delimiters[0], "@");
                    var args = input.Split('@');
                    string person = args[0];
                    string coffeeType = args[1];
                    if (!coffeeQuantity.ContainsKey(coffeeType))
                    {
                        coffeeQuantity[coffeeType] = 0;
                    }

                    coffeePeople[person] = coffeeType;
                }
                else
                {
                    input = input.Replace(delimiters[1], "@");
                    var args = input.Split('@');
                    string coffeeType = args[0];
                    long coffeeCount = long.Parse(args[1]);
                    if (!coffeeQuantity.ContainsKey(coffeeType))
                    {
                        coffeeQuantity[coffeeType] = 0;
                    }
                    coffeeQuantity[coffeeType] += coffeeCount;
                }

                input = Console.ReadLine();
            }

            foreach (var item in coffeeQuantity)
            {
                if (item.Value<=0)
                {
                    Console.WriteLine("Out of {0}", item.Key);
                }
            }

            input = Console.ReadLine();
            while (input != "end of week")
            {
                var inputArgs = input.Split(' ');
                string person = inputArgs[0];
                long coffees = long.Parse(inputArgs[1]);
                if (coffeePeople.ContainsKey(person))
                {
                    if (coffeeQuantity.ContainsKey(coffeePeople[person]))
                    {
                        coffeeQuantity[coffeePeople[person]] -= coffees;
                        if (coffeeQuantity[coffeePeople[person]] <= 0)
                        {
                            Console.WriteLine("Out of {0}", coffeePeople[person]);
                        }
                    }
                }

                input = Console.ReadLine();
            }

            Console.WriteLine("Coffee Left:");
            var coffeeLeft = coffeeQuantity.Where(p => p.Value > 0).ToDictionary(p => p.Key, p => p.Value).OrderByDescending(p => p.Value);
            foreach (var item in coffeeLeft)
            {
                Console.WriteLine($"{item.Key} {item.Value}");
            }
            Console.WriteLine("For:");
            var coffeeTypeOrdered = coffeeLeft.OrderBy(p => p.Key);
            var peopleOrdered = coffeePeople.OrderByDescending(p => p.Key);
            foreach (var item in coffeeTypeOrdered)
            {
                foreach (var pair in peopleOrdered)
                {
                    if (item.Key == pair.Value)
                    {
                        Console.WriteLine($"{pair.Key} {pair.Value}");
                    }
                }
            }

        }
    }
}
