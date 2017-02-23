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
            var priceBerriesKg = decimal.Parse(Console.ReadLine());

            var portions = guests / 6;
            if (guests % 6 != 0)
            {
                portions++;
            }

            var moneyNeeded = portions * (2 * bananaPrice + 4 * eggPrice + priceBerriesKg / 5);
            var moneyLeft = cash - moneyNeeded;
            if (moneyLeft>=0)
            {
                Console.WriteLine($"Ivancho has enough money - it would cost {moneyNeeded:F2}lv.");
            }
            else
            {
                Console.WriteLine($"Ivancho will have to withdraw money - he will need {Math.Abs(moneyLeft):F2}lv more.");
            }
        }
    }
}
