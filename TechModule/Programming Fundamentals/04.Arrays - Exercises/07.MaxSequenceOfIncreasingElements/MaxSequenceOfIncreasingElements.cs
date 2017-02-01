using System;
using System.Linq;

class MaxSequenceOfIncreasingElements
{
    static void Main()
    {
        int[] array = Console.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToArray();

        int bestCount = 0;
        int bestIndex = 0;
        for (int i = 0; i < array.Length; i++)
        {
            int count = 1;
            int index = 0;
            while (i + 1 < array.Length && array[i] < array[i + 1])
            {
                if (count == 1)
                {
                    index = i;
                }

                count++;
                i++;
            }

            if (count > bestCount)
            {
                bestCount = count;
                bestIndex = index;
            }
        }

        for (int i = bestIndex; i < bestIndex + bestCount; i++)
        {
            Console.Write("{0} ", array[i]);
        }
    }
}

