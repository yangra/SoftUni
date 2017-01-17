using System;

namespace _03.House
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            Console.Write(new string('.', n / 2));
            Console.Write("*");
            Console.WriteLine(new string('.', n / 2));
            for (int i = 0, j = 1; i < (n / 2) - 1; i++, j += 2)
            {
                Console.Write(new string('.', (n / 2) - 1 - i));
                Console.Write("*");
                Console.Write(new string('.', j));
                Console.Write("*");
                Console.WriteLine(new string('.', (n / 2) - 1 - i));
            }
            Console.WriteLine(new string('*', n));
            for (int i = n / 2 + 1; i < n - 1; i++)
            {
                Console.Write(new string('.', n / 4));
                Console.Write("*");
                Console.Write(new string('.', n - 2 * (n / 4) - 2));
                Console.Write("*");
                Console.WriteLine(new string('.', n / 4));
            }
            Console.Write(new string('.', n / 4));
            Console.Write(new string('*', n - 2 * (n / 4)));
            Console.WriteLine(new string('.', n / 4));
        }
    }
}
