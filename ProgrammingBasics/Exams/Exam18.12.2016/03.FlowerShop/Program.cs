using System;


namespace _03.FlowerShop
{
    class Program
    {
        static void Main(string[] args)
        {
            int hrisantemas = int.Parse(Console.ReadLine());
            int roses = int.Parse(Console.ReadLine());
            int tulips = int.Parse(Console.ReadLine());
            string season = Console.ReadLine();
            string isHoliday = Console.ReadLine();

            double total = 0;

            if (season=="Spring"||season=="Summer")
            {
                if (isHoliday=="Y")
                {
                    total = hrisantemas * 2.00*1.15 + roses * 4.1*1.15 + tulips * 2.5*1.15;
                }
                else
                {
                    total = hrisantemas * 2.00 + roses * 4.1 + tulips * 2.5;
                }

                if (season=="Spring"&&tulips>7)
                {
                    total *= 0.95;
                }

                if (hrisantemas+roses+tulips>20)
                {
                    total *= 0.8;
                }
                total += 2;

            }
            else
            {
                if (isHoliday == "Y")
                {
                    total = hrisantemas * 3.75 * 1.15 + roses * 4.5 * 1.15 + tulips * 4.15 * 1.15;
                }
                else
                {
                    total = hrisantemas * 3.75 + roses * 4.5 + tulips * 4.15;
                }

                if (season == "Winter" && roses >= 10)
                {
                    total *= 0.90;
                }

                if (hrisantemas + roses + tulips > 20)
                {
                    total *= 0.8;
                }
                total += 2;
            }

            Console.WriteLine("{0:F2}", total);
        }
    }
}
