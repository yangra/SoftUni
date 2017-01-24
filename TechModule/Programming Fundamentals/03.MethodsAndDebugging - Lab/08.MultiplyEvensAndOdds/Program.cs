using System;

namespace _08.MultiplyEvensAndOdds
{
    class Program
    {
        static void Main(string[] args)
        {
            long num = long.Parse(Console.ReadLine());
            num = Math.Abs(num);
            Console.WriteLine(GetMultOfEvensAndOdds(num));
        }

        private static int GetMultOfEvensAndOdds(long num)
        {
            int oddSum = GetSumOfOddDigits(num);
            int evenSum = GetSumOfEvenDigits(num);
            int result = oddSum * evenSum;
            return result;
        }

        private static int GetSumOfEvenDigits(long num)
        {
            return GetSumOfdigits(num,0);
        }

       

        private static int GetSumOfOddDigits(long num)
        {
            return GetSumOfdigits(num, 1);
        }

        private static int GetSumOfdigits(long num, int isOdd)
        {
            int sum = 0;
            foreach (var symbol in num.ToString())
            {
                int digit = symbol - '0';
                if (digit % 2 == isOdd)
                {
                    sum += digit;
                }
            }

            return sum;
        }
    }
}
