using System;

namespace _01.SweetDessert
{
    public class SweetDessert
    {
        public static void Main()
        {
            decimal cash = decimal.Parse(Console.ReadLine());
            int guests = int.Parse(Console.ReadLine());
            double bananaPrice = double.Parse(Console.ReadLine());
            double eggPrice = double.Parse(Console.ReadLine());
            double berriesPriceKg = double.Parse(Console.ReadLine());

            int portions = guests / 6;
            if (guests % 6 > 0)
            {
                portions++;
            }

            double berriesPrice = berriesPriceKg / 5;
            double bananasPrice = bananaPrice * 2;
            double eggsPrice = eggPrice * 4;

            decimal moneyNeeded = portions * (decimal)(berriesPrice + bananasPrice + eggsPrice);

            if (cash>=moneyNeeded)
            {
                Console.WriteLine($"Ivancho has enough money - it would cost {moneyNeeded:f2}lv.");
            }
            else
            {
                Console.WriteLine($"Ivancho will have to withdraw money - he will need {moneyNeeded-cash:f2}lv more.");
            }

        }
    }
}
