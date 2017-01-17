using System;

namespace _04.SoftuniCamp
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            double car = 0;
            double microbus = 0;
            double minibus = 0;
            double bus = 0;
            double train = 0;
            double all = 0;

            for (int i = 0; i < n; i++)
            {
                double count = double.Parse(Console.ReadLine());

                if (count <= 5)
                {
                    car += count;
                }
                else if (count > 5 && count < 13)
                {
                    microbus += count;
                }
                else if (count > 12 && count < 26)
                {
                    minibus += count;
                }
                else if (count > 25 && count < 41)
                {
                    bus += count;
                }
                else if (count > 40)
                {
                    train += count;
                }
                all += count;
            }

            Console.WriteLine("{0:F2}%", (car / all )* 100);
            Console.WriteLine("{0:F2}%", (microbus / all) * 100);
            Console.WriteLine("{0:F2}%", (minibus / all) * 100);
            Console.WriteLine("{0:F2}%", (bus / all) * 100);
            Console.WriteLine("{0:F2}%", (train / all) * 100);

        }
    }
}
