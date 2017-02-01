using System;
using System.Linq;


class SumArrays
{
    static void Main(string[] args)
    {
        int[] arrayA = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
        int[] arrayB = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

        if (arrayA.Length >= arrayB.Length)
        {
            for (int i = 0; i < arrayA.Length; i++)
            {
                arrayA[i] += arrayB[i % (arrayB.Length)];
                Console.Write("{0} ", arrayA[i]);
            }
        }
        else
        {
            for (int i = 0; i < arrayB.Length; i++)
            {
                arrayB[i] += arrayA[i % (arrayA.Length)];
                Console.Write("{0} ", arrayB[i]);
            }
        }
    }
}

