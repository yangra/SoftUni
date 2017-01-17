using System;

namespace _06.MinNumber
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int min = int.Parse(Console.ReadLine());
            for (int i = 0; i < n-1; i++)
            {
                int num = int.Parse(Console.ReadLine());
                if (min>num)
                {
                    min = num;
                }
            }
            Console.WriteLine(min);
        }
    }
}
