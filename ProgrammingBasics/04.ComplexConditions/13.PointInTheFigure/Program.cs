﻿using System;

namespace _13.PointInTheFigure
{
    class Program
    {
        static void Main(string[] args)
        {
            int h = int.Parse(Console.ReadLine());
            int x = int.Parse(Console.ReadLine());
            int y = int.Parse(Console.ReadLine());

            if (x > 0 && x < 3 * h && y < h && y > 0)
            {
                Console.WriteLine("inside");
            }
            else if (x > h && x < 2 * h && y < 4 * h && y >= h)
            {
                Console.WriteLine("inside");
            }
            else if (x < 0 || x > 3 * h || y > 4 * h || y < 0)
            {
                Console.WriteLine("outside");
            }
            else if (x >= 0 && x < h && y <= h * 4 && y > h)
            {
                Console.WriteLine("outside");
            }
            else if (x > 2*h && x <= 3*h && y <= h * 4 && y > h)
            {
                Console.WriteLine("outside");
            }
            else
            {
                Console.WriteLine("border");
            }
        }
    }
}
