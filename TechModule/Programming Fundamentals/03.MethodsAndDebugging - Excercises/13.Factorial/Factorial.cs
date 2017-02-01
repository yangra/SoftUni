using System;
using System.Numerics;

namespace MethodsAndDebugging
{
    class Factorial
    {
        public static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            PrintFactorial(n);
        }

        public static void PrintFactorial(int number)
        {
            BigInteger factorial = 1;
            for (int i = 1; i <= number; i++)
            {
                factorial *= i;
            }
            Console.WriteLine(factorial);
        }
    }
}
