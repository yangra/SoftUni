using System;

namespace _02.OddEvenSum
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int sumOdd = 0;
            int sumEven = 0;

            for (int i = 0; i < 2*n; i++)
            {
                int num = int.Parse(Console.ReadLine());

                if (i%2==0)
                {
                    sumOdd += num;
                }
                else
                {
                    sumEven += num;
                }
            }
            if (sumEven==sumOdd)
            {
                Console.WriteLine("Yes, sum={0}",sumOdd);
            }
            else
            {
                Console.WriteLine("No, diff={0}", Math.Abs(sumOdd-sumEven));
            }
        }
    }
}
