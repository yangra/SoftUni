using System;
using System.Linq;

class FoldAndSum
{
    static void Main()
    {
        int[] array = Console.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToArray();

        int n = array.Length / 4;
        int[] firstRow = new int[2 * n];

        for (int i = 0; i < n; i++)
        {
            firstRow[i] = array[n - 1 - i];
        }

        for (int i = n; i < 2 * n; i++)
        {
            firstRow[i] = array[5 * n - 1 - i];
        }

        for (int i = n; i < 3 * n; i++)
        {
            Console.Write($"{firstRow[i-n] + array[i]} ");
        }

    }
}

