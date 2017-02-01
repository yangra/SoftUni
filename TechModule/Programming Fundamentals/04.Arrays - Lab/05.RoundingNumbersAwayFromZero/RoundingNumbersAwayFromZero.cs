using System;
using System.Linq;

namespace _05.RoundingNumbersAwayFromZero
{
    class RoundingNumbersAwayFromZero
    {
        static void Main(string[] args)
        {
            double[] input = Console.ReadLine().Split(' ').Select(double.Parse).ToArray();

            for (int i = 0; i < input.Length; i++)
            {
                int result = (int)(Math.Abs(input[i]) + 0.5) / 1;
                if (input[i] < 0)
                {
                    result *= -1;
                }
                Console.WriteLine("{0} => {1}", input[i], result);
            }
        }
    }
}
