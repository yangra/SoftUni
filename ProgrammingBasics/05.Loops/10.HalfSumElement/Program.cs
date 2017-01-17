using System;

namespace _10.HalfSumElement
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int sum = 0;
            int max = int.MinValue;

            for (int i = 0; i < n; i++)
            {
                int num = int.Parse(Console.ReadLine());
                sum += num;
                if (num > max)
                {
                    max = num;
                }
            }

            if (sum - max == max)
            {
                Console.WriteLine("Yes" + System.Environment.NewLine + "Sum = {0}", max);
            }
            else
            {
                Console.WriteLine("No" + System.Environment.NewLine + "Diff = {0}", Math.Abs(sum - 2 * max));
            }
        }
    }
}
