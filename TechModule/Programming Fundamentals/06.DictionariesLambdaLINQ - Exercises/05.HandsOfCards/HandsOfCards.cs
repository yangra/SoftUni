using System;
using System.Collections.Generic;
using System.Linq;

namespace _05.HandsOfCards
{
    public class HandsOfCards
    {
        public static void Main()
        {
            var hands = new Dictionary<string, List<string>>();

            string input = Console.ReadLine();
            while (input != "JOKER")
            {
                string[] splitted = input.Split(':');
                string name = splitted[0];
                List<string> cards = splitted[1].Split(new char[] { ',', ' ' }, StringSplitOptions.RemoveEmptyEntries).ToList();
                if (!hands.ContainsKey(name))
                {
                    hands[name] = new List<string>();
                }

                hands[name] = hands[name].Concat(cards).Distinct().ToList();

                input = Console.ReadLine();
            }

            foreach (var pair in hands)
            {
                int result = 0;
                foreach (var card in pair.Value)
                {
                    int power = GetPowerValue(card[0]);
                    int type = GetTypeValue(card.Last());
                    result += power * type;
                }
                Console.WriteLine($"{pair.Key}: {result}");
            }
        }

        public static int GetPowerValue(char power)
        {
            switch (power)
            {
                case '1': return 10;
                case '2': return 2; 
                case '3': return 3; 
                case '4': return 4; 
                case '5': return 5; 
                case '6': return 6; 
                case '7': return 7; 
                case '8': return 8; 
                case '9': return 9; 
                case 'J': return 11; 
                case 'Q': return 12; 
                case 'K': return 13; 
                case 'A': return 14; 
                default: return 0; 
            }
        }

        public static int GetTypeValue(char type)
        {
            switch (type)
            {
                case 'S': return 4; 
                case 'H': return 3; 
                case 'D': return 2; 
                case 'C': return 1; 
                default: return 0; 
            }
        }
    }
}
