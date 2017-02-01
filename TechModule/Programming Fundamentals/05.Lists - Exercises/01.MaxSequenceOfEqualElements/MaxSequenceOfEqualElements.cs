using System;
using System.Collections.Generic;
using System.Linq;

class MaxSequenceOfEqualElements
{
    static void Main()
    {
        int[] numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

        List<int> currentSeq = new List<int>();
        List<int> longestSeq = new List<int>();

        currentSeq.Add(numbers[0]);
        for (int i = 1; i < numbers.Length; i++)
        {
            if (currentSeq[0] == numbers[i])
            {
                currentSeq.Add(numbers[i]);
            }
            else
            {
                if (currentSeq.Count > longestSeq.Count)
                {
                    longestSeq = new List<int>();
                    for (int j = 0; j < currentSeq.Count; j++)
                    {
                        longestSeq.Add(currentSeq[j]);
                    }
                }
                currentSeq = new List<int>();
                currentSeq.Add(numbers[i]);
            }

            if (currentSeq.Count > longestSeq.Count)
            {
                longestSeq = new List<int>();
                for (int j = 0; j < currentSeq.Count; j++)
                {
                    longestSeq.Add(currentSeq[j]);
                }
            }

        }

        Console.WriteLine(string.Join(" ", longestSeq));
    }
}


