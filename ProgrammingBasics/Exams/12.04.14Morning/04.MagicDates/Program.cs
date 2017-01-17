using System;

namespace _04.MagicDates
{
    class Program
    {
        static void Main(string[] args)
        {
            int startY = int.Parse(Console.ReadLine());
            int endY = int.Parse(Console.ReadLine());
            int weight = int.Parse(Console.ReadLine());

            int counter = 0;

            DateTime startYear = new DateTime(startY, 1, 1);
            DateTime endYear = new DateTime(endY, 12, 31);
            TimeSpan days = endYear - startYear;
            for (int i = 0; i <= days.Days; i++)
            {
                //string date = startYear.Date.ToString("ddMMyyyy");
                int day1 = startYear.Day / 10;
                int day2 = startYear.Day % 10;
                int month1 = startYear.Month / 10;
                int month2 = startYear.Month % 10;
                int year1 = (startYear.Year / 1000) % 10;
                int year2 = (startYear.Year / 100) % 10;
                int year3 = (startYear.Year / 10) % 10;
                int year4 = startYear.Year % 10;
                int magicWeight = day1 * (day2 + month1 + month2 + year1 + year2 + year3 + year4) +
                                day2 * (month1 + month2 + year1 + year2 + year3 + year4) +
                                month1 * (month2 + year1 + year2 + year3 + year4) +
                                month2 * (year1 + year2 + year3 + year4) +
                                year1 * (year2 + year3 + year4) +
                                year2 * (year3 + year4) + year3 * year4;

                if (magicWeight == weight)
                {
                    Console.WriteLine(startYear.Date.ToString("dd-MM-yyyy"));
                    counter++;
                }
                startYear = startYear.AddDays(1);
            }
            if (counter == 0)
            {
                Console.WriteLine("No");
            }

        }
    }
}
