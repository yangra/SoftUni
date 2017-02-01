using System;
using System.Collections.Generic;

class RemoveNegativesAndReverse
{
    static void Main()
    {
        string[] input = Console.ReadLine().Split(' ');
        List<int> numbers = new List<int>();
        for (int i = 0; i < input.Length; i++)
        {
            int number = int.Parse(input[i]);
            if (number >= 0)
            {
                numbers.Add(number);
            }
        }

        numbers.Reverse();
        if (numbers.Count > 0)
        {
            Console.WriteLine(string.Join(" ", numbers));
        }
        else
        {
            Console.WriteLine("empty");
        }

    }
}

