using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.RoliTheCoder
{
    public class RoliTheCoder
    {
        public static void Main()
        {
            var events = new Dictionary<string, List<string>>();
            var ids = new Dictionary<string, string>();
            var input = Console.ReadLine();
            while (input != "Time for Code")
            {
                var args = input.Split(new char[] {' '}, StringSplitOptions.RemoveEmptyEntries);

                if (!args[1].StartsWith("#"))
                {
                    input = Console.ReadLine();
                    continue;
                }
                for (int i = 2; i < args.Length; i++)
                {
                    if (!args[i].StartsWith("@"))
                    {
                        input = Console.ReadLine();
                        continue;
                    }
                }

                var id = args[0];
                var eventName = args[1].Remove(0, 1);
                if (!ids.ContainsKey(id))
                {
                    ids[id] = eventName;
                    events[eventName] = new List<string>();
                    for (int i = 2; i < args.Length; i++)
                    {
                        if (!events[eventName].Contains(args[i]))
                        {
                            events[eventName].Add(args[i]);
                        }
                    }
                }
                if (ids.ContainsKey(id)&&ids[id]==eventName)
                {
                    for (int i = 2; i < args.Length; i++)
                    {
                        if (!events[eventName].Contains(args[i]))
                        {
                            events[eventName].Add(args[i]);
                        }
                    } 
                }

                input = Console.ReadLine();
            }

            events = events.OrderByDescending(e => e.Value.Count).ThenBy(e => e.Key).ToDictionary(
                e => e.Key, 
                e => e.Value.OrderBy(p=>p).ToList());

            foreach (var item in events)
            {
                Console.WriteLine("{0} - {1}", item.Key, item.Value.Count);
                foreach (var value in item.Value)
                {
                    Console.WriteLine(value);
                }
            }

        }
    }
}
