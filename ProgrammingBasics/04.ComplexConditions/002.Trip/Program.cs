using System;

namespace _002.Trip
{
    class Program
    {
        static void Main(string[] args)
        {
            double money = double.Parse(Console.ReadLine());
            string season = Console.ReadLine();

            if (money > 0 && money <= 100)
            {
                Console.WriteLine("Somewhere in Bulgaria");
                if (season == "winter")
                    Console.WriteLine("Hotel - {0:f2}", money * 0.7);
                else if (season == "summer")
                    Console.WriteLine("Camp - {0:f2}", money * 0.3);
                else
                    Console.WriteLine("Invalid season");
            }
            else if (money > 100 && money <= 1000)
            {
                Console.WriteLine("Somewhere in Balkans");
                if (season == "winter")
                    Console.WriteLine("Hotel - {0:f2}", money * 0.8);
                else if (season == "summer")
                    Console.WriteLine("Camp - {0:f2}", money * 0.4);
                else
                    Console.WriteLine("Invalid season");
            }
            else if (money > 1000)
            {
                Console.WriteLine("Somewhere in Europe");
                Console.WriteLine("Hotel - {0:f2}", money * 0.9);
            }
            else
            {
                Console.WriteLine("Invalid sum of money");
            }
        }
    }
}
