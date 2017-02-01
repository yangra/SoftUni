using System;

namespace MethodsAndDebugging
{
    public class NumbersInRreversedOrder
    {
        public static void Main()
        {
            string num = Console.ReadLine();

            double reversed = GetReversed(num);
            Console.WriteLine(reversed);
        }

        public static double GetReversed(string num)
        {
            string rev = string.Empty;
            for (int i = num.Length-1; i >= 0; i--)
            {
                rev += num[i];
            }

            double revNum = double.Parse(rev);
            return revNum;
        }
    }
}
