﻿using System;

namespace _08.VolumeOfPyrmid
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Length: ");
            double length = double.Parse(Console.ReadLine());
            Console.Write("Width: ");
            double width = double.Parse(Console.ReadLine());
            Console.Write("Heigth: ");
            double height = double.Parse(Console.ReadLine());

            double volume = (length + width + height) / 3;
            Console.WriteLine("Pyramid Volume: {0:F2}", volume);

        }
    }
}
