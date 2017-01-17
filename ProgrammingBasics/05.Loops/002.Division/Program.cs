using System;

namespace _002.Division
{
    class Program
    {
        static void Main(string[] args)
        {
            int count = int.Parse(Console.ReadLine());
            double p1 = 0;
            double p2 = 0;
            double p3 = 0;

            for (int i = 0; i < count; i++)
            {
                int num = int.Parse(Console.ReadLine());
                if (num % 2 == 0)
                    p1++;
                if (num % 3 == 0)
                    p2++;
                if (num % 4 == 0)
                    p3++;
            }
            Console.WriteLine("{0:f2}%", (p1 / count) * 100);
            Console.WriteLine("{0:f2}%", (p2 / count) * 100);
            Console.WriteLine("{0:f2}%", (p3 / count) * 100);
        }
    }
}
