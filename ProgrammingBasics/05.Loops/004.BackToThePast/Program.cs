using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _004.BackToThePast
{
    class Program
    {
        static void Main(string[] args)
        {
            double legacy = double.Parse(Console.ReadLine());
            int endYear = int.Parse(Console.ReadLine());

            double priceLiving = 0;
            for (int i = 0; i <= endYear-1800; i++)
            {
                if (i%2==0)
                {
                    priceLiving += 12000;
                }
                else
                {
                    priceLiving += 12000 + 50 * (18 + i);
                }
            }
            if (legacy>=priceLiving)
            {
                Console.WriteLine("Yes! He will live a carefree life and will have {0:f2} dollars left.",legacy-priceLiving );
            }
            else
            {
                Console.WriteLine("He will need {0:f2} dollars to survive.",priceLiving-legacy);
            }
        }
    }
}
