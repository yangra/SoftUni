using System;

namespace _01.SweetDessert
{
    public class SweetDessert
    {
        public static void Main()
        {
            var cash = decimal.Parse(Console.ReadLine());
            var guests = int.Parse(Console.ReadLine());
            var bananaPrice = decimal.Parse(Console.ReadLine());
            var eggPrice = decimal.Parse(Console.ReadLine());
            var berriesKgPrice = decimal.Parse(Console.ReadLine());

            var portions = (int)Math.Ceiling(guests / 6.0);

            var moneyNeeded = portions * (2 * bananaPrice + 4 * eggPrice + 0.2m * berriesKgPrice);

            if (cash>=moneyNeeded)
            {
                Console.WriteLine($"Ivancho has enough money - it would cost {moneyNeeded:F2}lv.");
            }
            else
            {
                Console.WriteLine($"Ivancho will have to withdraw money - he will need {moneyNeeded-cash:F2}lv more.");
            }
        }
    }
}
