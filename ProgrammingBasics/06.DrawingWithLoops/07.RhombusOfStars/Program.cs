﻿using System;


namespace _07.RhombusOfStars
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            for (int i = 1; i <= n; i++)
            {
                Console.Write(new string(' ',n-i));
                for (int j = 0; j < i; j++)
                {
                    Console.Write("* ");
                }
                Console.WriteLine();
            }
            for (int i = 1; i <= n-1; i++)
            {
                Console.Write(new string(' ',i));
                for (int j = n-i; j > 0; j--)
                {
                    Console.Write("* ");
                }
                Console.WriteLine();
            }
        }
    }
}
