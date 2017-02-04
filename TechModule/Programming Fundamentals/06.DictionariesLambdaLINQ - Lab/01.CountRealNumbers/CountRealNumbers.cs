using System;
using System.Collections.Generic;
using System.Linq;

namespace _01.CountRealNumbers
{
    class CountRealNumbers
    {
        static void Main(string[] args)
        {
            double[] nums = Console.ReadLine().Split(' ').Select(double.Parse).ToArray();
            SortedDictionary<double, int> counts = new SortedDictionary<double, int>();
            
            for (int i = 0; i < nums.Length; i++)
            {
                var currentNumber = nums[i];
                if (!counts.ContainsKey(currentNumber))
                {
                    counts[currentNumber] = 0; 
                }
                
                counts[currentNumber]++;
            }

            foreach (var pair in counts)
            {
                Console.WriteLine($"{pair.Key} -> {pair.Value}");
            }
        }
    }
}
