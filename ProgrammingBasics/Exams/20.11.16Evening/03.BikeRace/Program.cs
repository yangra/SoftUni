using System;

namespace _03.BikeRace
{
    class Program
    {
        static void Main(string[] args)
        {
            int juniors = int.Parse(Console.ReadLine());
            int seniors = int.Parse(Console.ReadLine());
            string trace = Console.ReadLine();

            double total = 0;
            if (trace=="trail")
            {
                total = (juniors*5.5+seniors*7)*0.95;
            }
            else if (trace=="cross-country")
            {
                if (juniors+seniors>=50)
                {
                    total = (juniors * 8 + seniors * 9.5) * 0.75 * 0.95;
                }
                else
                {
                    total = (juniors * 8 + seniors * 9.5) * 0.95;
                }
            }
            else if (trace=="downhill")
            {
                total = (juniors * 12.25 + seniors * 13.75) * 0.95;
            }
            else if (trace=="road")
            {
                total = (juniors * 20 + seniors * 21.50) * 0.95;
            }

            Console.WriteLine("{0:F2}", total);
        }
    }
}
