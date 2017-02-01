using System;
using System.Collections.Generic;
using System.Linq;

class SumAdjasentEqualNumbers
{
    static void Main()
    {
        List<double> numbers = Console.ReadLine().Split(' ').Select(double.Parse).ToList();

        for (int i = 0; i < numbers.Count - 1; i++)
        {
            if (numbers[i] == numbers[i + 1])
            {
                numbers[i] *= 2;
                numbers.Remove(numbers[i + 1]);
                if (i > 0)
                {
                    i -= 2;
                }
                else
                {
                    i -= 1;
                }
            }
        }

        Console.WriteLine(string.Join(" ", numbers));
    }
}

