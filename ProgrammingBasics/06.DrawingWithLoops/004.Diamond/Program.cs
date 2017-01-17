using System;

namespace _004.Diamond
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            Console.Write(new string('.', n));
            Console.Write(new string('*', 3 * n));
            Console.WriteLine(new string('.', n));
            for (int i = 1; i <= n-1; i++)
            {
                Console.Write(new string('.', n-i));
                Console.Write("*");
                Console.Write(new string('.', 3 *n-2+2*i));
                Console.Write("*");
                Console.WriteLine(new string('.', n-i));
            }
            Console.WriteLine(new string('*',5*n));
            for (int i = 1; i <= 2*n+1; i++)
            {
                Console.Write(new string('.',i));
                Console.Write("*");
                if (i==2*n+1)
                {
                    Console.Write(new string('*', 5 * n - 2 - 2 * i));
                }
                else
                {
                    Console.Write(new string('.', 5 * n - 2 - 2 * i));
                }
                Console.Write("*");
                Console.WriteLine(new string('.', i));
            }
        }
    }
}
