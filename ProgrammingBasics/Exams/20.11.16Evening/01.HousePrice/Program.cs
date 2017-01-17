using System;

namespace _01.HousePrice
{
    class Program
    {
        static void Main(string[] args)
        {
            double areaSmallRoom = double.Parse(Console.ReadLine());
            double areaKitchen = double.Parse(Console.ReadLine());
            double priceSqM = double.Parse(Console.ReadLine());

            double areaBathroom = areaSmallRoom / 2;
            double areaSecRoom = areaSmallRoom * 1.1;
            double areaThirdRoom = areaSecRoom * 1.1;
            double areaApp = (areaKitchen + areaBathroom + areaSmallRoom + areaSecRoom + areaThirdRoom) * 1.05;
            double priceApp = areaApp * priceSqM;

            Console.WriteLine("{0:f2}", priceApp);

        }
    }
}
