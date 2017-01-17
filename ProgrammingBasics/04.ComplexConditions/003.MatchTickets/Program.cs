using System;

namespace _004.MatchTickets
{
    class Program
    {
        static void Main(string[] args)
        {
            double budget = double.Parse(Console.ReadLine());
            string cat = Console.ReadLine();
            int people = int.Parse(Console.ReadLine());

            double moneyLeft = 0;

            if (people >= 1 && people <= 4)
                moneyLeft = budget * 0.25;
            else if (people >= 5 && people <= 9)
                moneyLeft = budget * 0.4;
            else if (people >= 10 && people <= 24)
                moneyLeft = budget * 0.5;
            else if (people >= 25 && people <= 49)
                moneyLeft = budget * 0.6;
            else if (people >= 50)
                moneyLeft = budget * 0.75;

            if (cat == "VIP")
            {
                if (moneyLeft >= people * 499.99)
                    Console.WriteLine("Yes! You have {0:f2} leva left.", moneyLeft - (people * 499.99));
                else
                    Console.WriteLine("Not enough money! You need {0:f2} leva.", (people * 499.99) - moneyLeft);
            }
            else if (cat == "Normal")
            {
                if (moneyLeft >= people * 249.99)
                    Console.WriteLine("Yes! You have {0:f2} leva left.", moneyLeft - (people * 249.99));
                else
                    Console.WriteLine("Not enough money! You need {0:f2} leva.", (people * 249.99) - moneyLeft);
            }
        }
    }
}
