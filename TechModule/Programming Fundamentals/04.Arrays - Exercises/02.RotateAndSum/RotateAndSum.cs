using System;
using System.Linq;

class RotateAndSum
{
    static void Main(string[] args)
    {
        int[] array = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
        int times = int.Parse(Console.ReadLine());

        int[] rotated = new int[array.Length];
        int[] sum = new int[array.Length];

        for (int i = 0; i < times; i++)
        {
            rotated = Rotate(array);
            sum = SumArrays(rotated, sum);
        }

        Console.WriteLine(string.Join(" ", sum));
    }

    static int[] SumArrays(int[] array, int[] sum)
    {
        for (int i = 0; i < array.Length; i++)
        {
            sum[i] += array[i];
        }
        return sum;
    }

    static int[] Rotate(int[] array)
    {
        int lastElem = array[array.Length - 1];
        for (int i = array.Length - 1; i > 0; i--)
        {
            array[i] = array[i - 1];
        }
        array[0] = lastElem;
        return array;
    }
}

