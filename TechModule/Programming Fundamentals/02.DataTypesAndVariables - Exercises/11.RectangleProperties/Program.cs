﻿using System;

namespace _11.RectangleProperties
{
    class Program
    {
        static void Main(string[] args)
        {
            double width = double.Parse(Console.ReadLine());
            double height = double.Parse(Console.ReadLine());

            double area = width * height;
            double perimeter = 2 * width + 2 * height;
            double diagonal = Math.Sqrt(width * width + height * height);

            Console.WriteLine(perimeter);
            Console.WriteLine(area);
            Console.WriteLine(diagonal);
        }

    }
}
