using System;

namespace _10.House
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            if (n % 2 == 0)
            {
                for (int i = 1; i <= n / 2; i++)
                {
                    Console.Write(new string('-', n / 2 - i));
                    Console.Write(new string('*', 2 * i));
                    Console.WriteLine(new string('-', n / 2 - i));
                }
            }
            else
            {
                for (int i = 0; i < n / 2 + 1; i++)
                {

                    Console.Write(new string('-', n / 2 - i));
                    Console.Write(new string('*', 2*i +1));
                    Console.WriteLine(new string('-', n / 2 - i));

                }
            }

            for (int i = 0; i < n/2; i++)
            {
                Console.Write("|");
                Console.Write(new string('*',n-2));
                Console.WriteLine("|");
            }

        }
    }
}
