using System;
using System.Linq;

class EqualSums
{
    static void Main()
    {
        int[] array = Console.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToArray();

        bool exists = false;
        for (int i = 0; i < array.Length; i++)
        {
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j < i; j++)
            {
                leftSum += array[j];
            }

            for (int j = i + 1; j < array.Length; j++)
            {
                rightSum += array[j];
            }

            if (leftSum == rightSum)
            {
                Console.WriteLine(i);
                exists = true;
                break;
            }
        }

        if (!exists)
        {
            Console.WriteLine("no");
        }
    }
}

