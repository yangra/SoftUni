using System;

namespace _11.Diamond
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            if (n % 2 != 0)
            {
                for (int i = 0; i < n / 2 + 1; i++)
                {
                    int mid = n - 2 * ((n - 1) / 2 - i) - 2;
                    Console.Write(new string('-', ((n - 1) / 2) - i));
                    Console.Write("*");
                    if (mid >= 0)
                    {
                        Console.Write(new string('-', mid));
                        Console.Write("*");
                    }
                    Console.WriteLine(new string('-', ((n - 1) / 2) - i));
                }
                for (int i = n / 2 - 1; i >= 0; i--)
                {
                    int mid = n - 2 * ((n - 1) / 2 - i) - 2;
                    Console.Write(new string('-', ((n - 1) / 2) - i));
                    Console.Write("*");
                    if (mid >= 0)
                    {
                        Console.Write(new string('-', mid));
                        Console.Write("*");
                    }
                    Console.WriteLine(new string('-', ((n - 1) / 2) - i));
                }

            }
            else
            {
                for (int i = 0; i < n / 2; i++)
                {
                    Console.Write(new string('-', n / 2 - i-1));
                    Console.Write("*");
                    Console.Write(new string('-', 2 * i));
                    Console.Write("*");
                    Console.WriteLine(new string('-', n / 2 - i-1));
                }
                for (int i = n / 2 - 2; i >= 0; i--)
                {
                    Console.Write(new string('-', n / 2 - i-1));
                    Console.Write("*");
                    Console.Write(new string('-', 2 * i));
                    Console.Write("*");
                    Console.WriteLine(new string('-', n / 2 - i-1));

                }
            }
        }
    }
}
