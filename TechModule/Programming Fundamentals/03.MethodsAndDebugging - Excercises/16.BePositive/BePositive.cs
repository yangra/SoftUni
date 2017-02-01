using System;
using System.Collections.Generic;

public class BePositive_broken
{
    public static void Main()
    {
        int countSequences = int.Parse(Console.ReadLine());

        for (int i = 0; i < countSequences; i++)
        {
            string[] input = Console.ReadLine().Trim().Split(' ');
            var numbers = new List<int>();
            AddNumbersToList(input, numbers);

            bool found = false;

            for (int j = 0; j < numbers.Count; j++)
            {
                int currentNum = numbers[j];

                if (currentNum >= 0)
                {
                    found = PrintPositiveNumber(found, currentNum);
                }
                else
                {
                    if (j + 1 < numbers.Count)
                    {
                        currentNum += numbers[j + 1];
                        if (currentNum >= 0)
                        {
                            found = PrintPositiveNumber(found, currentNum);
                        }
                    }

                    j++;
                }
            }

            if (!found)
            {
                Console.Write("(empty)");
            }

            Console.WriteLine();
        }
    }

    public static void AddNumbersToList(string[] input, List<int> numbers)
    {
        for (int j = 0; j < input.Length; j++)
        {
            if (!input[j].Equals(string.Empty))
            {
                int num = int.Parse(input[j]);
                numbers.Add(num);
            }
        }
    }

    public static bool PrintPositiveNumber(bool found, int currentNum)
    {
        if (found)
        {
            Console.Write(" ");
        }

        Console.Write(currentNum);
        found = true;
        return found;
    }
}