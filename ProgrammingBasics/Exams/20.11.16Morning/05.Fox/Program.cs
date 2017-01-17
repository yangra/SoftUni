using System;

namespace _05.Fox
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            for (int i = 1; i <= n; i++)
            {
                Console.WriteLine("{0}\\{1}/{0}", 
                    new string('*',i),new string('-',2*(n-i)+1));
            }

            for (int i = 0; i < n/3; i++)
            {
                Console.WriteLine("|{0}\\{1}/{0}|", 
                    new string('*',n/2+i), new string('*',2*n-2*(n/2+i)-1));
            }
            for (int i = 1; i <= n; i++)
            {
                Console.WriteLine("{0}\\{1}/{0}",
                    new string('-', i), new string('*', 2 * (n - i) + 1));
            }
        }
    }
}
