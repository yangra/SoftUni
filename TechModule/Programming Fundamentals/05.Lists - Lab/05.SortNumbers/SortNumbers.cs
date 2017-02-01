using System;
using System.Collections.Generic;

class SortNumbers
{
    static void Main()
    {
        string[] input = Console.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
        List<decimal> numbers = new List<decimal>();

        for (int i = 0; i < input.Length; i++)
        {
            numbers.Add(decimal.Parse(input[i]));
        }

        numbers.Sort();
        Console.WriteLine(string.Join(" <= ", numbers));
    }
}

