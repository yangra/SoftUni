using System;

class TripleSum
{
    static void Main(string[] args)
    {
        string[] input = Console.ReadLine().Trim().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
        int[] array = new int[input.Length];

        for (int i = 0; i < array.Length; i++)
        {
            array[i] = int.Parse(input[i]);
        }

        bool found = false;
        for (int i = 0; i < array.Length; i++)
        {
            for (int j = i + 1; j < array.Length; j++)
            {
                for (int k = 0; k < array.Length; k++)
                {
                    if (array[i] + array[j] == array[k])
                    {
                        found = true;
                        Console.WriteLine("{0} + {1} == {2}", array[i], array[j], array[k]);
                        break;
                    }
                }
            }
        }

        if (!found)
        {
            Console.WriteLine("No");
        }
    }
}

