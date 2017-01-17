using System;

namespace _12.EqualPairs
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            double sum = 0;
            double maxDiff = 0;
            double prevSum = 0;
            for (int i = 0; i < n; i++)
            {
                double num1 = double.Parse(Console.ReadLine());
                double num2 = double.Parse(Console.ReadLine());
                sum = num1 + num2;
                if (i>0)
                {
                    double diff = Math.Abs(sum - prevSum);
                    if (diff>maxDiff)
                    {
                        maxDiff = diff;
                    }
                }
                prevSum = sum;

                
            }
            if (maxDiff==0)
            {
                Console.WriteLine("Yes, value={0}",sum);
            }else
            {
                Console.WriteLine("No, maxdiff={0}",maxDiff);
            }
        }
    }
}
