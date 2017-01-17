using System;

namespace _10.CheckPrime
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            if (n<2)
            {
                Console.WriteLine("Not Prime");
            }
            else
            {
                for (int i = 2; i <= Math.Sqrt(n); i++)
                {
                    if (n%i==0)
                    {
                        Console.WriteLine("Not Prime");
                        return;
                    }
                }
                Console.WriteLine("Prime");
            }
        }
    }
}
