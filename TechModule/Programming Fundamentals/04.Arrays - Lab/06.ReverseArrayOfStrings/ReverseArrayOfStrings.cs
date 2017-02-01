using System;
using System.Linq;

class ReverseArrayOfStrings
{
    static void Main(string[] args)
    {
        string[] array = Console.ReadLine().Split(' ').ToArray();

        for (int i = 0; i < array.Length / 2; i++)
        {
            SwapElements(array, i, array.Length - 1 - i);
        }

        Console.WriteLine(String.Join(" ", array));
    }

    private static void SwapElements(string[] array, int i, int j)
    {
        string swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }
}

