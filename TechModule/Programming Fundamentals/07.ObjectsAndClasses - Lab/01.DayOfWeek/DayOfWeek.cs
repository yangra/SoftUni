using System;
using System.Globalization;

namespace _01.DayOfWeek
{
    public class DayOfWeek
    {
        public static void Main()
        {
            string dateAsString = Console.ReadLine();
            DateTime date = DateTime.ParseExact(dateAsString, "d-M-yyyy", CultureInfo.InvariantCulture);
            Console.WriteLine(date.DayOfWeek);
        }
    }
}
