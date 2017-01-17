using System;

namespace _05.MaxNumber
{
    class Program
    {
        static void Main(string[] args)
        {
            int count = int.Parse(Console.ReadLine());
            int max = int.MinValue;
            for (int i = 0; i < count; i++)
            {
                int number = int.Parse(Console.ReadLine());
                if (number>max)
                {
                    max = number;
                }
            }
            Console.WriteLine(max);
        }
    }
}
