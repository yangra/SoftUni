﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _11.CelsiusToFahrenheit
{
    class Program
    {
        static void Main(string[] args)
        {
            var celsius = double.Parse(Console.ReadLine());

            double fahrenheit = celsius * 1.8 + 32;
            Console.WriteLine("{0:#.##}", fahrenheit);
        }
    }
}
