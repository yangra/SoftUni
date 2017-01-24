using System;

namespace _14.FastPrimeCheckerRef
{
    class Program
    {
        static void Main(string[] args)
        {
            int limit = int.Parse(Console.ReadLine());
            for (int number = 2; number <= limit; number++)
            {
                bool isPrime = true;
                for (int div = 2; div <= Math.Sqrt(number); div++)
                {
                    if (number % div == 0)
                    {
                        isPrime = false;
                        break;
                    }
                }
                Console.WriteLine($"{number} -> {isPrime}");
            }
        }
    }
}
