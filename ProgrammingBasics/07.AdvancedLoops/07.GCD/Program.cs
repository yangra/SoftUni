using System;

namespace _07.GCD
{
    class Program
    {
        static void Main(string[] args)
        {
            double a = double.Parse(Console.ReadLine());
            double b = double.Parse(Console.ReadLine());

            double swap = 0;
            while (b > 0)
            {
                swap = b;
                b = a % b;
                a = swap;
            }
            Console.WriteLine(a);
        }
    }
}
