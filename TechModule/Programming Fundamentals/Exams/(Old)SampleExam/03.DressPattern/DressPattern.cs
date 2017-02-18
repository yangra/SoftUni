using System;

namespace _03.DressPattern
{
    public class DressPattern
    {
        public static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            Console.WriteLine("{0}.{0}.{0}", new string('_',4*n));
            for (int i = 0; i <  2*n; i++)
            {
                Console.WriteLine("{0}.{1}.{0}.{1}.{0}", new string('_', 4*n-2*(i+1) ), new string('*',  2 + 3 * i));
            }
            for (int i = 0; i < n; i++)
            {
                Console.WriteLine(".{0}.", new string('*', 12*n));
            }
            Console.WriteLine("{0}{1}{0}", new string('.',3*n), new string('*',6*n+2 ));
            for (int i = 0; i < n; i++)
            {
                Console.WriteLine("{0}{1}{0}", new string('_', 3 * n), new string('o', 6 * n + 2));
            }
            for (int i = 0; i < 3*n; i++)
            {
                Console.WriteLine("{0}.{1}.{0}", new string('_', 3 * n - i), new string('*', 6*n + 2 * i));
            }
            Console.WriteLine(new string('.', 12*n + 2));
        }
    }
}
