using System;
using System.Collections.Generic;
using System.Linq;


namespace _06.FoldAndSum
{
    class FoldAndSum
    {
        static void Main()
        {
            int[] nums = Console.ReadLine().Split(' ').Select(num => int.Parse(num)).ToArray();
            int k = nums.Length / 4;

            int[] row1left = nums.Take(k).Reverse().ToArray();
            int[] row1right = nums.Reverse().Take(k).ToArray();
            int[] row1 = row1left.Concat(row1right).ToArray();
            int[] row2 = nums.Skip(k).Take(2 * k).ToArray();
            int[] result = row1.Select((x, index) => x + row2[index]).ToArray();
            Console.WriteLine(string.Join(" ", result));
        }
    }
}
