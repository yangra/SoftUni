using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _003.StopSign
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            Console.Write(new string('.', n + 1));
            Console.Write(new string('_', 2 * n + 1));
            Console.WriteLine(new string('.', n + 1));
            for (int i = 0; i < n; i++)
            {
                Console.Write(new string('.', n - i));
                Console.Write("//");
                Console.Write(new string('_', 2 * n - 1 + 2 * i));
                Console.Write("\\\\");
                Console.WriteLine(new string('.', n - i));
            }
            Console.Write("//");
            Console.Write(new string('_', 2 * n - 3));
            Console.Write("STOP!");
            Console.Write(new string('_', 2 * n - 3));
            Console.WriteLine("\\\\");
            for (int i = 0; i < n; i++)
            {
                Console.Write(new string('.',  i));
                Console.Write("\\\\");
                Console.Write(new string('_',4 * n - 1 - 2 * i));
                Console.Write("//");
                Console.WriteLine(new string('.',  i));
            }
        }
    }
}
