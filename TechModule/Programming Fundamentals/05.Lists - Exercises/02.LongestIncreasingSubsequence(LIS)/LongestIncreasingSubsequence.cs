using System;
using System.Collections.Generic;
using System.Linq;

class LongestIncreasingSubsequence
{
    static void Main(string[] args)
    {
        List<int> nums = Console.ReadLine().Split(' ').Select(int.Parse).ToList();

        int[] len = new int[nums.Count];
        int[] prev = new int[nums.Count];
        len[0] = 1;
        prev[0] = -1;
        for (int i = 0; i < nums.Count; i++)
        {
            int length = 0;
            int maxLen = 0;
            bool found = false;
            for (int j = 0; j < i; j++)
            {
                if (nums[i] > nums[j])
                {
                    length = len[j] + 1;
                    found = true;
                }
                if (length > maxLen)
                {
                    maxLen = length;
                    prev[i] = j;
                }
            }

            len[i] = maxLen;
            if (!found)
            {
                prev[i] = -1;
                len[i] = 1;
            }

        }

        int bestLen = 0;
        int bestIndex = 0;
        for (int i = 0; i < len.Length; i++)
        {
            if (len[i] > bestLen)
            {
                bestLen = len[i];
                bestIndex = i;
            }

        }

        List<int> LIS = new List<int>();

        for (int i = 0; i < bestLen; i++)
        {
            LIS.Add(nums[bestIndex]);
            bestIndex = prev[bestIndex];
        }

        LIS.Reverse();
        Console.WriteLine(string.Join(" ", LIS));
    }


}
