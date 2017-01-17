﻿using System;

namespace _05.DrawFort
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            Console.WriteLine("/{0}\\{1}/{0}\\", new string('^', n / 2), new string('_', 2 * n - 4 - 2 * (n / 2)));
            for (int i = 1; i <= n - 2; i++)
            {
                if (i == n - 2)
                {
                    Console.WriteLine("|{0}{1}{0}|", new string(' ', n / 2 + 1), new string('_', 2 * n - 4 - 2 * (n / 2)));
                }
                else
                {
                    Console.WriteLine("|{0}|", new string(' ', 2 * n - 2));
                }
            }
            Console.WriteLine("\\{0}/{1}\\{0}/", new string('_', n / 2), new string(' ', 2 * n - 4 - 2 * (n / 2)));
        }
    }
}
