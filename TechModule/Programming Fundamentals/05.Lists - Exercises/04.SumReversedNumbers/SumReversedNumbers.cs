using System;
using System.Collections.Generic;
using System.Linq;

namespace _04.SumReversedNumbers
{
    class SumReversedNumbers
    {
        static void Main()
        {
            List<string> nums = Console.ReadLine().Split(' ').ToList();
            int sum = 0;
            for (int i = 0; i < nums.Count; i++)
            {
                string reversedNum = string.Empty;
                for (int j = 0; j < nums[i].Length; j++)
                {
                    reversedNum += nums[i][nums[i].Length - 1 - j];
                }

                int revNum = int.Parse(reversedNum);
                sum += revNum;
            }

            Console.WriteLine(sum);

        }
    }
}
