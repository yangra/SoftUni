using System;

namespace MethodsAndDebugging
{
    public class PrimeChecker
    {
        public static void Main()
        {
            long n = long.Parse(Console.ReadLine());

            Console.WriteLine(IsPrime(n));
            
        }

        public static bool IsPrime(long n)
        {
            bool isPrime = true;

            if (n==0||n==1)
            { 
                isPrime = false;
            }

            for (int i = 2; i <= Math.Sqrt(n); i++)
            {
                if (n % i == 0)
                {
                    isPrime = false;
                    break;
                }
            }

            return isPrime;
        }
    }
}
