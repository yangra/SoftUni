using System;

namespace MethodsAndDebugging
{
    class MasterNumber
    {
        public static void Main(string[] args)
        {
            int limit = int.Parse(Console.ReadLine());

            for (int num = 1; num <= limit; num++)
            {
                if (IsSymmetric(num) && SumOfDigits(num) % 7 == 0 && HasEvenDigit(num))
                {
                    Console.WriteLine(num);
                }
            }
        }

        public static bool IsSymmetric(int number)
        {
            int num = number;
            int reversed = 0;
            while (num > 0)
            {
                int digit = num % 10;
                reversed = reversed * 10 + digit;
                num /= 10;
            }
            if (number == reversed)
                return true;
            else
                return false;

        }

        public static bool HasEvenDigit(int number)
        {
            bool hasEvenDigit = false;
            foreach (var symbol in number.ToString())
            {
                if ((symbol-'0')%2==0)
                {
                    hasEvenDigit = true;
                }
            }
            return hasEvenDigit;
        }

        public static int SumOfDigits(int number)
        {
            int sum = 0;
            foreach (var symbol in number.ToString())
            {
                sum += symbol - '0';
            }
            return sum;

        }
    }
}
