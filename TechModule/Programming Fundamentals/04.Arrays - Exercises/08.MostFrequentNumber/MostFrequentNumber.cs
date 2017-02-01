using System;
using System.Linq;

class MostFrequentNumber
{
    static void Main()
    {
        int[] array = Console.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToArray();

        int maxCount = 0;
        int mostFreq = 0;
        for (int i = 0; i < array.Length; i++)
        {
            int count = 0;
            int element = array[i];
            for (int j = 0; j < array.Length; j++)
            {
                if (element == array[j])
                {
                    count++;
                }
            }

            if (count > maxCount)
            {
                maxCount = count;
                mostFreq = element;
            }
        }

        Console.WriteLine("{0}", mostFreq);
    }
}

