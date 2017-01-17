using System;

namespace _03.Eclipse
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            Console.WriteLine(" {0}{1}{0} ", new string('*', 2 * n - 2), new string(' ', n + 1));
            for (int i = 0; i < n - 2; i++)
            {
                Console.Write("*{0}*", new string('/', 2 * n - 2));
                if (i == (n - 2) / 2)
                {
                    Console.Write(new string('-', n - 1));
                }
                else
                {
                    Console.Write(new string(' ', n - 1));
                }
                Console.WriteLine("*{0}*", new string('/', 2 * n - 2));
            }
            Console.WriteLine(" {0}{1}{0} ", new string('*', 2 * n - 2), new string(' ', n + 1));
        }
    }
}
