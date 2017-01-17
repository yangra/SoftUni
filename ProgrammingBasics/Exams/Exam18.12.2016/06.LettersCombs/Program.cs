using System;

namespace _06.LettersCombs
{
    class Program
    {
        static void Main(string[] args)
        {
            char start = char.Parse(Console.ReadLine());
            char end = char.Parse(Console.ReadLine());
            char skip = char.Parse(Console.ReadLine());

            int count = 0;

            for (char i = start; i <= end; i++)
            {
                for (char j = start; j <= end; j++)
                {
                    for (char k = start; k <= end; k++)
                    {
                        if (i != skip && j != skip && k != skip)
                        {
                            Console.Write("{0}{1}{2} ", i, j, k);
                            count++;
                        }
                    }

                }
            }
            Console.Write(count);

        }
    }
}
