using System;

namespace _08.OddEvenSum
{
    class Program
    {
        static void Main(string[] args)
        {
            int count = int.Parse(Console.ReadLine());
            int oddSum = 0;
            int evenSum = 0;

            for (int i = 0; i < count; i++)
            {
                if (i%2==0)
                {
                    evenSum += int.Parse(Console.ReadLine());
                }
                else
                {
                    oddSum += int.Parse(Console.ReadLine());
                }
            }

            if (oddSum==evenSum)
            {
                Console.WriteLine("Yes" + System.Environment.NewLine + "Sum = {0}", evenSum);
            }
            else
            {
                Console.WriteLine("No" + System.Environment.NewLine + "Diff = {0}", Math.Abs(evenSum-oddSum));
            }
        }
    }
}
