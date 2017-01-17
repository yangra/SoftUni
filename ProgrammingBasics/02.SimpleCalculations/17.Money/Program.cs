using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _17.Money
{
    class Program
    {
        static void Main(string[] args)
        {
            double bitBGN = 1168;
            double YONUSD = 0.15;
            double USDBGN = 1.76;
            double EURBGN = 1.95;

            int bitCoins = int.Parse(Console.ReadLine());
            double yoans = double.Parse(Console.ReadLine());
            double commission = double.Parse(Console.ReadLine());

            double output = (((bitCoins * bitBGN) / EURBGN) + (((yoans * YONUSD)*USDBGN) / EURBGN)) * (1 - (commission/100));

            Console.WriteLine(output);

        }
    }
}
