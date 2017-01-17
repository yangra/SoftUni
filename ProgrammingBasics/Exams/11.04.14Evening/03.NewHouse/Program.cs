using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.NewHouse
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            for (int i = 0; i < n - n / 2; i++)
            {
                Console.Write(new string('-', (n / 2) - i));
                Console.Write(new string('*', 2 * i + 1));
                Console.WriteLine(new string('-', (n / 2) - i));
            }

            for (int j = 0; j < n; j++)
            {
                Console.Write('|');
                Console.Write(new string('*', n - 2));
                Console.WriteLine('|');
            }

        }
    }
}
