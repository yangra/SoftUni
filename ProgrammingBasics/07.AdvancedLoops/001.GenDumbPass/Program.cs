using System;

namespace _001.GenDumbPass
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int l = int.Parse(Console.ReadLine());

            for (int a = 1; a <= n; a++)
            {
                for (int b = 1; b <= n; b++)
                {
                    for (char c = 'a'; c < 'a'+l; c++)
                    {
                        for (char d = 'a'; d < 'a'+l; d++)
                        {
                            for (int e = 1; e <= n; e++)
                            {
                                if (e>a&&e>b)
                                {
                                    Console.Write("{0}{1}{2}{3}{4} ", a,b,c,d,e);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
