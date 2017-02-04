using System;
using System.Collections.Generic;
using System.Linq;

namespace _08.LogsAggregator
{
    public class LogsAggregator
    {
        public static void Main()
        {
            var logs = new SortedDictionary<string, SortedDictionary<string, long>>();
            int n = int.Parse(Console.ReadLine());
            for (int i = 0; i < n; i++)
            {
                string[] input = Console.ReadLine().Split();
                string ip = input[0];
                string user = input[1];
                long duration = long.Parse(input[2]);

                if (!logs.ContainsKey(user))
                {
                    logs[user] = new SortedDictionary<string, long>();
                }

                if (!logs[user].ContainsKey(ip))
                {
                    logs[user][ip] = 0;
                }

                logs[user][ip] += duration;
            }

            foreach (var user in logs)
            {
                var userDuration = user.Value.Values.Sum();
                Console.Write($"{user.Key}: {userDuration} [");
                Console.WriteLine(string.Join(", ",user.Value.Select(x=>x.Key))+"]");
            }
        }
    }
}
