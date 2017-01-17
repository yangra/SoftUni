using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _14.NumTab
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            for (int i = 1; i <= n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (i + j <= n)
                    {
                        Console.Write("{0} ", i + j);
                    }
                    else
                    {
                        Console.Write("{0} ", 2 * n - i - j);
                    }
                }
                Console.WriteLine();
            }
        }
    }
}
