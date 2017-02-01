using System;
using System.Collections.Generic;
using System.Linq;

class SquareNumbers
{
    static void Main(string[] args)
    {
        int[] input = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
        List<int> squares = new List<int>();
        for (int i = 0; i < input.Length; i++)
        {
            double sqrt = Math.Sqrt(input[i]);
            if (sqrt == (int)sqrt)
            {
                squares.Add(input[i]);
            }
        }

        squares.Sort((a, b) => b.CompareTo(a));
        Console.WriteLine(string.Join(" ", squares));
    }
}

