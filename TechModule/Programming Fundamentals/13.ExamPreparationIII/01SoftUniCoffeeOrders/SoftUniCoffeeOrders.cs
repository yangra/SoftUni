using System;
using System.Globalization;

namespace _01SoftUniCoffeeOrders
{
    class SoftUniCoffeeOrders
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            decimal totalPrice = 0m;

            for (int i = 0; i < n; i++)
            {
                var pricePerCapsule = decimal.Parse(Console.ReadLine());
                var date = DateTime.ParseExact(Console.ReadLine(), "d/M/yyyy", CultureInfo.InvariantCulture);
                var capsuleCount = int.Parse(Console.ReadLine());

                int daysInMonth = DateTime.DaysInMonth(date.Year, date.Month);
                decimal currentPrice = (long)daysInMonth * capsuleCount * pricePerCapsule;
                totalPrice += currentPrice;
                Console.WriteLine("The price for the coffee is: ${0:F2}", currentPrice);
            }
            Console.WriteLine("Total: ${0:F2}", totalPrice);

        }
    }
}
