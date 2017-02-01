using System;

namespace MethodsAndDebugging
{
    class FactorialTrailingZeroes
    {
        public static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            Console.WriteLine(FindTrailingZeroesInFactorial(n));
        }

        public static int FindTrailingZeroesInFactorial(int number)
        {
            int numberOfZeroes = 0;
            for (int pow5 = 5; pow5 <= number; pow5*=5)
            {
                numberOfZeroes += number / pow5;
            }
            return numberOfZeroes;
        }
    }
}
