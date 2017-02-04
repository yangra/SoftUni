using System;
using System.Collections.Generic;
using System.Linq;

namespace _04.FixEmails
{
    public class FixEmails
    {
        public static void Main()
        {
            var emails = new Dictionary<string, string>();
            string line = Console.ReadLine();
            
            while (line != "stop")
            {
                string name = line;
                string email = Console.ReadLine();
                if (!email.Contains(".us") && !email.Contains(".uk"))
                {
                    if (!emails.ContainsKey(name))
                    {
                        emails[name] = "";
                    }

                    emails[name] = email;
                }

                line = Console.ReadLine();
            }

            foreach (var pair in emails)
            {
                Console.WriteLine($"{pair.Key} -> {pair.Value}");
            }
        }
    }
}
