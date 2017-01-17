using System;


namespace _05.ChristmasHat
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            Console.WriteLine("{0}/|\\{0}", new string('.', 2 * n - 1));
            Console.WriteLine("{0}\\|/{0}", new string('.', 2 * n - 1));
            for (int i = 0; i < 2 * n; i++)
            {
                Console.WriteLine("{0}*{1}*{1}*{0}", new string('.', 2 * n - i - 1), new string('-', i));
            }
            Console.WriteLine(new string('*', 4 * n + 1));
            for (int i = 0; i < 2*n; i++)
            {
                Console.Write("*.");
                if (i==2*n-1)
                {
                    Console.WriteLine("*");
                }
            }
            Console.WriteLine(new string('*', 4 * n + 1));
        }
    }
}
