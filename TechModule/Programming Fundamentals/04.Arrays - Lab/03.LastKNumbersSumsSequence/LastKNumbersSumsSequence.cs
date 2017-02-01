using System;

class LastKNumbersSumsSequence
{
    static void Main(string[] args)
    {
        int lengthOfSeq = int.Parse(Console.ReadLine());
        int numbersToSum = int.Parse(Console.ReadLine());

        long[] seq = new long[numbersToSum];
        seq[0] = 1;
        Console.Write("{0} ", seq[0]);

        for (int i = 1; i < lengthOfSeq; i++)
        {
            long sum = 0;
            for (int j = 0; j < numbersToSum; j++)
            {
                sum += seq[j];
            }
            Console.Write("{0} ", sum);
            seq[i % numbersToSum] = sum;
        }
    }
}

