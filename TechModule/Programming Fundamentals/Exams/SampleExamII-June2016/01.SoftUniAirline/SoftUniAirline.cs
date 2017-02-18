using System;

namespace _01.SoftUniAirline
{
    public class SoftUniAirline
    {
        public static void Main()
        {
            int numberOfFlights = int.Parse(Console.ReadLine());

            decimal overallProfit = 0m; 
            for (int i = 0; i < numberOfFlights; i++)
            {
                int adultsCount = int.Parse(Console.ReadLine());
                decimal adultTicketPrice = decimal.Parse(Console.ReadLine());
                int youthsCount = int.Parse(Console.ReadLine());
                decimal youthTicketPrice = decimal.Parse(Console.ReadLine());
                double fuelPricePerHour = double.Parse(Console.ReadLine());
                double fuelConsumptionPerHour = double.Parse(Console.ReadLine());
                int flightDuration = int.Parse(Console.ReadLine());

                decimal income = (adultsCount * adultTicketPrice) + (youthsCount * youthTicketPrice);
                decimal expences = (decimal)(flightDuration * fuelConsumptionPerHour * fuelPricePerHour);

                decimal profit = income - expences;
                if (profit>=0)
                {
                    Console.WriteLine($"You are ahead with {profit:F3}$.");
                }
                else
                {
                    Console.WriteLine($"We've got to sell more tickets! We've lost {profit:F3}$.");
                }

                overallProfit += profit;
            }
            decimal averageProfit = overallProfit / numberOfFlights;

            Console.WriteLine($"Overall profit -> {overallProfit:F3}$.");
            Console.WriteLine($"Average profit -> {averageProfit:F3}$.");
        }
    }
}
