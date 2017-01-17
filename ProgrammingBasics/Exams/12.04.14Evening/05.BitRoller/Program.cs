using System;

namespace _05.BitRoller
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int f = int.Parse(Console.ReadLine());
            int r = int.Parse(Console.ReadLine());

            for (int i = 0; i < r; i++)
            {
                int fmask = 1;
                int mask = 262144;
                int firstBit = n & 1;
                int roll = 0;
                int rolled = 0;
                int fbit = 0;
                int next = 0;
                int fixedBit = 0;


                for (int j = 0; j < f; j++)
                {
                    fmask *= 2;
                }
                
                roll = n >> 1;
                if (fmask == 1)
                {
                    fbit = firstBit;
                    rolled = roll;
                }
                else
                {
                    if (firstBit > 0)
                    {
                        rolled = roll | mask;
                    }
                    else
                    {
                        rolled = roll & (~mask);
                    }
                }

                if (fmask!=1)
                {
                    fbit = n & fmask;
                }
                
                next = rolled & fmask;
                if (fbit > 0)
                {
                    fixedBit = rolled | fmask;
                    if (fmask == 1)
                    {
                        if (next > 0)
                        {
                            fixedBit = fixedBit | mask;
                        }
                        else
                        {
                            fixedBit = fixedBit & (~mask);
                        }

                    }
                    else
                    {
                        if (next > 0)
                        {
                            fixedBit = fixedBit | (fmask / 2);
                        }
                        else
                        {
                            fixedBit = fixedBit & (~(fmask / 2));
                        }
                    }
                }
                else
                {
                    fixedBit = rolled & ~fmask;
                    if (fmask == 1)
                    {
                        if (next > 0)
                        {
                            fixedBit = fixedBit | mask;
                        }
                        else
                        {
                            fixedBit = fixedBit & (~mask);
                        }

                    }
                    else
                    {
                        if (next > 0)
                        {
                            fixedBit = fixedBit | (fmask / 2);
                        }
                        else
                        {
                            fixedBit = fixedBit & (~(fmask / 2));
                        }
                    }
                }
                n = fixedBit;
            }
            Console.WriteLine(n);
        }
    }
}
