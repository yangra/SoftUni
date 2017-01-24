using System;

namespace _06.ExchangeVariableValues
{
    class Program
    {
        static void Main(string[] args)
        {
            int a = int.Parse(Console.ReadLine());
            int b = int.Parse(Console.ReadLine());
            Console.WriteLine($"Before:\r\na = {a}\r\nb = {b}");
            int swap = a;
            a = b;
            b = swap;
            Console.WriteLine($"After:\r\na = {a}\r\nb = {b}");
        }
    }
}
