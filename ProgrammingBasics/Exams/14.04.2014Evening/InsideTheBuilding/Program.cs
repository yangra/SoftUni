using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InsideTheBuilding
{
    class Program
    {
        static void Main(string[] args)
        {
            int h = int.Parse(Console.ReadLine());
            int x1 = int.Parse(Console.ReadLine());
            int y1 = int.Parse(Console.ReadLine());
            int x2 = int.Parse(Console.ReadLine());
            int y2 = int.Parse(Console.ReadLine());
            int x3 = int.Parse(Console.ReadLine());
            int y3 = int.Parse(Console.ReadLine());
            int x4 = int.Parse(Console.ReadLine());
            int y4 = int.Parse(Console.ReadLine());
            int x5 = int.Parse(Console.ReadLine());
            int y5 = int.Parse(Console.ReadLine());

            IsPointOutside(x1, y1, h);
            IsPointOutside(x2, y2, h);
            IsPointOutside(x3, y3, h);
            IsPointOutside(x4, y4, h);
            IsPointOutside(x5, y5, h);
        }

        public static void IsPointOutside(int x, int y, int height)
        {
            if (x >= 0 && x <= 3 * height && y >= 0 && y <= height)
                Console.WriteLine("inside");
            else if (x >= height && x <= 2 * height && y >= height && y <= 4 * height)
                Console.WriteLine("inside");
            else
                Console.WriteLine("outside");
        }

    }
}
