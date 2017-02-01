using System;
using System.Collections.Generic;

namespace MethodsAndDebugging
{
    public class PrimesInGivenRange
    {
        public static void Main(string[] args)
        {
            int start = int.Parse(Console.ReadLine());
            int end = int.Parse(Console.ReadLine());

            List<int> primes = FindPrimesInRange(start, end);
            PrintList(primes);
        }

        public static void PrintList(List<int> primes)
        {
            for (int i = 0; i < primes.Count; i++)
            {
                if (i != primes.Count - 1)
                {
                    Console.Write("{0}, ", primes[i]);
                }
                else
                {
                    Console.Write("{0}", primes[i]);
                }
                
            }
        }

        public static List<int> FindPrimesInRange(int startNum, int endNum)
        {
            List<int> primes = new List<int>();
            for (int num = startNum; num <= endNum; num++)
            {
                if (IsPrime(num))
                { 
                    primes.Add(num);
                }
            }

            return primes;
        }

        public static bool IsPrime(int n)
        {
            bool isPrime = true;

            if (n == 0 || n == 1)
                isPrime = false;

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
