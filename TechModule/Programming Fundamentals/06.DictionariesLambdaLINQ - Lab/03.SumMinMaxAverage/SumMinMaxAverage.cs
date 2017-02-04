using System;
using System.Collections.Generic;
using System.Linq;

namespace _03.SumMinMaxAverage
{
    class SumMinMaxAverage
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            List<int> nums = new List<int>();
            for (int i = 0; i < n; i++)
            {
                int number = int.Parse(Console.ReadLine());
                nums.Add(number);
            }

            var sum = nums.Sum();
            var min = nums.Min();
            var max = nums.Max();
            var avg = nums.Average();

            Console.WriteLine($"Sum = {sum}");
            Console.WriteLine($"Min = {min}");
            Console.WriteLine($"Max = {max}");
            Console.WriteLine($"Average = {avg}");
        }
    }
}
