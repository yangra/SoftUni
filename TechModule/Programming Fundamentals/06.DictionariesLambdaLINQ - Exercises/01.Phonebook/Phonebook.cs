using System;
using System.Collections.Generic;
using System.Linq;

namespace _01.Phonebook
{
    class Phonebook
    {
        static void Main()
        {
            var phonebook = new Dictionary<string, string>();

            string command = Console.ReadLine();
            while (command!="END")
            {
                ExecuteCommand(command, phonebook);

                command = Console.ReadLine();
            }
        }

        public static void ExecuteCommand(string command, Dictionary<string, string> phonebook)
        {
            string[] splitted = command.Split(' ').ToArray();
            string code = splitted[0];
            
            switch (code)
            {
                case "A":
                    {
                        string name = splitted[1];
                        string number = splitted[2];
                        if (!phonebook.ContainsKey(name))
                        {
                            phonebook[name] = "";
                        }
                                                
                        phonebook[name] = number;
                        break;
                    }
                case "S":
                    {
                        string name = splitted[1];
                        string number = string.Empty;
                        if(phonebook.TryGetValue(name, out number))
                        {
                            Console.WriteLine($"{name} -> {number}");
                        }
                        else
                        {
                            Console.WriteLine($"Contact {name} does not exist.");
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
