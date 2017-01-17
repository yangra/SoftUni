using System;

namespace _04.Logistics
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            double total = 0;
            double microbus = 0;
            double lorry = 0;
            double train = 0;

            for (int i = 0; i < n; i++)
            {
                double load = double.Parse(Console.ReadLine());
                if (load <= 3)
                {
                    microbus += load;
                }
                else if (load > 3 && load < 12)
                {
                    lorry += load;
                }
                else if (load >= 12)
                {
                    train += load;
                }

                total += load;
            }

            double average = (microbus * 200 + lorry * 175 + train * 120) / total;
            Console.WriteLine("{0:F2}", average);
            Console.WriteLine("{0:F2}%", (microbus / total) * 100);
            Console.WriteLine("{0:F2}%", (lorry / total) * 100);
            Console.WriteLine("{0:F2}%", (train / total) * 100);
        }
    }
}
