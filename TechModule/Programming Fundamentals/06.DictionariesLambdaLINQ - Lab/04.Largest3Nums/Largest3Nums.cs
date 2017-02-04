using System;
using System.Collections.Generic;
using System.Linq;

namespace _04.Largest3Nums
{
    class Largest3Nums
    {
        static void Main()
        {
            double[] nums = Console.ReadLine().Split(' ').Select(double.Parse).ToArray();
            var largest3nums = nums.OrderByDescending(x => x).Take(3);

            Console.WriteLine(string.Join(" ", largest3nums));
        }
    }
}
