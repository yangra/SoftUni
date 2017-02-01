using System;

class LargestCommonEnd
{
    static void Main(string[] args)
    {
        string[] first = Console.ReadLine().Split(' ');
        string[] second = Console.ReadLine().Split(' ');

        int lrCount = 0;
        for (int i = 0; i < Math.Min(first.Length, second.Length); i++)
        {
            if (first[i].CompareTo(second[i]) == 0)
            {
                lrCount++;
            }
            else
            {
                break;
            }
        }

        int rlCount = 0;
        for (int i = first.Length - 1, j = second.Length - 1; i >= 0 && j >= 0; i--, j--)
        {
            if (first[i].CompareTo(second[j]) == 0)
            {
                rlCount++;
            }
            else
            {
                break;
            }
        }

        Console.WriteLine(Math.Max(lrCount, rlCount));
    }

}

