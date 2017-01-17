using System;

namespace _01.Fishland
{
    class Program
    {
        static void Main(string[] args)
        {
            double priceMack = double.Parse(Console.ReadLine());
            double priceCaca = double.Parse(Console.ReadLine());
            double kgPalamud = double.Parse(Console.ReadLine());
            double kgSafrid = double.Parse(Console.ReadLine());
            int kgMussel = int.Parse(Console.ReadLine());

            double toPay = priceMack * kgPalamud * 1.6 + 
                kgSafrid * priceCaca * 1.8 + kgMussel * 7.5;

            Console.WriteLine("{0:F2}", toPay);
        }
    }
}
