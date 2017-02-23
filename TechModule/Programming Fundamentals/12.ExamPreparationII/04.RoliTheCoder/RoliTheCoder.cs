using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;


namespace _04.RoliTheCoder
{
    public class Event
    {
        public string Name { get; set; }
        public List<string> Participants { get; set; }
    }
    class RoliTheCoder
    {
        static void Main()
        {
            var events = new Dictionary<int, Event>();
            var line = Console.ReadLine();
            var valid = new Regex(@"(?<id>\d+)\s+#(?<eventName>\w+)(\s+@\w+)*");
            while (!line.Equals("Time for Code"))
            {
                
                if (valid.IsMatch(line))
                {
                    var tokens = line
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                    .Select(t => t.Trim())
                    .ToArray();
                    var id = int.Parse(valid.Match(line).Groups["id"].ToString());
                    var eventName = valid.Match(line).Groups["eventName"].ToString();
                    var participants = new List<string>();
                    for (int i = 2; i < tokens.Length; i++)
                    {
                        participants.Add(tokens[i]);
                    }
                    if (events.ContainsKey(id))
                    {
                        if (eventName == events[id].Name)
                        {
                            events[id].Participants.AddRange(participants);
                            events[id].Participants = events[id].Participants.Distinct().ToList();
                            line = Console.ReadLine();
                            continue;
                        }
                        else
                        {
                            line = Console.ReadLine();
                            continue;
                        }
                    }
                    var @event = new Event
                    {
                        Name = eventName,
                        Participants = new List<string>()
                    };
                    @event.Participants.AddRange(participants);
                    @event.Participants = @event.Participants.Distinct().ToList();
                    events[id] = @event;
                }

                line = Console.ReadLine();
            }

            events = events.OrderByDescending(e => e.Value.Participants.Count).ThenBy(e => e.Value.Name).ToDictionary(e => e.Key, e => e.Value);
            foreach (var @event in events)
            {
                Console.WriteLine($"{@event.Value.Name} - {@event.Value.Participants.Count}");
                foreach (var participant in @event.Value.Participants.OrderBy(p => p))
                {
                    Console.WriteLine($"{participant}");
                }
            }
        }
    }
}
