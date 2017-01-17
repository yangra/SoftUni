using System;

namespace _11.OddEvenPosition
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            double oddSum = 0;
            double oddMax = double.MinValue;
            double oddMin = double.MaxValue;
            double evenSum = 0;
            double evenMax = double.MinValue;
            double evenMin = double.MaxValue;
            int oddFlag = 0;
            int evenFlag = 0;
            for (int i = 1; i <= n; i++)
            {
                double num = double.Parse(Console.ReadLine());
                if (i%2==0)
                {
                    evenFlag++;
                    MinMaxSum(ref evenMin, ref evenMax, ref evenSum, num);
                }
                else
                {
                    oddFlag++;
                    MinMaxSum(ref oddMin, ref oddMax, ref oddSum, num);
                }   
            }
            if (oddFlag!=0)
            {
                Console.WriteLine("OddSum={0},", oddSum);
                Console.WriteLine("OddMin={0},", oddMin);
                Console.WriteLine("OddMax={0},", oddMax);
            }
            else
            {
                Console.WriteLine("OddSum={0},", oddSum);
                Console.WriteLine("OddMin=No,");
                Console.WriteLine("OddMax=No,");
            }
            if (evenFlag!=0)
            {
                Console.WriteLine("EvenSum={0},", evenSum);
                Console.WriteLine("EvenMin={0},", evenMin);
                Console.WriteLine("EvenMax={0}", evenMax);
            }
            else
            {
                Console.WriteLine("EvenSum={0},", evenSum);
                Console.WriteLine("EvenMin=No,");
                Console.WriteLine("EvenMax=No");
            }
        }

        static void MinMaxSum(ref double min,ref double max, ref double sum, double num)
        {
            sum += num;
            if (num > max)
            {
                max = num;
            }
            if (min > num)
            {
                min = num;
            }
        }
    }
}
