using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _001.TransportPrice
{
    class Program
    {
        static void Main(string[] args)
        {
            int kilometers = int.Parse(Console.ReadLine());
            string partOfTheDay = Console.ReadLine();

            double price = 0;

            if (kilometers < 20)
            {
                if (partOfTheDay == "day")
                {
                    price = 0.7 + (kilometers * 0.79);
                    Console.WriteLine(price);
                }
                else if (partOfTheDay == "night")
                {
                    price = 0.7 + (kilometers * 0.9);
                    Console.WriteLine(price);
                }
                else
                {
                    Console.WriteLine("Invalid part of day!");
                }
            }
            if (kilometers >= 20 && kilometers < 100)
            {
                price = kilometers * 0.09;
                Console.WriteLine(price);
            }
            if (kilometers >= 100)
            {
                price = kilometers * 0.06;
                Console.WriteLine(price);
            }
        }
    }
}
