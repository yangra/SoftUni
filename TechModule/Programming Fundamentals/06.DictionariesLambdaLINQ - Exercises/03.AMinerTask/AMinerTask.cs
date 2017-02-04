using System;
using System.Collections.Generic;

namespace _03.AMinerTask
{
    public class AMinerTask
    {
        public static void Main()
        {
            
            var resources = new Dictionary<string, int>();

            string input = Console.ReadLine();
            while (input != "stop")
            {
                string resource = input; 
                int quantity = int.Parse(Console.ReadLine());

                if (!resources.ContainsKey(resource))
                {
                    resources[resource] = 0;
                }

                resources[resource] += quantity;

                input = Console.ReadLine();
            }

            foreach (var pair in resources)
            {
                Console.WriteLine($"{pair.Key} -> {pair.Value}");
            }
        }
    }
}
