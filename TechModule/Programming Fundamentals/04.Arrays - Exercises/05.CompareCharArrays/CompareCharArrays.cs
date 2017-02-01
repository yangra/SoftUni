using System;
using System.Linq;

class CompareCharArrays
{
    static void Main()
    {
        char[] arrFirst = Console.ReadLine().Split(' ').Select(char.Parse).ToArray();
        char[] arrSecond = Console.ReadLine().Split(' ').Select(char.Parse).ToArray();

        bool isInOrder = IsInOrder(arrFirst, arrSecond);
        if (isInOrder)
        {
            Console.WriteLine(string.Join("", arrFirst));
            Console.WriteLine(string.Join("", arrSecond));
        }
        else
        {
            Console.WriteLine(string.Join("", arrSecond));
            Console.WriteLine(string.Join("", arrFirst));
        }

    }

    public static bool IsInOrder(char[] a, char[] b)
    {
        for (int i = 0; i < Math.Min(a.Length, b.Length); i++)
        {
            if (a[i] == b[i])
            {
                continue;
            }

            if (a[i] > b[i])
            {
                return false;
            }

            return true;

        }

        if (a.Length <= b.Length)
        {
            return true;
        }

        return false;
    }
}

