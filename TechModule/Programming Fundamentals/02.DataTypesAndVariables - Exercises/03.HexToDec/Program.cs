using System;

namespace _03.HexToDec
{
    class Program
    {
        static void Main(string[] args)
        {
            string hex = Console.ReadLine();
            int dec = Convert.ToInt32(hex, 16);
            Console.WriteLine(dec);
        }
    }
}
