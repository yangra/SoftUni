using System;

namespace _16.PrintASCII
{
    class Program
    {
        static void Main(string[] args)
        {
            int start = int.Parse(Console.ReadLine());
            int end = int.Parse(Console.ReadLine());

            for (int symbol = start; symbol <= end; symbol++)
            {
                Console.Write("{0} ", (char)symbol);
            }
        }
    }
}
