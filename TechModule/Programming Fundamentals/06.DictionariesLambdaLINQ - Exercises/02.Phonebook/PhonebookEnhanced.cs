using System;
using System.Collections.Generic;
using System.Linq;

namespace _02.Phonebook
{
    public class PhonebookEnhanced
    {
        public static void Main()
        {

            var phonebook = new SortedDictionary<string, string>();

            string command = Console.ReadLine();
            while (command != "END")
            {
                ExecuteCommand(command, phonebook);
                command = Console.ReadLine();
            }

        }

        private static void ExecuteCommand(string command, SortedDictionary<string, string> phonebook)
        {
            string[] splitted = command.Split(' ').ToArray();
            string code = splitted[0];

            switch (code)
            {
                case "A":
                    {
                        string name = splitted[1];
                        string number = splitted[2];
                        if (phonebook.ContainsKey(name))
                        {
                            phonebook[name] = number;
                        }
                        else
                        {
                            phonebook.Add(name, number);
                        }
                        break;
                    }
                case "S":
                    {
                        string name = splitted[1];
                        string number = string.Empty;
                        if (phonebook.TryGetValue(name, out number))
                        {
                            Console.WriteLine($"{name} -> {number}");
                        }
                        else
                        {
                            Console.WriteLine($"Contact {name} does not exist.");
                        }
                        break;
                    }
                case "ListAll":
                    {
                        foreach (var pair in phonebook)
                        {
                            Console.WriteLine($"{pair.Key} -> {pair.Value}");
                        }
                        break;
                    }
                default:
                    Console.WriteLine("Please enter a valid command!");
                    break;
            }
        }
    }
}
