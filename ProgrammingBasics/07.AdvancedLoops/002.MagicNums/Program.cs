using System;

namespace _002.MagicNums
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            for (int d1 = 0; d1 < 10; d1++)
            {
                for (int d2 = 0; d2 < 10; d2++)
                {
                    for (int d3 = 0; d3 < 10; d3++)
                    {
                        for (int d4 = 0; d4 < 10; d4++)
                        {
                            for (int d5 = 0; d5 < 10; d5++)
                            {
                                for (int d6 = 0; d6 < 10; d6++)
                                {
                                    if (d1*d2*d3*d4*d5*d6 == n)
                                    {
                                        Console.Write("{0}{1}{2}{3}{4}{5} ",d1,d2,d3,d4,d5,d6);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
