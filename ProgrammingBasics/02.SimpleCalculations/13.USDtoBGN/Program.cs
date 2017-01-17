using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _13.USDtoBGN
{
    class Program
    {
        static void Main(string[] args)
        {
            const double rateUSBG = 1.79549;

            double USD = double.Parse(Console.ReadLine());

            double BGN = USD * rateUSBG;

            Console.WriteLine("{0:F2}", BGN);

        }
    }
}
