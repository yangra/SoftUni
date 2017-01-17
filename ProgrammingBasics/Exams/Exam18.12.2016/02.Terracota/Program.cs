using System;

namespace _02.Terracota
{
    class Program
    {
        static void Main(string[] args)
        {
            double money = double.Parse(Console.ReadLine());
            double width = double.Parse(Console.ReadLine());
            double height = double.Parse(Console.ReadLine());
            double tileSide = double.Parse(Console.ReadLine());
            double tileHeight = double.Parse(Console.ReadLine());
            double priceTile = double.Parse(Console.ReadLine());
            double payment = double.Parse(Console.ReadLine());

            double area = width * height;
            double tileArea = (tileSide * tileHeight) / 2;
            double tilesNeeded = Math.Ceiling(area / tileArea)+5;
            double total = tilesNeeded * priceTile + payment;

            if (total<=money)
            {
                Console.WriteLine("{0:F2} lv left.",money-total);
            }
            else
            {
                Console.WriteLine("You'll need {0:F2} lv more.",total-money);
            }
        }
    }
}
