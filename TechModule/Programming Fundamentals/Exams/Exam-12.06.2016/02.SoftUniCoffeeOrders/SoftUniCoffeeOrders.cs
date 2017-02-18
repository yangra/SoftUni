using System;
using System.Globalization;

namespace _02.SoftUniCoffeeOrders
{
    public class SoftUniCoffeeOrders
    {
        public static void Main()
        {
            decimal totalPrice = 0;

            var n = int.Parse(Console.ReadLine());
            for (int i = 0; i < n; i++)
            {
                var pricePerCapsule = decimal.Parse(Console.ReadLine());
                var orderDate = DateTime.ParseExact(Console.ReadLine(), "d/M/yyyy", CultureInfo.InvariantCulture);
                var capsulesCount = long.Parse(Console.ReadLine());

                var orderPrice = DateTime.DaysInMonth(orderDate.Year, orderDate.Month) * capsulesCount * pricePerCapsule;

                Console.WriteLine($"The price for the coffee is: ${orderPrice:F2}");

                totalPrice += orderPrice;
            }

            Console.WriteLine($"Total: ${totalPrice:F2}");
        }
    }
}
