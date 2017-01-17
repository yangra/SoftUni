using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _16.PlateFixing
{
    class Program
    {
        static void Main(string[] args)
        {
            int sqSide = int.Parse(Console.ReadLine());
            double plWidth = double.Parse(Console.ReadLine());
            double plLength = double.Parse(Console.ReadLine());
            int bnWidth = int.Parse(Console.ReadLine());
            int bnLength = int.Parse(Console.ReadLine());

            int area = (sqSide * sqSide) - (bnLength * bnWidth);
            double plArea = plWidth * plLength;

            double plCount = area / plArea;
            double time = plCount * 0.2;

            Console.WriteLine(plCount);
            Console.WriteLine(time);

        }
    }
}
