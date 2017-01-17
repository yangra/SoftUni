using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _09._2DRectangleArea
{
    class Program
    {
        static void Main(string[] args)
        {
            double x1 = double.Parse(Console.ReadLine());
            double y1 = double.Parse(Console.ReadLine());
            double x2 = double.Parse(Console.ReadLine());
            double y2 = double.Parse(Console.ReadLine());
            
            double X = x1 - x2;
            if (X<0)
            {
                X *= -1;
            }
            double Y = y1 - y2;
            if (Y<0)
            {
                Y *= -1;

            }
            double area = X * Y;
            double perimeter = 2 * (X + Y);

            Console.WriteLine(area);
            Console.WriteLine(perimeter);
        }
    }
}
