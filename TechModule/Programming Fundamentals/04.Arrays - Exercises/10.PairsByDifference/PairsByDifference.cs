using System;
using System.Linq;

class PairsByDifference
{
    static void Main()
    {
        int[] array = Console.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToArray();
        int diff = int.Parse(Console.ReadLine());

        int count = 0;
        for (int i = 0; i < array.Length; i++)
        {
            for (int j = i+1; j < array.Length; j++)
            {
                if (Math.Abs(array[i]-array[j])==diff)
                {
                    count++;
                }
            }
        }

        Console.WriteLine(count);
    }
}

