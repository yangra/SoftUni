using System;

namespace _001.Histogram1
{
    class Program
    {
        static void Main(string[] args)
        {
            int count = int.Parse(Console.ReadLine());

            double p1 = 0;
            double p2 = 0;
            double p3 = 0;
            double p4 = 0;
            double p5 = 0;

            for (int i = 0; i < count; i++)
            {
                int num = int.Parse(Console.ReadLine());
                if (num >= 0 && num < 200)
                    p1++;
                else if (num >= 200 && num < 400)
                    p2++;
                else if (num >= 400 && num < 600)
                    p3++;
                else if (num >= 600 && num < 800)
                    p4++;
                else if (num >= 800 && num <= 1000)
                    p5++;
                else
                    Console.WriteLine("Invalid number");
            }
            Console.WriteLine("{0:f2}%",(p1/count)*100);
            Console.WriteLine("{0:f2}%", (p2 / count) * 100);
            Console.WriteLine("{0:f2}%", (p3 / count) * 100);
            Console.WriteLine("{0:f2}%", (p4 / count) * 100);
            Console.WriteLine("{0:f2}%", (p5 / count) * 100);
        }
    }
}
