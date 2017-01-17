using System;

namespace _12.Fibonacci
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            if (n<2)
            {
                Console.WriteLine(1);
            }
            else
            {
                int firf = 1;
                int secf = 1;
                int nextf = 0;
                for (int i = 2; i <= n; i++)
                {
                    nextf = firf + secf;
                    firf = secf;
                    secf = nextf;
                }
                Console.WriteLine(nextf);
            }
        }
    }
}
