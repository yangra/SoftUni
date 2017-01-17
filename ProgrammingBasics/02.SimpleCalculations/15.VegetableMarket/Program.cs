using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _15.VegetableMarket
{
    class Program
    {
        static void Main(string[] args)
        {
           double BGNEUR = 1.94;

            double vegPrice = double.Parse(Console.ReadLine());
            double fruPrice = double.Parse(Console.ReadLine());
            int vegKg = int.Parse(Console.ReadLine());
            int fruKg = int.Parse(Console.ReadLine());

            double output = ((vegPrice * vegKg) + (fruPrice * fruKg)) / BGNEUR;
            Console.WriteLine(output);

        }
    }
}
