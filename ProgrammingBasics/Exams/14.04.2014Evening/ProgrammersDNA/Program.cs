using System;

namespace ProgrammersDNA
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            char letter = char.Parse(Console.ReadLine());

            int block = 7;
            int mid = block / 2;
            int buf = 0;
            char spacer = '.';

            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < block; j++)
                {
                    if (j < mid - buf || j > mid + buf)
                        Console.Write(spacer);
                    else
                    {
                        Console.Write(letter);

                        if (letter == 'G')
                            letter = 'A';
                        else
                            letter++;
                    }
                }

                if (i % block >= mid)
                    buf--;
                else
                    buf++;


                if ((i+1) % block == 0 && i > 0)
                {
                    buf = 0;
                }
                Console.WriteLine();
            }
        }
    }
}
