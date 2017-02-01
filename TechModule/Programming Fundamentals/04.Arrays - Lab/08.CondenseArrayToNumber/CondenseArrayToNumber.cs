using System;
using System.Linq;

class CondenseArrayToNumber
{
    static void Main(string[] args)
    {
        int[] array = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

        for (int i = array.Length - 1; i > 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                array[j] += array[j + 1];
            }
        }
        Console.WriteLine(array[0]);
    }
}

