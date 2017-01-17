using System;

namespace _04.MagicNumbers
{
    class Program
    { 
        static void Main(string[] args)
        {
            int magicWeight = int.Parse(Console.ReadLine());
            int numCount = 0;
            char[] letters = { 'A', 'B', 'C', 'E', 'H', 'K', 'M', 'P', 'T', 'X' };

            for (int l1 = 0; l1 < letters.Length; l1++)
            {
                for (int l2 = 0; l2 < letters.Length; l2++)
                {
                    for (int a = 0; a <= 9; a++)
                    {
                        if ((40 + (4 * a) + 10 * (letters[l1] - 'A' + 1) + 10 * (letters[l2] - 'A' + 1)) == magicWeight)
                            numCount++;

                        for (int b = 0; b <= 9; b++)
                        {
                            if(b!=a)
                            {
                                if ((40 + a + (3 * b) + 10 * (letters[l1] - 'A' + 1) + 10 * (letters[l2] - 'A' + 1)) == magicWeight)
                                    numCount++;
                                if ((40 + b + (3 * a) + 10 * (letters[l1] - 'A' + 1) + 10 * (letters[l2] - 'A' + 1)) == magicWeight)
                                    numCount++;
                                if ((40 + (2 * a) + (2 * b) + 10 * (letters[l1] - 'A' + 1) + 10 * (letters[l2] - 'A' + 1)) == magicWeight)
                                    numCount+=3;
                            }
                        } 
                    }
                }
            }

            Console.WriteLine(numCount);
        }  
    }
}
