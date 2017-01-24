using System;

namespace _17.DifferentIntSizes
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();

            try
            {
                long num = long.Parse(input);
                Console.WriteLine("{0} can fit in:", num);
                if (num <= sbyte.MaxValue && num >= sbyte.MinValue)
                    Console.WriteLine("* sbyte");
                if (num <= byte.MaxValue && num >= byte.MinValue)
                    Console.WriteLine("* byte");
                if (num <= short.MaxValue && num >= short.MinValue)
                    Console.WriteLine("* short");
                if (num <= ushort.MaxValue && num >= ushort.MinValue)
                    Console.WriteLine("* ushort");
                if (num <= int.MaxValue && num >= int.MinValue)
                    Console.WriteLine("* int");
                if (num <= uint.MaxValue && num >= uint.MinValue)
                    Console.WriteLine("* uint");
                Console.WriteLine("* long");
            }
            catch (OverflowException)
            {
                Console.WriteLine($"{input} can't fit in any type");
            }
        }
    }
}
